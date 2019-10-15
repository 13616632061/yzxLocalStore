package com.yzx.yzxlocalstore.ui.Activity.MainActivity.view;

import android.support.v4.app.Fragment;

import com.yzx.yzxlocalstore.entity.TypeBean;
import com.yzx.yzxlocalstore.ui.Adapter.MainBottomTypeAdapter;
import com.yzx.yzxlocalstore.ui.Adapter.MainLeftSaleGoodsListAdapter;
import com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.ShortcutBarFragment.view.ShortcutBarFragment;
import com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.WeightBarFragment.view.WeightBarFragment;

import java.util.List;

/**
 * Created by Administrator on 2019/6/28.
 */

public interface IMainActivityView {

    //显示更多分类信息
    void showMoreTypeChannel();

    //设置底部功能分类视图
    void setBottomTypeView();

    //底部功能管理分类适配器
    MainBottomTypeAdapter mainBottomTypeAdapter();

    //底部功能管理分类数据
    List<TypeBean> mBottomTypeData();

    //要销售的商品列表
    MainLeftSaleGoodsListAdapter setLeftSaleGoodsListView();


    //最后加入销售的商品列表定位到可见
    void LeftSaleGoodsListScrollToPosition(int position);

    //销售商品的总重量
    void setTotalWeight();

    //销售商品的总数量
    void setTotalGoodNum(String totalGoodNum);

    //销售商品的总价格
    void setTotalPrice(String totalPrice);

    //应收金额
    void setReceivableMoney(String receivableMoney);

    //实收金额
    void setReceiptsMoney(String money);

    //找零
    void setChangeMoney();

    double getChangeMoney();

    //选择支付方式
    void selcetPayment();

    //显示提示msg
    void showMsg(int type);

    //显示商品快捷栏
    void showShortcutBarFragment(ShortcutBarFragment barFragment);

    //显示计重栏
    void showWeightBarFragment(WeightBarFragment barFragment);

    //设置商品栏变化
    void setGoodBarColor(int position);

    //获取商品栏的宽度
    int getLayoutMidelWidth();

    //显示取单
    void showTakeOutOrder();

    //登出
    void outLogin();

    //显示当前时间
    void showCurTime(String time);
}