package com.yzx.yzxlocalstore.ui.Activity.MainActivity.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yzx.lib.base.BaseActivity;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.TypeBean;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.presenter.MainActivityPresenter;
import com.yzx.yzxlocalstore.ui.Adapter.MainBottomTypeAdapter;
import com.yzx.yzxlocalstore.ui.PopWindow.MainMenuPopWindow.view.MainMenuPopWindow;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        EventBus.getDefault().register(this);
        mPresenter = new MainActivityPresenter(this);
        mPresenter.initTypeChannel();
        mPresenter.setBottomTypeView();
        mPresenter.getBottomType();
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
        mBottomTypeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.setBottomTypeOnClick(mBottomTypeData.get(position).getName());
            }
        });

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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvenBus(Map<Object, Object> map) {
        if (map.containsKey("updateManageType")) {//更新底部管理分类
            mPresenter.getBottomType();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
