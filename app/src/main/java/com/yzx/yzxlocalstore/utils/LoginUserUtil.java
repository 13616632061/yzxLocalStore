package com.yzx.yzxlocalstore.utils;

import com.yzx.yzxlocalstore.entity.User;

/**
 * Created by Administrator on 2019/7/19.
 * 登录用户信息
 */

public class LoginUserUtil {

    private static LoginUserUtil instance;

    private LoginUserUtil() {

    }

    public static LoginUserUtil getInstance() {
        if (instance == null) {
            synchronized (LoginUserUtil.class) {
                if (instance == null) {
                    instance = new LoginUserUtil();
                }
            }
        }
        return instance;
    }

    private User loginUser;

    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }
}
