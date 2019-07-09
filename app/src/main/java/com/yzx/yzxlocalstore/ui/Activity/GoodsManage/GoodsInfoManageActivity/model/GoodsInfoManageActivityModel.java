package com.yzx.yzxlocalstore.ui.Activity.GoodsManage.GoodsInfoManageActivity.model;

import android.support.v4.app.Fragment;

import com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.view.GoodsListFragment;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.view.GoodsTypeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/7/2.
 */

public class GoodsInfoManageActivityModel implements IGoodsInfoManageActivityModelImp {
    @Override
    public List<Fragment> initGoodsManageType() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new GoodsListFragment());
        fragments.add(new GoodsTypeFragment());
        return fragments;
    }
}
