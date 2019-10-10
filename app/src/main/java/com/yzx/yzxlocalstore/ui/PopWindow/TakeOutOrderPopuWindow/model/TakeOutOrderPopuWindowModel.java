package com.yzx.yzxlocalstore.ui.PopWindow.TakeOutOrderPopuWindow.model;

import com.yzx.yzxlocalstore.entity.OrderInfo;
import com.yzx.yzxlocalstore.greendao.GreenDaoHelp;
import com.yzx.yzxlocalstore.greendao.OrderInfoDao;

import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */

public class TakeOutOrderPopuWindowModel implements ITakeOutOrderPopuWindowModelImp{

    /**
     * 获取挂单订单数据
     */
    @Override
    public List<OrderInfo> getPutOrderData() {
        List<OrderInfo> orderInfoList = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(OrderInfoDao.Properties.OrderStatus.eq(0),OrderInfoDao.Properties.OrderType.eq(1)).orderDesc(OrderInfoDao.Properties.OrderCreatTime).list();
        return orderInfoList;
    }
}
