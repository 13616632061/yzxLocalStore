package com.yzx.yzxlocalstore.ui;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yzx.lib.base.BaseActivity;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.ui.LoginActivity.view.LoginActivity;
import com.yzx.yzxlocalstore.ui.MainActivity.view.MainActivity;

import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

@Route(path = RouteMap.ROUTE_SPLASH_ACTIVITY)
public class SplashActivity extends BaseActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        //将window的背景图设置为空
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

        //按home切换到后台，点击launcher的图标切换到前台，页面退出回到启动页
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }


}
