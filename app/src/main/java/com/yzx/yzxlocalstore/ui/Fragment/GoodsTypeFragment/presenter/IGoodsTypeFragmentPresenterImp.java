package com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.presenter;

import com.yzx.yzxlocalstore.entity.GoodsType;

/**
 * Created by Administrator on 2019/7/2.
 */

public interface IGoodsTypeFragmentPresenterImp {

    //初始化适配器
    void initAdapter();

    //获取商品分类数据
    void getGoodsTypeInfo();

    //显示商品分类操作弹窗
    void showGoodsTypePopWindow(int type,GoodsType goodsType);

    //新增分类
    void addGoodsType(String typeName, String sort);

    //删除分类
    void deleteGoodsType();

    //编辑分类
    void editGoodsType(GoodsType goodsType);

    //商品分类选中状态 type:0全选，1单个选中
    void editGoodsTypeSelectStatus(int type, int position);

    //商品分类启用状态
    void setGoodsTypeEnableStatus(int position,boolean enable);
}
