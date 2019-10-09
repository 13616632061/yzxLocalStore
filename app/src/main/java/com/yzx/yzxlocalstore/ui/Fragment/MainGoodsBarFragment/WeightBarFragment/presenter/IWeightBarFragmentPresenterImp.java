package com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.WeightBarFragment.presenter;

import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.GoodsType;
import com.yzx.yzxlocalstore.ui.Adapter.WeightBarFragmentTypeAdapter;

import java.util.List;

/**
 * Created by Administrator on 2019/10/9.
 */

public interface IWeightBarFragmentPresenterImp {

    //初始化计重栏商品分类
    void initWeightBarFragmentTypeAdapter();

    //计重栏商品分类数据
    List<GoodsType> getDataType();

    //获取计重栏商品分类数据
    void getWeightBarFragmentTypeData();

    //初始化计重栏商品
    void initWeightBarFragmentAdapter();

    //计重栏商品数据
    List<GoodsInfo> getData();

    //获取计重栏商品数据
    void getWeightBarData();

    //获取计重栏的宽度
    int getLayoutWidth();
}
