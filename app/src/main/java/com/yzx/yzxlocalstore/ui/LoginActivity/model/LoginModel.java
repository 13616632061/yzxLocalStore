package com.yzx.yzxlocalstore.ui.LoginActivity.model;

import android.content.Context;

import com.yzx.yzxlocalstore.app.MyAplication;
import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.greendao.DaoSession;
import com.yzx.yzxlocalstore.greendao.UserDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by lyf on 2019/5/1.
 */

public class LoginModel implements ILoginModel {

    private String adminName="admin";
    private String adminPwd="123456";

    /**
     * 初始化超级管理员账号
     * @param context
     * @return
     */

    @Override
    public List<User> initUserInfo(Context context) {
        DaoSession daoSession = ((MyAplication) context.getApplicationContext()).getDaoSession();
        QueryBuilder<User> userQueryBuilder=daoSession.queryBuilder(User.class);
        List<User> userList=userQueryBuilder.where(UserDao.Properties.Name.eq(adminName)).list();
        if (userList.size()<=0){
            User user=new User();
            user.setLevel(0);
            user.setName(adminName);
            user.setPwd(adminPwd);
            daoSession.insert(user);
        }
        return userList;
    }

    /**
     * 校验登录密码
     * @param context
     * @param name
     * @param pwd
     * @return
     */
    @Override
    public List<User> checkUserLogin(Context context,String name, String pwd) {
        DaoSession daoSession = ((MyAplication) context.getApplicationContext()).getDaoSession();
        QueryBuilder<User> userQueryBuilder=daoSession.queryBuilder(User.class);
        List<User> userList=userQueryBuilder.where(UserDao.Properties.Name.eq(name),
                UserDao.Properties.Pwd.eq(pwd)).list();

        return userList;
    }
}
