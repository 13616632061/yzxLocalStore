package com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.model;

import android.content.Context;
import android.content.Intent;

import com.apkfuns.logutils.LogUtils;
import com.yzx.yzxlocalstore.app.MyAplication;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.GoodsType;
import com.yzx.yzxlocalstore.greendao.GoodsInfoDao;
import com.yzx.yzxlocalstore.greendao.GoodsTypeDao;
import com.yzx.yzxlocalstore.greendao.GreenDaoHelp;
import com.yzx.yzxlocalstore.service.SaveDataService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/7/9.
 */

public class GoodsListFragmentModel implements IGoodsListFragmentModelImp {

    private SaveDataService mService;

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
                goodsInfoList = GreenDaoHelp.getDaoSession().getGoodsInfoDao().queryBuilder().offset((page - 1) * 20).limit(20).list();
                break;
            case 1:
                goodsInfoList = GreenDaoHelp.getDaoSession().getGoodsInfoDao().queryBuilder().where(GoodsInfoDao.Properties.GoodStore.le(0)).offset((page - 1) * 20).limit(20).list();
                break;
            case 2:
                List<GoodsInfo> allGoodsInfoList = GreenDaoHelp.getDaoSession().getGoodsInfoDao().queryBuilder().offset((page - 1) * 20).limit(20).list();
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
    public long getAllGoodsNum(int type) {
        long num = 0;
        switch (type) {
            case 0://全部
                num = GreenDaoHelp.getDaoSession().getGoodsInfoDao().queryBuilder().count();
                break;
            case 1://缺货商品
                num = GreenDaoHelp.getDaoSession().getGoodsInfoDao().queryBuilder().where(GoodsInfoDao.Properties.GoodStore.le(0)).count();
                break;
            case 2://库存预警商品
                List<GoodsInfo> goodsInfoList = GreenDaoHelp.getDaoSession().getGoodsInfoDao().queryBuilder().list();
                List<GoodsInfo> warningGoodsInfoList = new ArrayList<>();
                for (GoodsInfo goodsInfo : goodsInfoList) {
                    if (goodsInfo.getGoodStore() <= goodsInfo.getGoodStoreWarningNum()) {
                        warningGoodsInfoList.add(goodsInfo);
                    }
                }
                num = warningGoodsInfoList.size();
                break;
        }
        return num;
    }

    /**
     * 缺货商品数量,库存少于等于0
     */
    @Override
    public String getLackGoodsInfom() {
        long num = GreenDaoHelp.getDaoSession().getGoodsInfoDao().queryBuilder().where(GoodsInfoDao.Properties.GoodStore.le(0)).count();
        return num + "";
    }

    /**
     * 库存预警商品数量,库存少于库存预警的商品数量
     */
    @Override
    public String getWarningGoodsNum() {
        List<GoodsInfo> goodsInfoList = GreenDaoHelp.getDaoSession().getGoodsInfoDao().queryBuilder().list();
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
            GreenDaoHelp.getDaoSession().getGoodsInfoDao().delete(goodsInfo);
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
            GreenDaoHelp.getDaoSession().getGoodsInfoDao().update(goodsInfo);
        }
    }

    //添加商品信息
    @Override
    public void addGoodsInfo(GoodsInfo goodsInfo) {
        GreenDaoHelp.getDaoSession().getGoodsInfoDao().insert(goodsInfo);
    }

    /**
     * 搜索
     *
     * @param content
     */
    @Override
    public List<GoodsInfo> qureyGoodsInfo(String content) {
        List<GoodsInfo> goodsInfoList = GreenDaoHelp.getDaoSession().getGoodsInfoDao().queryBuilder().whereOr(GoodsInfoDao.Properties.GoodName.like("%" + content + "%"),
                GoodsInfoDao.Properties.GoodCode.like("%" + content + "%"), GoodsInfoDao.Properties.GoodPinyinCode.like("%" + content + "%")).list();
        return goodsInfoList;
    }

    /**
     * 分类名是否存在
     * @param context
     * @param typeName
     * @return
     */
    @Override
    public boolean isHasGoodsType(Context context, String typeName) {
        List<GoodsType> list = GreenDaoHelp.getDaoSession().getGoodsTypeDao().queryBuilder().where(GoodsTypeDao.Properties.TypeName.eq(typeName)).list();
        if (list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 添加分类
     * @param goodsType
     */
    @Override
    public void addGoodsType(GoodsType goodsType) {
        GreenDaoHelp.getDaoSession().getGoodsTypeDao().insert(goodsType);
    }
}
