package com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.presenter;

import com.apkfuns.logutils.LogUtils;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.model.GoodsListFragmentModel;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.view.GoodsListFragment;

import java.util.List;

/**
 * Created by Administrator on 2019/7/9.
 */

public class GoodsListFragmentPresenter implements IGoodsListFragmentPresenterImp {

    private GoodsListFragment mView;
    private GoodsListFragmentModel mModel;

    public GoodsListFragmentPresenter(GoodsListFragment mView) {
        this.mView = mView;
        mModel = new GoodsListFragmentModel();
    }

    @Override
    public void initAdapter() {
        mView.initAdapter();
    }

    /**
     * 查询商品
     *
     * @param page 页数
     */
    @Override
    public void getGoodsInfo(int page) {
        List<GoodsInfo> goodsInfoList = mModel.getGoodsInfo(page);
        mView.getData().clear();
        mView.getData().addAll(goodsInfoList);
        mView.getAdapter().notifyDataSetChanged();
    }

    /**
     * 商品选中状态
     *
     * @param type     0全选，1单个选中
     * @param position
     */
    @Override
    public void editGoodsInfoSelectStatus(int type, int position) {
        switch (type) {
            case 0://全选
                if (mView.isAllSelect()) {
                    mView.setAllSelect(false);
                    for (int i = 0; i < mView.getData().size(); i++) {
                        mView.getData().get(i).setIsSelect(false);
                    }
                } else {
                    mView.setAllSelect(true);
                    for (int i = 0; i < mView.getData().size(); i++) {
                        mView.getData().get(i).setIsSelect(true);
                    }
                }
                mView.showAllSelectStatus();
                mView.getAdapter().notifyDataSetChanged();
                break;
            case 1://单个选中
                if (mView.getData().get(position).getIsSelect()) {
                    mView.getData().get(position).setIsSelect(false);
                } else {
                    mView.getData().get(position).setIsSelect(true);
                }
                mView.setAllSelect(isAllSelect());
                mView.showAllSelectStatus();
                mView.getAdapter().notifyDataSetChanged();
                break;

        }
    }

    /**
     * 是否全部选中
     *
     * @return
     */
    @Override
    public boolean isAllSelect() {
        boolean isAllSelect = true;
        if (mView.getData().size() <= 0) {
            isAllSelect = false;
        }
        for (int i = 0; i < mView.getData().size(); i++) {
            if (!mView.getData().get(i).getIsSelect()) {
                isAllSelect = false;
                break;
            }
        }
        return isAllSelect;
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
