package com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.presenter;

import com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.view.GoodsTypeFragment;

/**
 * Created by Administrator on 2019/7/2.
 */

public class GoodsTypeFragmentPresenter implements IGoodsTypeFragmentPresenterImp {
    private GoodsTypeFragment mView;

    public GoodsTypeFragmentPresenter(GoodsTypeFragment mView) {
        this.mView = mView;
    }

    @Override
    public void initAdapter() {
        mView.initAdapter();
    }

    @Override
    public void addGoodsType() {
        mView.addGoodsType();
    }

    @Override
    public void deleteGoodsType() {

    }

    @Override
    public void editGoodsType() {

    }
}
