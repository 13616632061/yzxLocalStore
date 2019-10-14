package com.yzx.yzxlocalstore.ui.Activity.MainActivity.presenter;

import android.support.v4.app.Fragment;
import android.view.KeyEvent;

import com.cheng.channel.Channel;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.OrderInfo;
import com.yzx.yzxlocalstore.entity.SaleGoodsInfo;
import com.yzx.yzxlocalstore.entity.TypeBean;

import java.util.List;

/**
 * Created by Administrator on 2019/6/28.
 */

public interface IMainActivityPresenterImp {

    //初始化管理栏目
    void initTypeChannel();

    //显示更多分类信息
    void showMoreTypeChannel();

    //获取底部管理分类
    void getBottomType();

    void setBottomTypeView();

    //底部管理分类点击事件
    void setBottomTypeOnClick(String name);

    /**
     * 初始化左边销售商品信息Adapter
     */
    void setLeftSaleGoodsListView();

    //销售商品信息数据
    List<SaleGoodsInfo> saleGoodsInfoData();

    //设置选中的销售商品信息item
    void setSelectSaleGoodsInfoItem(int position);

    //添加销售商品
    void addSaleGoodsInfo(String code);

    //删除选中的item
    void removeSelectSaleGoodsInfoItem();

    //销售商品的总重量
    void setTotalWeight();

    //销售商品的总数量
    double setTotalGoodNum();

    //销售商品的总价格
    void setTotalPrice();

    //应收金额
    double setReceivableMoney();

    //创建订单
    void createOrder(int type);

    //更新订单
    void updateOrder(int type);

    //支付类型
    void orderPayType(OrderInfo orderInfo,int type);

    //获取订单id
    String getOrderId();

    //获取订单利润
    double getOrderProfit();

    //选择支付方式
    void selcetPayment();


    //扫码枪事件解析
    void scanAnalysisKeyEvent(KeyEvent event);

    //显示商品快捷栏，计重栏
    void showGoodBarPosition(int position);

    //初始化数据
    void initData();

    //取单
    void takeOutOrder(OrderInfo orderInfos);

    //登出
    void outLogin();

}
