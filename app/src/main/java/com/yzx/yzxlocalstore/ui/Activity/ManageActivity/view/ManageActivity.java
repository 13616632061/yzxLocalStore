package com.yzx.yzxlocalstore.ui.Activity.ManageActivity.view;


import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chaychan.library.BottomBarItem;
import com.yzx.lib.base.BaseActivity;
import com.yzx.lib.base.BaseFragment;
import com.yzx.lib.weight.BottomBarLayout;
import com.yzx.lib.weight.NoScrollViewPager;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.ManageType;
import com.yzx.yzxlocalstore.ui.Activity.ManageActivity.adapter.ManageFragmentAdapter;
import com.yzx.yzxlocalstore.ui.Activity.ManageActivity.adapter.ManageTypeAdapter;
import com.yzx.yzxlocalstore.ui.Activity.ManageActivity.presenter.ManageActivityPresenter;

import java.util.List;

import butterknife.InjectView;

@Route(path = RouteMap.ROUTE_MANAGE_ACTIVITY)
public class ManageActivity extends BaseActivity implements IManageView {


    @InjectView(R.id.tv_cash_register)
    TextView tvCashRegister;

    @InjectView(R.id.view_pager)
    NoScrollViewPager viewPager;
    @InjectView(R.id.bar_layout)
    BottomBarLayout barLayout;

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
    public void initManageType(List<ManageType> manageTypeList, List<Fragment> fragmentList) {
        for (ManageType manageType : manageTypeList) {
            BottomBarItem barItem = mManageActivityPresenter.createTopBarItem(manageType);
            barLayout.addNoWeightItem(barItem);
        }
        mManageFragmentAdapter = new ManageFragmentAdapter(this,getSupportFragmentManager(), fragmentList,0);
        viewPager.setAdapter(mManageFragmentAdapter);
        barLayout.setViewPager(viewPager);
    }


}
