package com.yzx.yzxlocalstore.ui.Fragment.StaffManageFragment.model;

import android.content.Context;

import com.yzx.yzxlocalstore.app.MyAplication;
import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.greendao.DaoSession;
import com.yzx.yzxlocalstore.greendao.GreenDaoHelp;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by lyf on 2019/5/14.
 */

public class StaffManageFragmentModel implements IStaffManageFragmentModel {

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
