package com.yzx.yzxlocalstore.ui.Activity.GoodsManage.AddGoodsInfoActivity.model;

import com.yzx.yzxlocalstore.app.MyAplication;
import com.yzx.yzxlocalstore.entity.GoodsType;

import java.util.List;

/**
 * Created by Administrator on 2019/7/10.
 */

public class AddGoodsInfoActivityModel implements IAddGoodsInfoActivityModelImp{

    @Override
    public List<GoodsType> getGoodsTypeInfo() {
        List<GoodsType> list = MyAplication.getDaoSession().queryBuilder(GoodsType.class).list();
        return list;
    }
}
