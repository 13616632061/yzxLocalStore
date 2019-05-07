package com.yzx.yzxlocalstore.ui.Activity.ManageActivity.view;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.nshmura.recyclertablayout.RecyclerTabLayout;
import com.yzx.lib.base.BaseActivity;
import com.yzx.yzxlocalstore.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ManageActivity extends BaseActivity {


    @InjectView(R.id.tv_cash_register)
    TextView tvCashRegister;
    @InjectView(R.id.tab_layout)
    RecyclerTabLayout tabLayout;
    @InjectView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    public int getContentView() {
        return R.layout.activity_manage;
    }

    @Override
    protected void initView() {

    }

}
