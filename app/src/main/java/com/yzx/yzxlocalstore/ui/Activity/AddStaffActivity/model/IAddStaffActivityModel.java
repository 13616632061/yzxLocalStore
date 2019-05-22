package com.yzx.yzxlocalstore.ui.Activity.AddStaffActivity.model;

import com.yzx.yzxlocalstore.entity.User;

/**
 * Created by lyf on 2019/5/22.
 */

public interface IAddStaffActivityModel {
    //新增员工到数据表
    void addStaffInfo(User user);

    //判断员工是否存在
    boolean isExiteStaff(String nnumber);
}
