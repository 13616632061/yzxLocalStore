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

    public ManageFragmentAdapter(FragmentManager fm,List<BaseFragment> fragmentList) {
        super(fm);
        this.fragmentList=fragmentList;
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
        return Constants.MANAGE_TYPE[position];
    }
}
