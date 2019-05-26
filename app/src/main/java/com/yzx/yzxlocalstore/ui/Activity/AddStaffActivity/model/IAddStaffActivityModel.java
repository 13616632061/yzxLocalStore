package com.yzx.yzxlocalstore.ui.Activity.AddStaffActivity.model;

import com.yzx.yzxlocalstore.entity.User;

import java.util.List;

/**
 * Created by lyf on 2019/5/22.
 */

public interface IAddStaffActivityModel {
    //新增员工到数据表
    void addStaffInfo(User user);

    //更新员工数据
    void updateStaffInfo(User user);

    //判断员工是否存在
    boolean isExiteStaff(String nnumber);

    //根据id获取员工信息
    List<User> getStaffInfo(long id);

}
