package com.yzx.yzxlocalstore.ui.Activity.StaffManageActivity.model;

import android.content.Context;

import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.greendao.GreenDaoHelp;

import java.util.List;

/**
 * Created by lyf on 2019/5/14.
 */

public class StaffManageModel implements IStaffManageModel {

    /**
     * 获取所有员工数据信息
     * @param context
     * @return
     */
    @Override
    public List<User> getStaffData(Context context) {
        List<User> userList =GreenDaoHelp.getDaoSession().getUserDao().queryBuilder().list();
        return userList;
    }
}
