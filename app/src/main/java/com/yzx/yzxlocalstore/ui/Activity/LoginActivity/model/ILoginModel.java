package com.yzx.yzxlocalstore.ui.Activity.LoginActivity.model;

import android.content.Context;

import com.yzx.yzxlocalstore.entity.User;

import java.util.List;

/**
 * Created by lyf on 2019/5/1.
 */

public interface ILoginModel {

     void initUserInfo();

     User checkUserLogin(Context context, String name, String pwd,int role);
}
