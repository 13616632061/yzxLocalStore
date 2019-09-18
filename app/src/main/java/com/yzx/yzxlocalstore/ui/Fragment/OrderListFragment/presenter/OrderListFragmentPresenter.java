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

    private OrderListFragment mView;
    private OrderListFragmentModel mModel;
    private OrderListFragmentAdapter mAdapter;
    private List<OrderInfo> mData = new ArrayList<>();

    private int mType;
    private long mPage = 1;
    private int mLimitPageNum = 20;


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
        List<OrderInfo> goodsInfoList = mModel.getOrderListInfo(page, type);
        mData.clear();
        mData.addAll(goodsInfoList);
        mAdapter.notifyDataSetChanged();
        switch (type) {
            case 0://全部订单
                Log.e("创建订单","全部订单: "+mModel.getOrderNum(0));
                mView.setAllOrderNum(mModel.getOrderNum(0) + "");
                setSelectOrderType(1,0,0,0,0);
                break;
            case 1://未支付订单
                Log.e("创建订单","未支付订单: "+mModel.getOrderNum(1));
                mView.setNoPayOrder(mModel.getOrderNum(1) + "");
                setSelectOrderType(0,1,0,0,0);
                break;
            case 2://已完成订单
                mView.setCompletedOrder(mModel.getOrderNum(2) + "");
                setSelectOrderType(0,0,1,0,0);
                break;
            case 3://挂单
                mView.setPutOrder(mModel.getOrderNum(3) + "");
                setSelectOrderType(0,0,0,1,0);
                break;
            case 4://已作废订单
                mView.setInvalidOrder(mModel.getOrderNum(4) + "");
                setSelectOrderType(0,0,0,0,1);
                break;
        }
//        setCurRecord();
    }

    /**
     * 订单类型选中状态
     * @param allOrderStatus 全部订单选中状态
     * @param noPayOrderStatus 未支付订单选中状态
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
    }


}
