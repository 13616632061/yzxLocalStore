package com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.WeightBarFragment.model;

import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.GoodsType;

import java.util.List;

/**
 * Created by Administrator on 2019/10/9.
 */

public interface IWeightBarFragmentModelImp {

    //计重栏商品分类数据
    List<GoodsType> getDataType();

    //获取单个分类计重栏商品数据
    List<GoodsInfo> getWeightBarData(String typeName);

    //获取全部计重栏商品数据
    List<GoodsInfo> getAllWeightBarData();
}
