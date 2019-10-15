package com.yzx.yzxlocalstore.ui.Activity.LoginActivity.view;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yzx.lib.base.BaseActivity;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.greendao.GreenDaoHelp;
import com.yzx.yzxlocalstore.ui.Activity.LoginActivity.presenter.LoginPresenter;

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
    @InjectView(R.id.rb_merchant)
    RadioButton rbMerchant;
    @InjectView(R.id.rb_clerk)
    RadioButton rbClerk;
    @InjectView(R.id.rg_role)
    RadioGroup rgRole;

    private LoginPresenter mPresenter;

    @Override
    public int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mPresenter = new LoginPresenter(this);
        mPresenter.setSelectRole(0);
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
            case 3:
                showToast(getResources().getString(R.string.permissions_fail));
                break;
        }
    }

    /**
     * 选择的登录角色
     *
     * @param position
     */
    @Override
    public void setSelectRole(int position) {
        switch (position) {
            case 0://商家
                rgRole.check(R.id.rb_merchant);
                break;
            case 1://员工
                rgRole.check(R.id.rb_clerk);
                break;
        }
    }

    /**
     * 获取的登录选择的角色
     * @return
     */
    @Override
    public int getSelectRole() {
        int loaction = 0;
        switch (rgRole.getCheckedRadioButtonId()) {
            case R.id.rb_merchant://商家
                loaction = 0;
                break;
            case R.id.rb_clerk://员工
                loaction = 1;
                break;
        }
        return loaction;
    }

    @OnClick({R.id.btn_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                mPresenter.Login();
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
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @PermissionSuccess(requestCode = 100)
    public void requestPermissionsSuccess() {
        mPresenter.setRequestPermissionsSuccess(true);
        GreenDaoHelp.getInstance(this);
        mPresenter.initUserInfo();

    }


    @PermissionFail(requestCode = 100)
    public void requestPermissionsFail() {
        LoginFail(3);
    }



}
