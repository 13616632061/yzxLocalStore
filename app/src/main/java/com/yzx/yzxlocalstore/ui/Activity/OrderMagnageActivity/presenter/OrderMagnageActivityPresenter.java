package com.yzx.yzxlocalstore.ui.Activity.OrderMagnageActivity.presenter;

import android.support.v4.app.Fragment;

import com.yzx.yzxlocalstore.ui.Activity.OrderMagnageActivity.model.IOrderMagnageActivityModelImp;
import com.yzx.yzxlocalstore.ui.Activity.OrderMagnageActivity.model.OrderMagnageActivityModel;
import com.yzx.yzxlocalstore.ui.Activity.OrderMagnageActivity.view.OrderMagnageActivity;

import java.util.List;

/**
 * Created by Administrator on 2019/9/17.
 */

public class OrderMagnageActivityPresenter implements IOrderMagnageActivityPresenterImp {

    private OrderMagnageActivity mView;
    private OrderMagnageActivityModel mModel;

    public OrderMagnageActivityPresenter(OrderMagnageActivity mView) {
        this.mView = mView;
        mModel=new OrderMagnageActivityModel();
    }

    @Override
    public void initOrderManage() {
        List<Fragment> fragments = mModel.initOrderManage();
        mView.initOrderManage(fragments);
    }
}
