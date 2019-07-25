package com.yzx.yzxlocalstore.ui.Activity.LoginActivity.model;

import android.content.Context;

import com.yzx.yzxlocalstore.entity.User;

import java.util.List;

/**
 * Created by lyf on 2019/5/1.
 */

public interface ILoginModel {

     List<User> initUserInfo();

     List<User> checkUserLogin(Context context, String name, String pwd);
}
