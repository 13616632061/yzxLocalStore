package com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.yzx.lib.base.BaseFragment;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.presenter.GoodsListFragmentPresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/7/2.
 */

public class GoodsListFragment extends BaseFragment implements IGoodsListFragmentView {


    @InjectView(R.id.tv_all_nums)
    TextView tvAllNums;
    @InjectView(R.id.tv_all_type)
    TextView tvAllType;
    @InjectView(R.id.tv_lack_type)
    TextView tvLackType;
    @InjectView(R.id.tv_warning_type)
    TextView tvWarningType;
    @InjectView(R.id.iv_all_select)
    ImageView ivAllSelect;


    private GoodsListFragmentPresenter mPresenter;

    @Override
    protected int setContentViewId() {
        return R.layout.goods_list_layout;
    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        mPresenter = new GoodsListFragmentPresenter(this);
    }


    @Override
    protected void loadData() {

    }

    @OnClick({R.id.btn_add_goods, R.id.btn_delete_goods, R.id.btn_up_shelf, R.id.btn_down_shelf, R.id.btn_import, R.id.btn_export, R.id.btn_print})
    public void setOnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_goods://新增商品
                mPresenter.addGoodsInfo();
                break;
            case R.id.btn_delete_goods://删除商品
                break;
            case R.id.btn_up_shelf://上架商品
                break;
            case R.id.btn_down_shelf://下架商品
                break;
            case R.id.btn_import://导入商品
                break;
            case R.id.btn_export://导出商品
                break;
            case R.id.btn_print://打印标签
                break;
        }
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

    @Override
    public void addGoodsInfo() {
        ARouter.getInstance().build(RouteMap.ROUTE_ADD_GOODS_INFO_ACTIVITY).navigation();
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
