package com.yzx.yzxlocalstore.ui.Fragment.OrderListFragment.model;

import com.yzx.yzxlocalstore.entity.OrderInfo;

import java.util.List;

/**
 * Created by Administrator on 2019/9/18.
 */

public interface IOrderListFragmentModelImp {


    //获取订单列表信息
    List<OrderInfo> getOrderListInfo(int page, int type);

    //获取订单数量
    long getOrderNum(int type);
}
