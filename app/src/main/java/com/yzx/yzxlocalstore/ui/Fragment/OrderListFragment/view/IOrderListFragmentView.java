package com.yzx.yzxlocalstore.ui.Fragment.OrderListFragment.view;

import com.yzx.yzxlocalstore.ui.Adapter.OrderListFragmentAdapter;

/**
 * Created by Administrator on 2019/9/18.
 */

public interface IOrderListFragmentView {

    //初始化订单列表
    OrderListFragmentAdapter initOrderListFragmentAdapter();

    //所有订单数量
    void setAllOrderNum(String num);

    //未支付订单数量
    void setNoPayOrder(String num);

    //完成订单数量
    void setCompletedOrder(String num);

    //挂单订单数量
    void setPutOrder(String num);

    //已作废订单数量
    void setInvalidOrder(String num);

    //是否选中全部订单
    void isSelectAllOrder(int type);

    //是否选中未支付订单
    void isSelectNoPayOrder(int type);

    //是否选中完成订单
    void isSelectCompletedOrder(int type);

    //是否选中挂单订单
    void isSelectPutOrder(int type);

    //是否选中废订单数量
    void isSelectInvalidOrder(int type);

    //订单全选状态
    void orderAllSelectStatus(boolean allSelectStatus);

    //显示提示信息
    void showMsg(int type);

    //作废订单
    void InvalidOrder();

}
