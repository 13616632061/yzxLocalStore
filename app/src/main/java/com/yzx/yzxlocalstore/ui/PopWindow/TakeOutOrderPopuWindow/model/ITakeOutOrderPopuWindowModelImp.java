package com.yzx.yzxlocalstore.ui.PopWindow.TakeOutOrderPopuWindow.model;

import com.yzx.yzxlocalstore.entity.OrderInfo;

import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */

public interface ITakeOutOrderPopuWindowModelImp {


    //获取挂单订单数据
    List<OrderInfo> getPutOrderData();
}
