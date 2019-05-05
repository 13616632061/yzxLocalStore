package com.yzx.yzxlocalstore.ui.LoginActivity.view;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yzx.lib.base.BaseActivity;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.app.MyAplication;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.greendao.DaoSession;
import com.yzx.yzxlocalstore.ui.LoginActivity.presenter.LoginPresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

@Route(path = RouteMap.ROUTE_LOGIN_ACTIVITY)
public class LoginActivity extends BaseActivity implements ILoginView {


    @InjectView(R.id.et_name)
    EditText etName;
    @InjectView(R.id.et_pwd)
    EditText etPwd;

    private LoginPresenter loginPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        initPermission();

    }


    @Override
    public String getName() {
        return etName.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return etPwd.getText().toString().trim();
    }

    @Override
    public void LoginSuccess() {
        ARouter.getInstance().build(RouteMap.ROUTE_MAIN_ACTIVITY).navigation();
        finish();
    }

    @Override
    public void LoginFail(int failType) {

        switch (failType) {
            case 1:
                showToast(getResources().getString(R.string.empty_name_pwd));
                break;
            case 2:
                showToast(getResources().getString(R.string.error_name_pwd));
                break;
        }
    }

    @OnClick({R.id.btn_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                loginPresenter.Login();
                break;
        }
    }
    /**
     * 初始化权限
     */
    private void initPermission() {
        PermissionGen.with(this)
                .addRequestCode(100)//请求码
                .permissions(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                ).request();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionGen.onRequestPermissionsResult(this,requestCode,permissions,grantResults);
    }
    @PermissionSuccess(requestCode =100)
    public void  requestPermissionsSuccess(){
        loginPresenter = new LoginPresenter(this);
    }


    @PermissionFail(requestCode = 100)
    public void  requestPermissionsFail(){
        showToast(getResources().getString(R.string.permissions_fail));
    }
}
