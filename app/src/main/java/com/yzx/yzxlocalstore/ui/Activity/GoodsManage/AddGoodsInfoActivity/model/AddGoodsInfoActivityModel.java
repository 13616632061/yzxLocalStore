package com.yzx.yzxlocalstore.ui.Activity.GoodsManage.AddGoodsInfoActivity.model;

import com.yzx.yzxlocalstore.app.MyAplication;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.GoodsType;
import com.yzx.yzxlocalstore.greendao.GoodsInfoDao;
import com.yzx.yzxlocalstore.greendao.GoodsTypeDao;
import com.yzx.yzxlocalstore.greendao.GreenDaoHelp;

import java.util.List;

/**
 * Created by Administrator on 2019/7/10.
 */

public class AddGoodsInfoActivityModel implements IAddGoodsInfoActivityModelImp {

    //获取分类信息
    @Override
    public List<GoodsType> getGoodsTypeInfo() {
        List<GoodsType> list = GreenDaoHelp.getDaoSession().queryBuilder(GoodsType.class).list();
        return list;
    }

    //添加商品信息
    @Override
    public void addGoodsInfo(GoodsInfo goodsInfo) {
        GreenDaoHelp.getDaoSession().getGoodsInfoDao().insert(goodsInfo);
    }

    //修改商品信息
    @Override
    public void editGoodsInfo(GoodsInfo goodsInfo) {
        GreenDaoHelp.getDaoSession().getGoodsInfoDao().update(goodsInfo);
    }

    //商品名字是否存在
    @Override
    public boolean isExistGoodsInfoName(String goodsName) {
        long count = GreenDaoHelp.getDaoSession().getGoodsInfoDao().queryBuilder().where(GoodsInfoDao.Properties.GoodName.eq(goodsName)).count();
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    //商品条码是否存在
    @Override
    public boolean isExistGoodsInfoCode(String goodsCode) {
        long count = GreenDaoHelp.getDaoSession().getGoodsInfoDao().queryBuilder().where(GoodsInfoDao.Properties.GoodCode.eq(goodsCode)).count();
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }
}
