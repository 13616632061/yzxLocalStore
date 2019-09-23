package com.yzx.yzxlocalstore.ui.Fragment.OrderListFragment.presenter;

import android.util.Log;

import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.OrderInfo;
import com.yzx.yzxlocalstore.greendao.GreenDaoHelp;
import com.yzx.yzxlocalstore.ui.Adapter.OrderListFragmentAdapter;
import com.yzx.yzxlocalstore.ui.Fragment.OrderListFragment.model.OrderListFragmentModel;
import com.yzx.yzxlocalstore.ui.Fragment.OrderListFragment.view.OrderListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/9/18.
 */

public class OrderListFragmentPresenter implements IOrderListFragmentPresenterImp {
    private final static String TAG = OrderListFragmentPresenter.class.getSimpleName();
    private OrderListFragment mView;
    private OrderListFragmentModel mModel;
    private OrderListFragmentAdapter mAdapter;
    private List<OrderInfo> mData = new ArrayList<>();

    private int mType;
    private int mPage = 1;
    private int mLimitPageNum = 20;
    private int mOrderType;//订单类型
    private boolean allSelectStatus = true;//是否全选


    public OrderListFragmentPresenter(OrderListFragment mView) {
        this.mView = mView;
        mModel = new OrderListFragmentModel();
    }


    /**
     * 初始化订单列表
     */
    @Override
    public void initOrderListFragmentAdapter() {
        mAdapter = mView.initOrderListFragmentAdapter();
    }

    /**
     * 获取订单类别类型
     *
     * @param type 今天订单：0，昨日订单：1，全部订单：2
     */
    @Override
    public void setOrderListType(int type) {
        mOrderType = type;
    }

    /**
     * 获取订单数据
     *
     * @return
     */
    @Override
    public List<OrderInfo> getData() {
        return mData;
    }

    /**
     * 获取订单列表信息
     *
     * @param page 页数
     * @param type 订单类型
     */
    @Override
    public void getOrderListInfo(int page, int type) {
        mType = type;
        mPage = page;
//        GreenDaoHelp.getDaoSession().getOrderInfoDao().deleteAll();
        Log.e(TAG, "mOrderType: " + mOrderType);
        List<OrderInfo> goodsInfoList = mModel.getOrderListInfo(page, type, mOrderType);
        mData.clear();
        mData.addAll(goodsInfoList);
        mAdapter.notifyDataSetChanged();
        switch (type) {
            case 0://全部订单
                mView.setAllOrderNum(mModel.getOrderNum(0, mOrderType) + "");
                setSelectOrderType(1, 0, 0, 0, 0);
                break;
            case 1://未支付订单
                mView.setNoPayOrder(mModel.getOrderNum(1, mOrderType) + "");
                setSelectOrderType(0, 1, 0, 0, 0);
                break;
            case 2://已完成订单
                mView.setCompletedOrder(mModel.getOrderNum(2, mOrderType) + "");
                setSelectOrderType(0, 0, 1, 0, 0);
                break;
            case 3://挂单
                mView.setPutOrder(mModel.getOrderNum(3, mOrderType) + "");
                setSelectOrderType(0, 0, 0, 1, 0);
                break;
            case 4://已作废订单
                mView.setInvalidOrder(mModel.getOrderNum(4, mOrderType) + "");
                setSelectOrderType(0, 0, 0, 0, 1);
                break;
        }
//        setCurRecord();
    }

    /**
     * 订单类型选中状态
     *
     * @param allOrderStatus       全部订单选中状态
     * @param noPayOrderStatus     未支付订单选中状态
     * @param completedOrderStatus 已完成订单选中状态
     * @param putOrderStatus
     * @param invalidOrderStatus
     */
    @Override
    public void setSelectOrderType(int allOrderStatus, int noPayOrderStatus, int completedOrderStatus, int putOrderStatus, int invalidOrderStatus) {
        mView.isSelectAllOrder(allOrderStatus);
        mView.isSelectNoPayOrder(noPayOrderStatus);
        mView.isSelectCompletedOrder(completedOrderStatus);
        mView.isSelectPutOrder(putOrderStatus);
        mView.isSelectInvalidOrder(invalidOrderStatus);
        allSelectStatus = true;
        setOrderAllSelectStatus();
    }

    /**
     * 更新订单数量
     */
    @Override
    public void updateOrderNum() {
        mView.setAllOrderNum(mModel.getOrderNum(0, mOrderType) + "");
        mView.setNoPayOrder(mModel.getOrderNum(1, mOrderType) + "");
        mView.setCompletedOrder(mModel.getOrderNum(2, mOrderType) + "");
        mView.setPutOrder(mModel.getOrderNum(3, mOrderType) + "");
        mView.setInvalidOrder(mModel.getOrderNum(4, mOrderType) + "");
    }

    /**
     * 设置订单选中状态
     *
     * @param position 选中的订单position
     */
    @Override
    public void setItemOrderSelectStatus(int position) {
        if (mData.get(position).getIsSelect()) {
            mData.get(position).setIsSelect(false);
        } else {
            mData.get(position).setIsSelect(true);
        }
        getOrderAllSelectStatus();
    }

    /**
     * 获取订单全选状态
     */
    @Override
    public void getOrderAllSelectStatus() {
        if (mData.size() > 0) {
            allSelectStatus = true;
        } else {
            allSelectStatus = false;
        }
        for (int i = 0; i < mData.size(); i++) {
            if (!mData.get(i).getIsSelect()) {
                allSelectStatus = false;
                break;
            }
        }
        mAdapter.notifyDataSetChanged();
        mView.orderAllSelectStatus(allSelectStatus);
    }

    /**
     * 设置订单全选状态
     */
    @Override
    public void setOrderAllSelectStatus() {
        if (allSelectStatus) {
            allSelectStatus = false;
            for (int i = 0; i < mData.size(); i++) {
                mData.get(i).setIsSelect(false);
            }
        } else {
            allSelectStatus = true;
            for (int i = 0; i < mData.size(); i++) {
                mData.get(i).setIsSelect(true);
            }
        }
        mAdapter.notifyDataSetChanged();
        mView.orderAllSelectStatus(allSelectStatus);

    }

    /**
     * 作废订单监听
     */
    @Override
    public void setOrderInvalidLinstener() {
        boolean isHasSelectOrder = false;
        for (int i = 0; i < mData.size(); i++) {
            if (mData.get(i).getIsSelect()) {
                isHasSelectOrder = true;
                break;
            }
        }
        if (!isHasSelectOrder) {
            mView.showMsg(1);
            return;
        }
        mView.InvalidOrder();
    }

    /**
     * 作废订单
     */
    @Override
    public void toOrderInvalid() {
        for (OrderInfo bean : mData) {
            if (bean.getIsSelect()) {
                bean.setOrderType(2);
                mModel.orderUpdate(bean);
            }
        }
        getOrderListInfo(mPage, mType);
        updateOrderNum();
        mView.showMsg(2);
    }

}
