package com.yzx.yzxlocalstore.ui.Fragment.StaffManageFragment.model;

import android.content.Context;

import com.yzx.yzxlocalstore.app.MyAplication;
import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.greendao.DaoSession;

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
        DaoSession daoSession=((MyAplication)context.getApplicationContext()).getDaoSession();
        QueryBuilder<User> queryBuilder=daoSession.queryBuilder(User.class);
        List<User> userList=queryBuilder.list();
        return userList;
    }
}
