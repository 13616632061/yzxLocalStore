package com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment;

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

public class GoodsListFragment extends BaseFragment  {


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


}
