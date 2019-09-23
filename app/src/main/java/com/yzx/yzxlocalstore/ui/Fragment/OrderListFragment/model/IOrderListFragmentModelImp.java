package com.yzx.yzxlocalstore.ui.Fragment.OrderListFragment.model;

import com.yzx.yzxlocalstore.entity.OrderInfo;

import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

/**
 * Created by Administrator on 2019/9/18.
 */

public interface IOrderListFragmentModelImp {


    //获取订单列表信息
    List<OrderInfo> getOrderListInfo(int page, int type, int mOrderType);

    //获取今日订单
    List<WhereCondition> getTodayWhereCondition();

    //获取昨日订单
    List<WhereCondition> getYesterdayWhereCondition();


    //查询订单公共部分
    List<OrderInfo> queryOrderListComment(int page, int type, List<WhereCondition> whereConditions);

    //获取订单数量
    long getOrderNum(int type, int mOrderType);

    //查询订单数量公共部分
    long getOrderNumComment(int type,List<WhereCondition> whereConditions);

    //订单信息更细
    void orderUpdate(OrderInfo orderInfo);
}
