package com.yzx.yzxlocalstore.ui.Activity.MainActivity.view;

import android.view.Gravity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yzx.lib.base.BaseActivity;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.presenter.MainActivityPresenter;
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
        mPresenter.getTypeChannel();
    }

    @OnClick({R.id.btn_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_more:
                mPresenter.showMoreTypeChannel();
                break;
        }
    }

    //显示更多分类信息
    @Override
    public void showMoreTypeChannel() {
        MainMenuPopWindow menuPopWindow = new MainMenuPopWindow(this,mPresenter);
        menuPopWindow.showAtLocation(findViewById(R.id.main_activity), Gravity.NO_GRAVITY, 0, 0);

    }
}
