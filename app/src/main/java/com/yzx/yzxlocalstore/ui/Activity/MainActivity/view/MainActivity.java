package com.yzx.yzxlocalstore.ui.Activity.MainActivity.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yzx.lib.base.BaseActivity;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.TypeBean;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.presenter.MainActivityPresenter;
import com.yzx.yzxlocalstore.ui.Adapter.MainBottomTypeAdapter;
import com.yzx.yzxlocalstore.ui.PopWindow.MainMenuPopWindow.view.MainMenuPopWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

@Route(path = RouteMap.ROUTE_MAIN_ACTIVITY)
public class MainActivity extends BaseActivity implements IMainActivityView {

    @InjectView(R.id.list_bottom)
    RecyclerView listBottom;
    private MainActivityPresenter mPresenter;
    private MainBottomTypeAdapter mBottomTypeAdapter;
    private List<TypeBean> mBottomTypeData = new ArrayList<>();

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mPresenter = new MainActivityPresenter(this);
        mPresenter.initTypeChannel();
        mPresenter.setBottomTypeView();
        mPresenter.getBottomType();
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
        MainMenuPopWindow menuPopWindow = new MainMenuPopWindow(this);
        menuPopWindow.showAtLocation(findViewById(R.id.main_activity), Gravity.NO_GRAVITY, 0, 0);

    }

    /**
     * 设置底部功能分类视图
     */
    @Override
    public void setBottomTypeView() {
        mBottomTypeAdapter = new MainBottomTypeAdapter(this, R.layout.item_main_bottom_type, mBottomTypeData);
        listBottom.setAdapter(mBottomTypeAdapter);
        listBottom.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    /**
     * 底部功能管理分类适配器
     *
     * @return
     */
    @Override
    public MainBottomTypeAdapter mainBottomTypeAdapter() {
        return mBottomTypeAdapter;
    }

    /**
     * 底部功能管理分类数据
     *
     * @return
     */
    @Override
    public List<TypeBean> mBottomTypeData() {
        return mBottomTypeData;
    }


}
