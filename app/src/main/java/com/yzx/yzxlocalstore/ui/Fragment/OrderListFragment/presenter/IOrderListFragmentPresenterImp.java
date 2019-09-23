package com.yzx.yzxlocalstore.ui.Fragment.OrderListFragment.presenter;

import com.yzx.yzxlocalstore.entity.OrderInfo;
import com.yzx.yzxlocalstore.ui.Adapter.OrderListFragmentAdapter;

import java.util.List;

/**
 * Created by Administrator on 2019/9/18.
 */

public interface IOrderListFragmentPresenterImp {


    //初始化订单列表
    void initOrderListFragmentAdapter();

    //获取订单类别类型
    void setOrderListType(int type);

    //获取订单数据
    List<OrderInfo> getData();

    //获取订单列表信息
    void getOrderListInfo(int page, int type);

    //订单类型选中状态
    void setSelectOrderType(int allOrderStatus, int noPayOrderStatus, int completedOrderStatus, int putOrderStatus, int invalidOrderStatus);

    //更新订单数量
    void updateOrderNum();

    //设置订单选中状态
    void setItemOrderSelectStatus(int position);

    //获取订单全选状态
    void getOrderAllSelectStatus();

    //设置订单全选状态
    void setOrderAllSelectStatus();

    //作废订单监听
    void setOrderInvalidLinstener();

    //作废订单
    void toOrderInvalid();
}
