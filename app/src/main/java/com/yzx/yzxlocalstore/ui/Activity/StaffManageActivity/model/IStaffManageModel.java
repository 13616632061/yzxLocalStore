package com.yzx.yzxlocalstore.ui.Activity.StaffManageActivity.model;

import android.content.Context;

import com.yzx.yzxlocalstore.entity.User;

import java.util.List;

/**
 * Created by lyf on 2019/5/14.
 */

public interface IStaffManageModel {

    //获取员工数据
    List<User> getStaffData(Context context);
}
