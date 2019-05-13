package com.yzx.yzxlocalstore.ui.Activity.ManageActivity.model;

import android.support.v4.app.Fragment;

import com.yzx.lib.base.BaseFragment;
import com.yzx.yzxlocalstore.entity.ManageType;

import java.util.List;

/**
 * Created by Administrator on 2019/5/7.
 */

public interface IManageActivityModel {
    /**
     * 获得管理分类数据
     *
     * @return
     */
    List<ManageType> initManageType();

    /**
     * 初始化Fragment
     * @return
     */
    List<Fragment> initManageFragment();
}
