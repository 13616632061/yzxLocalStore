package com.yzx.yzxlocalstore.ui.Activity.GoodsManage.GoodsInfoManageActivity.presenter;

import android.support.v4.app.Fragment;

import com.yzx.yzxlocalstore.ui.Activity.GoodsManage.GoodsInfoManageActivity.model.GoodsInfoManageActivityModel;
import com.yzx.yzxlocalstore.ui.Activity.GoodsManage.GoodsInfoManageActivity.view.GoodsInfoManageActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/7/2.
 */

public class GoodsInfoManageActivityPresenter implements IGoodsInfoManageActivityPresenterImp {

    private GoodsInfoManageActivity mView;
    private GoodsInfoManageActivityModel mModel;

    public GoodsInfoManageActivityPresenter(GoodsInfoManageActivity mView) {
        this.mView = mView;
        mModel = new GoodsInfoManageActivityModel();
    }

    @Override
    public void initGoodsManageType() {
        List<Fragment> fragments = mModel.initGoodsManageType();
        mView.initGoodsManageType(fragments);
    }
}
