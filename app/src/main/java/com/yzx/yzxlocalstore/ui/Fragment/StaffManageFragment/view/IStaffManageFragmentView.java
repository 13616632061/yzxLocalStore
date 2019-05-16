package com.yzx.yzxlocalstore.ui.Fragment.StaffManageFragment.view;

import com.yzx.yzxlocalstore.entity.User;

import java.util.List;

/**
 * Created by lyf on 2019/5/14.
 */

public interface IStaffManageFragmentView {

    void getStaffData(List<User> userList);

    //新增员工
    void routeAddStaffActivity();
}
