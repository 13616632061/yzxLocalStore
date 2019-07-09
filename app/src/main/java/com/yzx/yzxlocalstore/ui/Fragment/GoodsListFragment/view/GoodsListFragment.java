package com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.view;

import android.Manifest;
import android.hardware.Camera;
import android.support.annotation.NonNull;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.yzx.lib.base.BaseFragment;
import com.yzx.yzxlocalstore.R;

import java.io.IOException;

import butterknife.InjectView;
import kr.co.namee.permissiongen.PermissionGen;

/**
 * Created by Administrator on 2019/7/2.
 */

public class GoodsListFragment extends BaseFragment  implements IGoodsListFragmentView{


    @Override
    protected int setContentViewId() {
        return R.layout.goods_list_layout;
    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);

    }



    @Override
    protected void loadData() {

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
