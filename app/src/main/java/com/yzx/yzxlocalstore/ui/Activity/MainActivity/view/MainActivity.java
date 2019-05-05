package com.yzx.yzxlocalstore.ui.Activity.MainActivity.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yzx.lib.base.BaseActivity;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;

import butterknife.OnClick;

@Route(path = RouteMap.ROUTE_MAIN_ACTIVITY)
public class MainActivity extends BaseActivity {


    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.btn_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_more:

                break;
        }
    }
}
