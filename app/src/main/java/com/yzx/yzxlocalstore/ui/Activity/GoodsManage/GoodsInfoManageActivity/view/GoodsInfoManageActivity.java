package com.yzx.yzxlocalstore.ui.Activity.GoodsManage.GoodsInfoManageActivity.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yzx.lib.base.BaseActivity;
import com.yzx.lib.weight.NoScrollViewPager;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.ui.Activity.GoodsManage.GoodsInfoManageActivity.presenter.GoodsInfoManageActivityPresenter;
import com.yzx.yzxlocalstore.ui.Activity.ManageActivity.adapter.ManageFragmentAdapter;

import java.util.List;

import butterknife.InjectView;
import q.rorbin.verticaltablayout.VerticalTabLayout;

@Route(path = RouteMap.ROUTE_GOODS_MANAGE_ACTIVITY)
public class GoodsInfoManageActivity extends BaseActivity implements IGoodsInfoManageActivityView {


    @InjectView(R.id.tab_layout)
    VerticalTabLayout tabLayout;
    @InjectView(R.id.view_pager)
    NoScrollViewPager viewPager;

    private ManageFragmentAdapter adapter;
    private GoodsInfoManageActivityPresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_goods_info_manage;
    }

    @Override
    protected void initView() {
        inintTitle(getResources().getString(R.string.goods_manage));
        mPresenter = new GoodsInfoManageActivityPresenter(this);
        mPresenter.initGoodsManageType();
    }

    /**
     * 初始化商品管理分类
     */
    @Override
    public void initGoodsManageType(List<Fragment> fragmentList) {
        adapter = new ManageFragmentAdapter(this,getSupportFragmentManager(), fragmentList, 2);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
