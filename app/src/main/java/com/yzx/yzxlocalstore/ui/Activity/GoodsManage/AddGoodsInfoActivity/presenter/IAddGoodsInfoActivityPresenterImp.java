package com.yzx.yzxlocalstore.ui.Activity.GoodsManage.AddGoodsInfoActivity.presenter;

import com.yzx.yzxlocalstore.entity.GoodsType;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/7/10.
 */

public interface IAddGoodsInfoActivityPresenterImp {

    //商品分类
    void setGoodType();

    void getSelectedGoodType(GoodsType goodsType);

    //保存商品信息
    void saveGoodInfo();

    //空信息
    void isEmptyInfo(String info,int type);

}
