package com.yzx.yzxlocalstore.ui.Fragment.StaffFragment.model;

import android.support.v4.app.Fragment;

import com.yzx.yzxlocalstore.ui.Fragment.SensitiveOperationalRecordFragment.SensitiveOperationalRecordFragment;
import com.yzx.yzxlocalstore.ui.Fragment.StaffManageFragment.view.StaffManageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyf on 2019/5/9.
 */

public class StaffFragmentModel implements IStaffFragmentModel{
    @Override
    public List<Fragment> initStaffManageType() {
        List<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(new StaffManageFragment());
        fragmentList.add(new SensitiveOperationalRecordFragment());
        return fragmentList;
    }
}
