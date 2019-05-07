package com.yzx.yzxlocalstore.ui.Activity.ManageActivity.presenter;

import com.yzx.lib.base.BaseFragment;
import com.yzx.yzxlocalstore.entity.ManageType;
import com.yzx.yzxlocalstore.ui.Activity.ManageActivity.adapter.ManageTypeAdapter;
import com.yzx.yzxlocalstore.ui.Activity.ManageActivity.model.ManageActivityModel;
import com.yzx.yzxlocalstore.ui.Activity.ManageActivity.view.ManageActivity;

import java.util.List;

/**
 * Created by lyf on 2019/5/7.
 */

public class ManageActivityPresenter implements IManageActivityPresenter {

    private ManageActivityModel mManageActivityModel;
    private ManageActivity mManageActivity;

    public ManageActivityPresenter(ManageActivity mManageActivity) {
        this.mManageActivity = mManageActivity;
        mManageActivityModel = new ManageActivityModel();
    }

    @Override
    public void initManageType() {
        List<ManageType> manageTypeList = mManageActivityModel.initManageType();
        List<BaseFragment> fragmentList=mManageActivityModel.initManageFragment();

        mManageActivity.initManageType(manageTypeList,fragmentList);
    }
}
