package com.yzx.yzxlocalstore.ui.Activity.OrderMagnageActivity.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yzx.lib.base.BaseActivity;
import com.yzx.lib.weight.NoScrollViewPager;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.ui.Activity.ManageActivity.adapter.ManageFragmentAdapter;
import com.yzx.yzxlocalstore.ui.Activity.OrderMagnageActivity.presenter.OrderMagnageActivityPresenter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import q.rorbin.verticaltablayout.VerticalTabLayout;

/**
 * 订单管理
 */
@Route(path = RouteMap.ROUTE_ORDER_MANAGE_ACTIVITY)
public class OrderMagnageActivity extends BaseActivity implements IOrderMagnageActivityView {


    @InjectView(R.id.tab_layout)
    VerticalTabLayout tabLayout;
    @InjectView(R.id.view_pager)
    NoScrollViewPager viewPager;

    private ManageFragmentAdapter mAdapter;
    private OrderMagnageActivityPresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_order_magnage;
    }

    @Override
    protected void initView() {
        inintTitle(getResources().getString(R.string.order_manage));
        mPresenter = new OrderMagnageActivityPresenter(this);
        mPresenter.initOrderManage();

    }


    @Override
    public void initOrderManage(List<Fragment> fragmentList) {
        mAdapter = new ManageFragmentAdapter(this, getSupportFragmentManager(), fragmentList, 3);
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
