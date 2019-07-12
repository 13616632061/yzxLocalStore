package com.yzx.yzxlocalstore.ui.Activity.GoodsManage.AddGoodsInfoActivity.presenter;

import android.widget.EditText;
import android.widget.TextView;

import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.GoodsType;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/7/10.
 */

public interface IAddGoodsInfoActivityPresenterImp {

    //商品分类
    void setGoodType();

    //保存商品信息
    void saveGoodInfo();


    //商品上下架状态
    void setGoodStatus(int type, GoodsInfo goodsInfo);

    //设置Vip等级价格
    String setGoodVipLevelPrice(String vipLevelPrice);

    //计算利润
    void setGoodProfit(String price, String originalPrice, int type);

    //商品利润
    void countProfit(EditText view1, EditText view2, int type);

    //利润textView
    void setProfitTextView(TextView textView, String profit);

    //显示利润
    void showProfitInfo();

}
