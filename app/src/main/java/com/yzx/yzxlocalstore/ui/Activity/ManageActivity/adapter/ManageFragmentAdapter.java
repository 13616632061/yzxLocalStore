package com.yzx.yzxlocalstore.ui.Activity.ManageActivity.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yzx.lib.base.BaseFragment;
import com.yzx.yzxlocalstore.constant.Constants;

import java.util.List;

/**
 * Created by lyf on 2019/5/7.
 */

public class ManageFragmentAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragmentList;
    private int type;//不同FragmentPager

    public ManageFragmentAdapter(FragmentManager fm, List<BaseFragment> fragmentList, int type) {
        super(fm);
        this.fragmentList = fragmentList;
        this.type = type;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (type == 0) {//管理类别（总）
            return Constants.MANAGE_TYPE[position];
        } else if (type == 1) {//员工管理类别
            return Constants.STAFFER_MANAGE_TYPE[position];
        } else {
            return null;
        }

    }
}
