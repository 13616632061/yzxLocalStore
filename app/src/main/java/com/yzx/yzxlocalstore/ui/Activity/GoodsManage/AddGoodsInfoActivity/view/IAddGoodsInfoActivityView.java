package com.yzx.yzxlocalstore.ui.Activity.GoodsManage.AddGoodsInfoActivity.view;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.yzx.yzxlocalstore.entity.GoodsType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/7/10.
 */

public interface IAddGoodsInfoActivityView {

    //商品分类
    void initGoodTypeInfo(List<GoodsType> spinnerGoodsTypeItems);

//    //选中的商品分类
    void setSelectGoodtypeItem(int position);

    GoodsType getSelectGoodType();

    //商品名称
    void setGoodName(String goodName);

    String getGoodName();

    //商品条码
    void setGoodCode(String goodCode);

    String getGoodCode();

    //商品拼音码
    void setGoodPinyinCode(String PinyinCode);

    String getGoodPinyinCode();

    //商品库存
    void setGoodStore(String Store);

    String getGoodStore();

    //库存预警数量
    void setGoodStoreWarningNum(String StoreWarningNum);

    String getGoodStoreWarningNum();

    //商品上下架状态
    void setGoodStatus(int type);

    boolean getGoodStatus();

    //商品栏目：1快捷栏，2计重栏
    void setGoodLoaction(int Loaction);

    int getGoodLoaction();

    //商品进价
    void setGoodOriginalPrice(String OriginalPrice);

    String getGoodOriginalPrice();

    //商品销售价
    void setGoodPrice(String Price);

    String getGoodPrice();

    //会员V1等级价格
    void setGoodVipLevelOnePrice(String VipLevelOnePrice);

    String getGoodVipLevelOnePrice();

    //会员V2等级价格
    void setGoodVipLevelTwoPrice(String VipLevelTwoPrice);

    String getGoodVipLevelTwoPrice();

    //会员V3等级价格
    void setGoodVipLevelThreePrice(String VipLevelThreePrice);

    String getGoodVipLevelThreePrice();

    //会员V4等级价格
    void setGoodVipLevelFourthPrice(String VipLevelFourthPrice);

    String getGoodVipLevelFourthPrice();

    //会员V5等级价格
    void setGoodVipLevelFivePrice(String VipLevelFivePrice);

    String getGoodVipLevelFivePrice();

    //商品利润
    void setGoodProfit(String profit, int type);


    //计算利润
    void countProfit(EditText view1, EditText view2, int type);

    //显示利润
    void showProfitInfo();

    //错误信息提示
    void errorMsg(int type);
}
