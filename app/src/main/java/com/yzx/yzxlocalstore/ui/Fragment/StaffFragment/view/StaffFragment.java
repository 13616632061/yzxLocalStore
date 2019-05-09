package com.yzx.yzxlocalstore.ui.Fragment.StaffFragment.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nshmura.recyclertablayout.RecyclerTabLayout;
import com.yzx.lib.base.BaseFragment;
import com.yzx.lib.weight.NoScrollViewPager;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.ui.Activity.ManageActivity.adapter.ManageFragmentAdapter;
import com.yzx.yzxlocalstore.ui.Fragment.StaffFragment.presenter.StaffFragmentPresenter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by lyf on 2019/5/7.
 * 员工
 */

public class StaffFragment extends BaseFragment implements IStaffFragmentView{
    @InjectView(R.id.tab_layout)
    RecyclerTabLayout tabLayout;
    @InjectView(R.id.view_pager)
    NoScrollViewPager viewPager;

    private StaffFragmentPresenter staffFragmentPresenter;
    private ManageFragmentAdapter adapter;

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_staff;
    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        staffFragmentPresenter=new StaffFragmentPresenter(this);
        staffFragmentPresenter.initStaffManageType();
    }

    @Override
    protected void loadData() {

    }


    @Override
    public void initStaffManageType(List<BaseFragment> fragmentList) {
        adapter=new ManageFragmentAdapter(getChildFragmentManager(),fragmentList,1);
        viewPager.setAdapter(adapter);
        tabLayout.setUpWithViewPager(viewPager);
        tabLayout.setLayoutDirection(LinearLayoutManager.VERTICAL);
    }
}
