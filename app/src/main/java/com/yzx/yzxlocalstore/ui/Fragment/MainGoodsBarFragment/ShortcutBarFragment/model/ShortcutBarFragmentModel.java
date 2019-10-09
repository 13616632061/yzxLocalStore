package com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.ShortcutBarFragment.model;

import com.apkfuns.logutils.LogUtils;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.greendao.GoodsInfoDao;
import com.yzx.yzxlocalstore.greendao.GreenDaoHelp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/9.
 */

public class ShortcutBarFragmentModel implements IShortcutBarFragmentModelImp {

    /**
     * 快捷商品数据
     *
     * @return
     */
    @Override
    public List<GoodsInfo> getShortcutBarData() {
        List<GoodsInfo> list = GreenDaoHelp.getDaoSession().getGoodsInfoDao().queryBuilder().where(GoodsInfoDao.Properties.GoodLoaction.eq(1),GoodsInfoDao.Properties.GoodStatus.eq(true)).list();
        return list;
    }
}
