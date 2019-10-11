package com.yzx.yzxlocalstore.ui.PopWindow.TakeOutOrderPopuWindow.presenter;

import com.yzx.lib.util.EventBusMapUtil;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.OrderInfo;
import com.yzx.yzxlocalstore.ui.Adapter.TakeOutOrderPopuWindowAdapter;
import com.yzx.yzxlocalstore.ui.PopWindow.TakeOutOrderPopuWindow.model.TakeOutOrderPopuWindowModel;
import com.yzx.yzxlocalstore.ui.PopWindow.TakeOutOrderPopuWindow.view.TakeOutOrderPopuWindow;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */

public class TakeOutOrderPopuWindowPresenter implements ITakeOutOrderPopuWindowPresenterImp {

    private TakeOutOrderPopuWindow mView;
    private TakeOutOrderPopuWindowModel mModel;

    private List<OrderInfo> mData = new ArrayList<>();
    private TakeOutOrderPopuWindowAdapter mAdapter;

    public TakeOutOrderPopuWindowPresenter(TakeOutOrderPopuWindow mView) {
        this.mView = mView;
        mModel = new TakeOutOrderPopuWindowModel();
    }


    /**
     * 挂单订单数据适配器
     */
    @Override
    public void initTakeOutOrderPopuWindowAdapter() {
        mAdapter=mView.initTakeOutOrderPopuWindowAdapter();
    }

    /**
     * 获取挂单订单数据
     */
    @Override
    public void getPutOrderData() {
        mData.clear();
        mData.addAll(mModel.getPutOrderData());
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 挂单订单数据
     */
    @Override
    public List<OrderInfo> getData() {
        return mData;
    }

    /**
     * 取单
     * @param orderInfos
     */
    @Override
    public void takeOutOrder(OrderInfo orderInfos) {
        if (orderInfos!=null){
            EventBus.getDefault().post(EventBusMapUtil.getObjectMap("takeOutOrderInfos", orderInfos));
        }
    }

    /**
     * 退出
     */
    @Override
    public void exit() {
        mView.exit();
    }


}
