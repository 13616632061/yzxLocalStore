package com.yzx.yzxlocalstore.ui.Activity.LoginActivity.presenter;

/**
 * Created by lyf on 2019/5/1.
 */

public interface ILoginPresenter {

    //获取权限是否成功
    public void setRequestPermissionsSuccess(boolean requestPermissionsSuccess);

    public boolean isRequestPermissionsSuccess();

    //初始化登录信息
    void initUserInfo();

    //登录
    void Login();

    //选择的登录角色
    void setSelectRole(int position);

}
