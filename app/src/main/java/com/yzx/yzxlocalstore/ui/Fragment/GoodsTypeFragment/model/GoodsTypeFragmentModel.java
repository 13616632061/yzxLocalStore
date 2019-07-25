package com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.model;

import android.content.Context;

import com.yzx.yzxlocalstore.app.MyAplication;
import com.yzx.yzxlocalstore.entity.GoodsType;
import com.yzx.yzxlocalstore.greendao.DaoSession;
import com.yzx.yzxlocalstore.greendao.GoodsTypeDao;
import com.yzx.yzxlocalstore.greendao.GreenDaoHelp;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by Administrator on 2019/7/3.
 */

public class GoodsTypeFragmentModel implements IGoodsTypeFragmentModelImp {


    @Override
    public boolean isHasGoodsType(Context context, String typeName) {
        List<GoodsType> list = GreenDaoHelp.getDaoSession().getGoodsTypeDao().queryBuilder().where(GoodsTypeDao.Properties.TypeName.eq(typeName)).list();
        if (list.size() > 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<GoodsType> getGoodsTypeInfo(Context context) {
        List<GoodsType> list =GreenDaoHelp.getDaoSession().getGoodsTypeDao().queryBuilder().list();
        return list;
    }

    @Override
    public void addGoodsType(GoodsType goodsType) {
       GreenDaoHelp.getDaoSession().getGoodsTypeDao().insert(goodsType);
    }

    @Override
    public void editGoodsType(GoodsType goodsType) {
       GreenDaoHelp.getDaoSession().getGoodsTypeDao().update(goodsType);
    }

    //删除分类
    @Override
    public void deleteGoodsType(GoodsType goodsType) {
       GreenDaoHelp.getDaoSession().getGoodsTypeDao().delete(goodsType);
    }
}
