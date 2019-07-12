package com.yzx.yzxlocalstore.ui.Activity.GoodsManage.AddGoodsInfoActivity.model;

import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.GoodsType;

import java.util.List;

/**
 * Created by Administrator on 2019/7/10.
 */

public interface IAddGoodsInfoActivityModelImp {

    //获取分类信息
    List<GoodsType> getGoodsTypeInfo();

    //添加商品信息
    void addGoodsInfo(GoodsInfo goodsInfo);
}
