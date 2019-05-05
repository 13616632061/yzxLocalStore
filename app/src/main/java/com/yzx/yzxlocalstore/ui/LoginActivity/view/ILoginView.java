package com.yzx.yzxlocalstore.ui.LoginActivity.view;

/**
 * Created by lyf on 2019/5/1.
 */

public interface ILoginView {

    String getName();

    String getPwd();


    void LoginSuccess();

    void LoginFail(int failType);
}
