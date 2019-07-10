package com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.presenter;

import com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.view.GoodsListFragment;

/**
 * Created by Administrator on 2019/7/9.
 */

public class GoodsListFragmentPresenter implements IGoodsListFragmentPresenterImp {

    private GoodsListFragment mView;

    public GoodsListFragmentPresenter(GoodsListFragment mView) {
        this.mView = mView;
    }

    @Override
    public void initAdapter() {

    }

    @Override
    public void allGoodsInfo() {

    }

    @Override
    public void lackGoodsInfo() {

    }

    @Override
    public void warningGoodsInfo() {

    }

    //添加商品
    @Override
    public void addGoodsInfo() {
        mView.addGoodsInfo();
    }

    @Override
    public void deteleGoodsInfo() {

    }

    @Override
    public void upShelfGoodsInfo() {

    }

    @Override
    public void dowmShelfGoodsInfo() {

    }

    @Override
    public void importGoodsInfo() {

    }

    @Override
    public void exportGoodsInfo() {

    }

    @Override
    public void printLabel() {

    }

    @Override
    public void firstPage() {

    }

    @Override
    public void lastPage() {

    }

    @Override
    public void previousPage() {

    }

    @Override
    public void nextPage() {

    }
}
