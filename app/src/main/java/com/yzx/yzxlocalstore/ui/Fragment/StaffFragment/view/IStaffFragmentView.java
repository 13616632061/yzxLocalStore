package com.yzx.yzxlocalstore.ui.Fragment.StaffFragment.view;

import android.support.v4.app.Fragment;

import com.yzx.lib.base.BaseFragment;

import java.util.List;

/**
 * Created by lyf on 2019/5/9.
 */

public interface IStaffFragmentView {
    /**
     * 初始化员工管理分类
     */
    void initStaffManageType(List<Fragment> fragmentList);
}
