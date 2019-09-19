package com.yzx.yzxlocalstore.ui.Fragment.OrderListFragment.model;


import android.util.Log;

import com.blankj.utilcode.util.TimeUtils;
import com.yzx.lib.util.TimeUtil;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.OrderInfo;
import com.yzx.yzxlocalstore.greendao.GoodsInfoDao;
import com.yzx.yzxlocalstore.greendao.GreenDaoHelp;
import com.yzx.yzxlocalstore.greendao.OrderInfoDao;
import com.yzx.yzxlocalstore.ui.Fragment.OrderListFragment.presenter.OrderListFragmentPresenter;

import org.greenrobot.greendao.query.WhereCondition;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 2019/9/18.
 */

public class OrderListFragmentModel implements IOrderListFragmentModelImp {
    private final static String TAG = OrderListFragmentModel.class.getSimpleName();

    /**
     * 获取订单列表信息
     *
     * @param page       页数
     * @param type       订单类型
     * @param mOrderType 今天订单：0，昨日订单：1，全部订单：2
     */
    @Override
    public List<OrderInfo> getOrderListInfo(int page, int type, int mOrderType) {
        List<OrderInfo> orderInfoList = new ArrayList<>();
        switch (mOrderType) {
            case 0://今天订单
                orderInfoList.addAll(queryOrderListComment(page,type,getTodayWhereCondition()));
                break;
            case 1://昨日订单
                orderInfoList.addAll(queryOrderListComment(page,type,getYesterdayWhereCondition()));
                break;
            case 2://全部订单
                orderInfoList.addAll(queryOrderListComment(page,type,null));
                break;
        }
        return orderInfoList;
    }

    /**
     * 获取今日订单
     *
     * @return
     */
    @Override
    public List<WhereCondition> getTodayWhereCondition() {
        long todayStart = TimeUtil.getStarWeeOfToday();
        long todayEnd = todayStart + TimeUtil.DAY;
        List<WhereCondition> whereConditions=new ArrayList<>();
        WhereCondition whereCondition1 = OrderInfoDao.Properties.OrderCreatTime.ge(todayStart);
        WhereCondition whereCondition2 = OrderInfoDao.Properties.OrderCreatTime.lt(todayEnd);
        whereConditions.add(whereCondition1);
        whereConditions.add(whereCondition2);
        return whereConditions;
    }

    /**
     * 获取昨日订单
     *
     * @return
     */
    @Override
    public List<WhereCondition> getYesterdayWhereCondition() {
        long start = TimeUtil.getStarWeeOfToday() - TimeUtil.DAY;
        long end = TimeUtil.getStarWeeOfToday();
        List<WhereCondition> whereConditions=new ArrayList<>();
        WhereCondition whereCondition1 = OrderInfoDao.Properties.OrderCreatTime.ge(start);
        WhereCondition whereCondition2 = OrderInfoDao.Properties.OrderCreatTime.lt(end);
        whereConditions.add(whereCondition1);
        whereConditions.add(whereCondition2);
        return whereConditions;
    }


    /**
     * 查询公共部分
     *
     * @param page
     * @param type
     * @return
     */
    @Override
    public List<OrderInfo> queryOrderListComment(int page, int type, List<WhereCondition> whereConditions) {
        List<OrderInfo> orderInfoList = null;
        if (whereConditions != null) {//条件查询
            switch (type) {
                case 0://全部订单
                    orderInfoList = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(whereConditions.get(0), whereConditions.get(1)).offset((page - 1) * 20).offset((page - 1) * 20).limit(20).list();
                    break;
                case 1://未支付订单
                    orderInfoList = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(whereConditions.get(0), whereConditions.get(1), OrderInfoDao.Properties.OrderStatus.eq(0)).offset((page - 1) * 20).limit(20).list();
                    break;
                case 2://已完成订单
                    orderInfoList = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(whereConditions.get(0), whereConditions.get(1), OrderInfoDao.Properties.OrderStatus.eq(1)).offset((page - 1) * 20).limit(20).list();
                    break;
                case 3://挂单
                    orderInfoList = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(whereConditions.get(0), whereConditions.get(1), OrderInfoDao.Properties.OrderType.eq(1)).offset((page - 1) * 20).limit(20).list();
                    break;
                case 4://已作废订单
                    orderInfoList = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(whereConditions.get(0), whereConditions.get(1), OrderInfoDao.Properties.OrderType.eq(2)).offset((page - 1) * 20).limit(20).list();
                    break;
            }
        } else {
            switch (type) {
                case 0://全部订单
                    orderInfoList = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().offset((page - 1) * 20).offset((page - 1) * 20).limit(20).list();
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
        }
        Log.e(TAG, "orderInfoList: " + orderInfoList.toString());
        return orderInfoList;
    }

    /**
     * 获取订单数量
     *
     * @param type 订单类型
     * @return
     */
    @Override
    public long getOrderNum(int type, int mOrderType) {
        long num = 0;
        switch (mOrderType) {
            case 0://今天订单
                num=getOrderNumComment(type,getTodayWhereCondition());
                break;
            case 1://昨日订单
                num=getOrderNumComment(type,getYesterdayWhereCondition());
                break;
            case 2://全部订单
                num=getOrderNumComment(type,null);
                break;
        }
        return num;
    }

    /**
     * 查询订单数量公共部分
     *
     * @param type
     * @return
     */
    @Override
    public long getOrderNumComment(int type,List<WhereCondition> whereConditions) {
        long num = 0;
        if (whereConditions!=null){
            switch (type) {
                case 0://全部订单
                    num = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().count();
                    break;
                case 1://未支付订单
                    num = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(whereConditions.get(0),whereConditions.get(1),OrderInfoDao.Properties.OrderStatus.eq(0)).count();
                    break;
                case 2://已完成订单
                    num = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(whereConditions.get(0),whereConditions.get(1),OrderInfoDao.Properties.OrderStatus.eq(1)).count();
                    break;
                case 3://挂单
                    num = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(whereConditions.get(0),whereConditions.get(1),OrderInfoDao.Properties.OrderType.eq(1)).count();
                    break;
                case 4://已作废订单
                    num = GreenDaoHelp.getDaoSession().getOrderInfoDao().queryBuilder().where(whereConditions.get(0),whereConditions.get(1),OrderInfoDao.Properties.OrderType.eq(2)).count();
                    break;
            }
        }else {
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
        }

        return num;
    }
}
