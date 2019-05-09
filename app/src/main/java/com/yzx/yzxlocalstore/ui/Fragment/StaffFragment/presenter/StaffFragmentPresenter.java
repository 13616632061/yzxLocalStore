package com.yzx.yzxlocalstore.ui.Fragment.StaffFragment.presenter;

import com.yzx.lib.base.BaseFragment;
import com.yzx.yzxlocalstore.ui.Fragment.StaffFragment.model.StaffFragmentModel;
import com.yzx.yzxlocalstore.ui.Fragment.StaffFragment.view.StaffFragment;

import java.util.List;

/**
 * Created by lyf on 2019/5/9.
 */

public class StaffFragmentPresenter implements IStaffFragmentPresenter {

    private StaffFragment staffFragment;
    private StaffFragmentModel staffFragmentModel;

    public StaffFragmentPresenter(StaffFragment staffFragment) {
        this.staffFragment = staffFragment;
        staffFragmentModel = new StaffFragmentModel();
    }

    @Override
    public void initStaffManageType() {
        List<BaseFragment> fragmentList = staffFragmentModel.initStaffManageType();
        staffFragment.initStaffManageType(fragmentList);

    }
}
