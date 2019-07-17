package com.yzx.yzxlocalstore.ui.Activity.GoodsManage.AddGoodsInfoActivity.presenter;

import android.widget.EditText;
import android.widget.TextView;

import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.GoodsType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/7/10.
 */

public interface IAddGoodsInfoActivityPresenterImp {

    //商品分类
    void getGoodType();

    //显示选中的商品分类
    void showSelectGoodType(List<GoodsType> spinnerItems, GoodsInfo mGoodsInfo, int type);

    //保存商品信息
    void saveGoodInfo(int type, GoodsInfo mGoodsInfo);

    //设置商品信息
    void setGoodInfo(GoodsInfo mGoodsInfo);


    //设置商品信息
    void setGoodInfo(int type, GoodsInfo goodsInfo);

    //设置Vip等级价格
    String setGoodVipLevelPrice(String vipLevelPrice);

    //计算利润
    void setGoodProfit(String price, String originalPrice, int type);

    String getGoodProfit(String price, String originalPrice);

    //商品利润
    void countProfit(EditText view1, EditText view2, int type);

    //利润textView
    void setProfitTextView(TextView textView, String profit);

    //显示利润
    void showProfitInfo();


}
