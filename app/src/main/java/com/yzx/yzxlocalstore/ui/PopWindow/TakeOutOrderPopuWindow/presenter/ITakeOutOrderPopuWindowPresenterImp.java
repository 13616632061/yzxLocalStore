package com.yzx.yzxlocalstore.ui.PopWindow.TakeOutOrderPopuWindow.presenter;

import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.OrderInfo;
import com.yzx.yzxlocalstore.ui.Adapter.TakeOutOrderPopuWindowAdapter;

import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */

public interface ITakeOutOrderPopuWindowPresenterImp {


    //挂单订单数据适配器
    void initTakeOutOrderPopuWindowAdapter();

    //获取挂单订单数据
    void getPutOrderData();

    //挂单订单数据
    List<OrderInfo> getData();

    //取单
    void takeOutOrder(OrderInfo orderInfos);

    //退出
    void exit();
}
