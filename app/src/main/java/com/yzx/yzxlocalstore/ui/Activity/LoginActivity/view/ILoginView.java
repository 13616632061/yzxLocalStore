package com.yzx.yzxlocalstore.ui.Activity.LoginActivity.view;

/**
 * Created by lyf on 2019/5/1.
 */

public interface ILoginView {

    String getName();

    String getPwd();


    void LoginSuccess();

    void LoginFail(int failType);

    //选择的登录角色
    void setSelectRole(int position);

    //获取的登录选择的角色
    int getSelectRole();
}
