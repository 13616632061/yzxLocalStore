package com.yzx.yzxlocalstore.ui.Activity.MainActivity.view.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yzx.lib.base.BaseActivity;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.view.presenter.MainActivityPresenter;
import com.yzx.yzxlocalstore.ui.PopWindow.MainMenuPopWindow;

import butterknife.OnClick;

@Route(path = RouteMap.ROUTE_MAIN_ACTIVITY)
public class MainActivity extends BaseActivity implements IMainActivityView {

    private MainActivityPresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mPresenter = new MainActivityPresenter(this);
    }

    @OnClick({R.id.btn_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_more:
//                ARouter.getInstance().build(RouteMap.ROUTE_MANAGE_ACTIVITY).navigation();
                mPresenter.showMoreTypeChannel();
                break;
        }
    }

    //显示更多分类信息
    @Override
    public void showMoreTypeChannel() {
        MainMenuPopWindow menuPopWindow = new MainMenuPopWindow(this);
        menuPopWindow.showAtLocation(findViewById(R.id.main_activity), Gravity.NO_GRAVITY, 0, 0);

    }
}
