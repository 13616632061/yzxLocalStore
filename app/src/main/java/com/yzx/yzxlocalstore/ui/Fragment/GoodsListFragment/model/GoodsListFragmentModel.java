package com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.model;

import com.apkfuns.logutils.LogUtils;
import com.yzx.yzxlocalstore.app.MyAplication;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.greendao.GoodsInfoDao;
import com.yzx.yzxlocalstore.greendao.GoodsTypeDao;

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
    public List<GoodsInfo> getGoodsInfo(int page) {
        List<GoodsInfo> goodsInfoList = MyAplication.getDaoSession().getGoodsInfoDao().queryBuilder().offset((page - 1) * 20).limit(20).list();
        return goodsInfoList;
    }
}
