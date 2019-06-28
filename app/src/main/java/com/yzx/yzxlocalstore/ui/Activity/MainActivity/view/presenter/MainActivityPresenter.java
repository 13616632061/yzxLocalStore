package com.yzx.yzxlocalstore.ui.Activity.MainActivity.view.presenter;

import com.yzx.yzxlocalstore.ui.Activity.MainActivity.view.view.MainActivity;

/**
 * Created by Administrator on 2019/6/28.
 */

public class MainActivityPresenter implements IMainActivityPresenterImp {

    private MainActivity mView;

    public MainActivityPresenter(MainActivity mView) {
        this.mView = mView;
    }

    @Override
    public void showMoreTypeChannel() {
        mView.showMoreTypeChannel();
    }
}
