package com.yzx.yzxlocalstore.ui.Fragment.StaffFragment.model;

import com.yzx.lib.base.BaseFragment;
import com.yzx.yzxlocalstore.ui.Fragment.SensitiveOperationalRecordFragment.SensitiveOperationalRecordFragment;
import com.yzx.yzxlocalstore.ui.Fragment.StaffFragment.view.IStaffFragmentView;
import com.yzx.yzxlocalstore.ui.Fragment.StaffManageFragment.StaffManageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyf on 2019/5/9.
 */

public class StaffFragmentModel implements IStaffFragmentModel{
    @Override
    public List<BaseFragment> initStaffManageType() {
        List<BaseFragment> fragmentList=new ArrayList<>();
        fragmentList.add(new StaffManageFragment());
        fragmentList.add(new SensitiveOperationalRecordFragment());
        return fragmentList;
    }
}
