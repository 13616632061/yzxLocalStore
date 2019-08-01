package com.yzx.yzxlocalstore.ui.Activity.StaffManageActivity.presenter;

/**
 * Created by lyf on 2019/5/14.
 */

public interface IStaffManagePresenter {

    //获取员工数据
    void getStaffData();

    //新增员工
    void routeAddStaffActivity();

    //编辑员工
    void routeEditStaffActivity(long id);
}
