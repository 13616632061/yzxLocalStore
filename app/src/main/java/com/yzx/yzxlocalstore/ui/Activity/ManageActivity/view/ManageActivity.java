package com.yzx.yzxlocalstore.ui.Activity.ManageActivity.view;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.nshmura.recyclertablayout.RecyclerTabLayout;
import com.yzx.lib.base.BaseActivity;
import com.yzx.lib.base.BaseFragment;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.ManageType;
import com.yzx.yzxlocalstore.ui.Activity.ManageActivity.adapter.ManageFragmentAdapter;
import com.yzx.yzxlocalstore.ui.Activity.ManageActivity.adapter.ManageTypeAdapter;
import com.yzx.yzxlocalstore.ui.Activity.ManageActivity.presenter.ManageActivityPresenter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

@Route(path = RouteMap.ROUTE_MANAGE_ACTIVITY)
public class ManageActivity extends BaseActivity implements IManageView {


    @InjectView(R.id.tv_cash_register)
    TextView tvCashRegister;
    @InjectView(R.id.tab_layout)
    RecyclerTabLayout tabLayout;
    @InjectView(R.id.view_pager)
    ViewPager viewPager;

    private ManageTypeAdapter mManageTypeAdapter;
    private ManageFragmentAdapter mManageFragmentAdapter;
    private ManageActivityPresenter mManageActivityPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_manage;
    }

    @Override
    protected void initView() {
        mManageActivityPresenter = new ManageActivityPresenter(this);
        mManageActivityPresenter.initManageType();
    }

    /**
     * 初始化管理分类
     */
    @Override
    public void initManageType(List<ManageType> manageTypeList, List<BaseFragment> fragmentList) {
        mManageFragmentAdapter = new ManageFragmentAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(mManageFragmentAdapter);
        mManageTypeAdapter = new ManageTypeAdapter(this, viewPager, manageTypeList);
        tabLayout.setUpWithAdapter(mManageTypeAdapter);
    }
}
