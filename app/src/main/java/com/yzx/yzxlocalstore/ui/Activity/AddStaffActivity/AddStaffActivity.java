package com.yzx.yzxlocalstore.ui.Activity.AddStaffActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yzx.lib.base.BaseActivity;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;

/**
 * 新增员工
 */
@Route(path = RouteMap.ROUTE_ADDSTAFF_ACTIVITY)
public class AddStaffActivity extends BaseActivity {



    @Override
    public int getContentView() {
        return R.layout.activity_add_staff;
    }

    @Override
    protected void initView() {

    }
}
