package com.yzx.yzxlocalstore.ui.Activity.LoginActivity.presenter;

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

    private LoginActivity loginActivity;
    private LoginModel loginModel;

    public LoginPresenter(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
        loginModel = new LoginModel();
        loginModel.initUserInfo(loginActivity);
    }

    @Override
    public void Login() {
        String name = loginActivity.getName();
        String pwd = loginActivity.getPwd();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
            loginActivity.LoginFail(1);
            return;
        }

        List<User> users = loginModel.checkUserLogin(loginActivity, name, pwd);

        if (users.size() > 0) {
            loginActivity.LoginSuccess();
            SPUtils.getInstance().put(Constants.LoginUser.LOGIN_USER_INFO_KEY, new Gson().toJson(users.get(0)));
            LoginUserUtil.getInstance().setLoginUser(users.get(0));

        } else {
            loginActivity.LoginFail(2);
        }
    }
}
