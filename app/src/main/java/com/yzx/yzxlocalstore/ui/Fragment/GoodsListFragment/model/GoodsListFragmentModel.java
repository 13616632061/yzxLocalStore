package com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.model;

import com.apkfuns.logutils.LogUtils;
import com.yzx.yzxlocalstore.app.MyAplication;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.greendao.GoodsInfoDao;
import com.yzx.yzxlocalstore.greendao.GoodsTypeDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/7/9.
 */

public class GoodsListFragmentModel implements IGoodsListFragmentModelImp {

    /**
     * 查询商品
     *
     * @param page 页数
     */
    @Override
    public List<GoodsInfo> getGoodsInfo(int page, int type) {
        List<GoodsInfo> goodsInfoList = null;
        switch (type) {
            case 0:
                goodsInfoList = MyAplication.getDaoSession().getGoodsInfoDao().queryBuilder().offset((page - 1) * 20).limit(20).list();
                break;
            case 1:
                goodsInfoList = MyAplication.getDaoSession().getGoodsInfoDao().queryBuilder().where(GoodsInfoDao.Properties.GoodStore.le(0)).offset((page - 1) * 20).limit(20).list();
                break;
            case 2:
                List<GoodsInfo> allGoodsInfoList = MyAplication.getDaoSession().getGoodsInfoDao().queryBuilder().offset((page - 1) * 20).limit(20).list();
                goodsInfoList = new ArrayList<>();
                for (GoodsInfo goodsInfo : allGoodsInfoList) {
                    if (goodsInfo.getGoodStore() > 0 && goodsInfo.getGoodStore() <= goodsInfo.getGoodStoreWarningNum()) {
                        goodsInfoList.add(goodsInfo);
                    }
                }
                break;
        }
        return goodsInfoList;
    }

    /**
     * 所有商品数量
     *
     * @return
     */
    @Override
    public String getAllGoodsNum() {
        long num = MyAplication.getDaoSession().getGoodsInfoDao().queryBuilder().count();
        return num + "";
    }

    /**
     * 缺货商品数量,库存少于等于0
     */
    @Override
    public String getLackGoodsInfom() {
        long num = MyAplication.getDaoSession().getGoodsInfoDao().queryBuilder().where(GoodsInfoDao.Properties.GoodStore.le(0)).count();
        return num + "";
    }

    /**
     * 库存预警商品数量,库存少于库存预警的商品数量
     */
    @Override
    public String getWarningGoodsNum() {
        List<GoodsInfo> goodsInfoList = MyAplication.getDaoSession().getGoodsInfoDao().queryBuilder().list();
        List<GoodsInfo> warningGoodsinfoList = new ArrayList<>();
        for (GoodsInfo goodsInfo : goodsInfoList) {
            if (goodsInfo.getGoodStore() > 0 && goodsInfo.getGoodStore() <= goodsInfo.getGoodStoreWarningNum()) {
                warningGoodsinfoList.add(goodsInfo);
            }
        }
        return warningGoodsinfoList.size() + "";
    }

    /**
     * 删除商品
     *
     * @param goodsInfoList
     */
    @Override
    public void deteleGoodsInfo(List<GoodsInfo> goodsInfoList) {
        for (GoodsInfo goodsInfo : goodsInfoList) {
            MyAplication.getDaoSession().getGoodsInfoDao().delete(goodsInfo);
        }
    }

    /**
     * 编辑商品
     *
     * @param goodsInfoList
     */
    @Override
    public void editGoodsInfo(List<GoodsInfo> goodsInfoList) {
        for (GoodsInfo goodsInfo : goodsInfoList) {
            MyAplication.getDaoSession().getGoodsInfoDao().update(goodsInfo);
        }
    }
}
