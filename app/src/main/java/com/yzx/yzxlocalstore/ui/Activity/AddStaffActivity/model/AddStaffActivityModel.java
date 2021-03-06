package com.yzx.yzxlocalstore.ui.Activity.AddStaffActivity.model;

import android.content.Context;

import com.yzx.yzxlocalstore.app.MyAplication;
import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.greendao.DaoSession;
import com.yzx.yzxlocalstore.greendao.GreenDaoHelp;
import com.yzx.yzxlocalstore.greendao.UserDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by lyf on 2019/5/22.
 */

public class AddStaffActivityModel implements IAddStaffActivityModel {


    @Override
    public void addStaffInfo(User user) {
        GreenDaoHelp.getDaoSession().getUserDao().insert(user);

    }

    @Override
    public void updateStaffInfo(User user) {
        GreenDaoHelp.getDaoSession().getUserDao().update(user);
    }

    @Override
    public boolean isExiteStaff(String number) {
        boolean isExite = false;
        QueryBuilder<User> userQueryBuilder = GreenDaoHelp.getDaoSession().queryBuilder(User.class);
        List<User> userList = userQueryBuilder.where(UserDao.Properties.Number.eq(number)).list();
        if (userList.size() > 0) {
            isExite = true;
        }
        return isExite;
    }

    @Override
    public List<User> getStaffInfo(long id) {
        QueryBuilder<User> userQueryBuilder = GreenDaoHelp.getDaoSession().queryBuilder(User.class);
        List<User> userList = userQueryBuilder.where(UserDao.Properties.Id.eq(id)).list();
        return userList;
    }
}
