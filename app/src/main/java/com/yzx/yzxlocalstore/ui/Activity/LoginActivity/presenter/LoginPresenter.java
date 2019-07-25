package com.yzx.yzxlocalstore.ui.Activity.LoginActivity.presenter;

import android.support.v7.view.menu.MenuView;
import android.text.TextUtils;

import com.apkfuns.logutils.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.yzx.yzxlocalstore.constant.Constants;
import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.ui.Activity.LoginActivity.model.LoginModel;
import com.yzx.yzxlocalstore.ui.Activity.LoginActivity.view.LoginActivity;
import com.yzx.yzxlocalstore.utils.LoginUserUtil;

import java.util.List;

/**
 * Created by lyf on 2019/5/1.
 */

public class LoginPresenter implements ILoginPresenter {

    private LoginActivity mView;
    private LoginModel loginModel;
    private boolean requestPermissionsSuccess;

    public LoginPresenter(LoginActivity mView) {
        this.mView = mView;
        loginModel = new LoginModel();
    }

    /**
     * 获取权限是否成功
     *
     * @param requestPermissionsSuccess
     */
    @Override
    public void setRequestPermissionsSuccess(boolean requestPermissionsSuccess) {
        this.requestPermissionsSuccess = requestPermissionsSuccess;
    }

    @Override
    public boolean isRequestPermissionsSuccess() {
        return requestPermissionsSuccess;
    }

    /**
     * 初始化登录信息
     */
    @Override
    public void initUserInfo() {
        loginModel.initUserInfo();
    }

    /**
     * 登录
     */
    @Override
    public void Login() {
        if (!requestPermissionsSuccess) {
            mView.LoginFail(3);
            return;
        }
        String name = mView.getName();
        String pwd = mView.getPwd();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
            mView.LoginFail(1);
            return;
        }

        List<User> users = loginModel.checkUserLogin(mView, name, pwd);

        if (users.size() > 0) {
            mView.LoginSuccess();
            SPUtils.getInstance().put(Constants.LoginUser.LOGIN_USER_INFO_KEY, new Gson().toJson(users.get(0)));
            LoginUserUtil.getInstance().setLoginUser(users.get(0));

        } else {
            mView.LoginFail(2);
        }
    }
}
