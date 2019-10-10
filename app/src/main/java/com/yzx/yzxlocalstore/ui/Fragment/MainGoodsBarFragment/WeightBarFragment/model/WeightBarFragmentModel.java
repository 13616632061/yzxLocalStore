package com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.WeightBarFragment.model;

import com.apkfuns.logutils.LogUtils;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.GoodsType;
import com.yzx.yzxlocalstore.greendao.GoodsInfoDao;
import com.yzx.yzxlocalstore.greendao.GoodsTypeDao;
import com.yzx.yzxlocalstore.greendao.GreenDaoHelp;

import java.util.List;

/**
 * Created by Administrator on 2019/10/9.
 */

public class WeightBarFragmentModel implements IWeightBarFragmentModelImp {
    /**
     * 计重栏商品分类数据
     *
     * @return
     */
    @Override
    public List<GoodsType> getDataType() {
        List<GoodsType> list = GreenDaoHelp.getDaoSession().getGoodsTypeDao().queryBuilder().where(GoodsTypeDao.Properties.Status.eq(true)).list();
        return list;
    }

    /**
     * 获取单个分类计重栏商品数据
     * @return
     */
    @Override
    public List<GoodsInfo> getWeightBarData(String typeName) {
        List<GoodsInfo> list = GreenDaoHelp.getDaoSession().getGoodsInfoDao().queryBuilder().where(GoodsInfoDao.Properties.GoodLoaction.eq(2),GoodsInfoDao.Properties.TypeName.eq(typeName),GoodsInfoDao.Properties.GoodStatus.eq(true)).list();
        return list;
    }

    /**
     * 获取全部计重栏商品数据
     * @return
     */
    @Override
    public List<GoodsInfo> getAllWeightBarData() {
        List<GoodsInfo> list = GreenDaoHelp.getDaoSession().getGoodsInfoDao().queryBuilder().where(GoodsInfoDao.Properties.GoodLoaction.eq(2),GoodsInfoDao.Properties.GoodStatus.eq(true)).list();
        return list;
    }
}
