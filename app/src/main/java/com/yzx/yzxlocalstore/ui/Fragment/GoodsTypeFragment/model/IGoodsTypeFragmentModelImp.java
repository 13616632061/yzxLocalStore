package com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.model;

import android.content.Context;

import com.yzx.yzxlocalstore.entity.GoodsType;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by Administrator on 2019/7/3.
 */

public interface IGoodsTypeFragmentModelImp {
    //初始化DaoSession
    QueryBuilder<GoodsType> initDaoSession(Context context);

    //分类名是否存在
    boolean isHasGoodsType(Context context, String typeName);

    //获取商品分类数据
    List<GoodsType> getGoodsTypeInfo(Context context);

    //添加分类
    void addGoodsType(GoodsType goodsType);

    //编辑分类
    void editGoodsType(GoodsType goodsType);

    //删除分类
    void deleteGoodsType(Context context);
}
