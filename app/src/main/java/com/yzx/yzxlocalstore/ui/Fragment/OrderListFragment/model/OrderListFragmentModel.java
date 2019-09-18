package com.yzx.yzxlocalstore.ui.Fragment.OrderListFragment.model;

import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.OrderInfo;
import com.yzx.yzxlocalstore.greendao.GoodsInfoDao;
import com.yzx.yzxlocalstore.greendao.GreenDaoHelp;
import com.yzx.yzxlocalstore.greendao.OrderInfoDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/9/18.
 */

public class OrderListFragmentModel implements IOrderListFragmentModelImp {

    /**
     * 获取订单列表信息
     * @param page 页数
     * @param type 订单类型
     */
    @Override
    public List<OrderInfo> getOrderListInfo(int page, int type) {
        List<OrderInfo> orderInfoList = null;
        switch (type) {
            case 0://全部订单
                orderInfoList = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().offset((page - 1) * 20).limit(20).list();
                break;
            case 1://未支付订单
                orderInfoList = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(OrderInfoDao.Properties.OrderStatus.eq(0)).offset((page - 1) * 20).limit(20).list();
                break;
            case 2://已完成订单
                orderInfoList = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(OrderInfoDao.Properties.OrderStatus.eq(1)).offset((page - 1) * 20).limit(20).list();
                break;
            case 3://挂单
                orderInfoList = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(OrderInfoDao.Properties.OrderType.eq(1)).offset((page - 1) * 20).limit(20).list();
                break;
            case 4://已作废订单
                orderInfoList = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(OrderInfoDao.Properties.OrderType.eq(2)).offset((page - 1) * 20).limit(20).list();
                break;

        }
        return orderInfoList;
    }

    /**
     * 获取订单数量
     * @param type 订单类型
     * @return
     */
    @Override
    public long getOrderNum(int type) {
        long num = 0;
        switch (type) {
            case 0://全部订单
                num = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().count();
                break;
            case 1://未支付订单
                num = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(OrderInfoDao.Properties.OrderStatus.eq(0)).count();
                break;
            case 2://已完成订单
                num = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(OrderInfoDao.Properties.OrderStatus.eq(1)).count();
                break;
            case 3://挂单
                num = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(OrderInfoDao.Properties.OrderType.eq(1)).count();
                break;
            case 4://已作废订单
                num = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(OrderInfoDao.Properties.OrderType.eq(2)).count();
                break;
        }
        return num;
    }
}
