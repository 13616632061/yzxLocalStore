package com.yzx.yzxlocalstore.ui.Activity.StaffManageActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yzx.lib.base.BaseActivity;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;

@Route(path = RouteMap.ROUTE_STAFF_MANAGE_ACTIVITY)
public class StaffManageActivity extends BaseActivity {

    @Override
    public int getContentView() {
        return R.layout.activity_staff_manage;
    }

    @Override
    protected void initView() {

    }
}
