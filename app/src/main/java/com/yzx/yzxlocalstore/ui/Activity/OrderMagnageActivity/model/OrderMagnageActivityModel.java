package com.yzx.yzxlocalstore.ui.Activity.OrderMagnageActivity.model;

import android.support.v4.app.Fragment;

import com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.view.GoodsListFragment;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.view.GoodsTypeFragment;
import com.yzx.yzxlocalstore.ui.Fragment.OrderListFragment.view.OrderListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/9/17.
 */

public class OrderMagnageActivityModel implements IOrderMagnageActivityModelImp {
    @Override
    public List<Fragment> initOrderManage() {
        List<Fragment> fragments = new ArrayList<>();
        for (int i=0;i<3;i++){
            fragments.add(new OrderListFragment());
        }
        return fragments;
    }
}
