package com.yzx.yzxlocalstore.ui.Activity.MainActivity.model;

import android.content.Context;

import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.OrderInfo;
import com.yzx.yzxlocalstore.entity.TypeBean;

import java.util.List;

/**
 * Created by Administrator on 2019/7/1.
 */

public interface IMainActivityModelImp {
    //登录用户是否已经初始管理栏目
    boolean isInitTypeChannel(int curTypeCount);

    //初始化管理栏目
    void initTypeChannel(TypeBean typeBean);

    //获取底部管理分类
    List<TypeBean> getBottomType();

    //根据条码查询商品
    List<GoodsInfo> fromCodeQureGoodsinfo(String code);

    //创建订单
    void createOrder(OrderInfo orderInfo);


}
