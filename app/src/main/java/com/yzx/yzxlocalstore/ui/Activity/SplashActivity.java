package com.yzx.yzxlocalstore.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.apkfuns.logutils.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.yzx.lib.base.BaseActivity;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.Constants;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.greendao.GreenDaoHelp;
import com.yzx.yzxlocalstore.ui.Activity.LoginActivity.view.LoginActivity;
import com.yzx.yzxlocalstore.utils.LoginUserUtil;

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
        String loginUserStr = SPUtils.getInstance().getString(Constants.LoginUser.LOGIN_USER_INFO_KEY);
        if (TextUtils.isEmpty(loginUserStr)) {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
        } else {
            GreenDaoHelp.getInstance(this);
            User loginUser = new Gson().fromJson(SPUtils.getInstance().getString(Constants.LoginUser.LOGIN_USER_INFO_KEY), User.class);
            LoginUserUtil.getInstance().setLoginUser(loginUser);
            ARouter.getInstance().build(RouteMap.ROUTE_MAIN_ACTIVITY).navigation();
        }
        finish();
    }


}
