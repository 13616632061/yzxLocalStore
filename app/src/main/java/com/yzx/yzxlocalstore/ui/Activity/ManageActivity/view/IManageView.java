package com.yzx.yzxlocalstore.ui.Activity.ManageActivity.view;

import com.yzx.lib.base.BaseFragment;
import com.yzx.yzxlocalstore.entity.ManageType;
import com.yzx.yzxlocalstore.ui.Activity.ManageActivity.adapter.ManageTypeAdapter;

import java.util.List;

/**
 * Created by lyf on 2019/5/5.
 */

public interface IManageView {
    /**
     * 初始化管理分类
     */
    void initManageType(List<ManageType> manageTypeList,List<BaseFragment> fragmentList);

}
