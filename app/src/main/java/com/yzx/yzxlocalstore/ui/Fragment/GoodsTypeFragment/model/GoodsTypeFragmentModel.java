package com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.model;

import android.content.Context;

import com.yzx.yzxlocalstore.app.MyAplication;
import com.yzx.yzxlocalstore.entity.GoodsType;
import com.yzx.yzxlocalstore.greendao.DaoSession;
import com.yzx.yzxlocalstore.greendao.GoodsTypeDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by Administrator on 2019/7/3.
 */

public class GoodsTypeFragmentModel implements IGoodsTypeFragmentModelImp {


    @Override
    public QueryBuilder<GoodsType> initDaoSession(Context context) {
        DaoSession daoSession = ((MyAplication) context.getApplicationContext()).getDaoSession();
        QueryBuilder<GoodsType> queryBuilder = daoSession.queryBuilder(GoodsType.class);
        return queryBuilder;
    }

    @Override
    public boolean isHasGoodsType(Context context, String typeName) {
        List<GoodsType> list = initDaoSession(context).where(GoodsTypeDao.Properties.TypeName.eq(typeName)).list();
        if (list.size() > 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<GoodsType> getGoodsTypeInfo(Context context) {
        List<GoodsType> list = initDaoSession(context).list();
        return list;
    }

    @Override
    public void addGoodsType(GoodsType goodsType) {
        MyAplication.getDaoSession().getGoodsTypeDao().insert(goodsType);
    }

    @Override
    public void editGoodsType(GoodsType goodsType) {
        MyAplication.getDaoSession().getGoodsTypeDao().update(goodsType);
    }

    //删除分类
    @Override
    public void deleteGoodsType(GoodsType goodsType) {
        MyAplication.getDaoSession().getGoodsTypeDao().delete(goodsType);
    }
}
