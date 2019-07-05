package com.yzx.yzxlocalstore.ui.Activity.AddStaffActivity.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yzx.lib.base.BaseActivity;
import com.yzx.lib.weight.WarpLinearLayout;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.Constants;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.ui.Activity.AddStaffActivity.presenter.AddStaffActivityPresenter;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 新增员工
 */
@Route(path = RouteMap.ROUTE_ADDSTAFF_ACTIVITY)
public class AddStaffActivity extends BaseActivity implements IAddStaffActivityView {


    @InjectView(R.id.sw_start)
    Switch swStart;
    @InjectView(R.id.et_name)
    EditText etName;
    @InjectView(R.id.et_pwd)
    EditText etPwd;
    @InjectView(R.id.et_sure_pwd)
    EditText etSurePwd;
    @InjectView(R.id.et_phone)
    EditText etPhone;
    @InjectView(R.id.tv_roles)
    TextView tvRoles;
    @InjectView(R.id.et_sales_commission)
    EditText etSalesCommission;
    @InjectView(R.id.layout_cash_authority)
    WarpLinearLayout layoutCashAuthority;
    @InjectView(R.id.layout_more_authority)
    WarpLinearLayout layoutMoreAuthority;
    @InjectView(R.id.btn_save)
    Button btnSave;
    @InjectView(R.id.et_number)
    EditText etNumber;


    private boolean isChecked;
    private AddStaffActivityPresenter addStaffActivityPresenter;
    private int type = 0;
    private long id = -1;

    @Override
    public int getContentView() {
        return R.layout.activity_add_staff;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        if (intent != null) {
            type = intent.getIntExtra("type", 0);
            id = intent.getLongExtra("id", -1);
        }
        addStaffActivityPresenter = new AddStaffActivityPresenter(this);
        addStaffActivityPresenter.getStaffInfo(id, type);
        addStaffActivityPresenter.initCashAuthority();
    }

    @Override
    protected void initListener() {
        super.initListener();
        swStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isCheckedable) {
                isChecked = isCheckedable;
            }
        });
    }

    @Override
    public void initCashAuthority() {
        for (int i = 0; i < Constants.STAFFER_CASH_AUTHORITY.length; i++) {
            View view = View.inflate(AddStaffActivity.this, R.layout.item_authority_check_box, null);
            CheckBox checkbox = view.findViewById(R.id.checkbox);
            checkbox.setText(Constants.STAFFER_CASH_AUTHORITY[i]);
            layoutCashAuthority.addView(view);
        }

    }

    @Override
    public User submitStaffInfo() {

        return null;
    }

    @Override
    public void initTitle(int type) {
        switch (type) {
            case 0:
                inintTitle(getResources().getString(R.string.add_staff));
                break;
            case 1:
                inintTitle(getResources().getString(R.string.edit_staff));
                break;
        }
    }

    @Override
    public boolean isEnable() {
        return isChecked;
    }

    @Override
    public void setEnable(boolean enable) {
        swStart.setChecked(enable);
    }


    @Override
    public String getNumber() {
        return etNumber.getText().toString().trim();
    }

    @Override
    public void setNumber(String number) {
        etNumber.setText(number);
    }


    @Override
    public String getName() {
        return etName.getText().toString().trim();
    }

    @Override
    public void setName(String name) {
        etName.setText(name);
    }


    @Override
    public String getPwd() {
        return etPwd.getText().toString().trim();
    }

    @Override
    public void setPwd(String pwd) {
        etPwd.setText(pwd);
    }


    @Override
    public String getSurePwd() {
        return etSurePwd.getText().toString().trim();
    }

    @Override
    public void setSurePwd(String surePwd) {
        etSurePwd.setText(surePwd);
    }

    @Override
    public void setRoles(String roles) {
        tvRoles.setText(roles);
    }


    @Override
    public String getPhone() {
        return etPhone.getText().toString().trim();
    }

    @Override
    public void setPhone(String phone) {
        etPhone.setText(phone);
    }

    @Override
    public String getSalesCommission() {
        return etSalesCommission.getText().toString().trim();
    }

    @Override
    public void setSalesCommission(String salesCommission) {
        etSalesCommission.setText(salesCommission);
    }


    @Override
    public void addStaffSuccess(int type) {
        switch (type) {
            case 0:
                showToast(getResources().getString(R.string.add_success));
                break;
            case 1:
                showToast(getResources().getString(R.string.edit_success));
                break;
        }

        finish();
    }

    @Override
    public void addStaffFail(int type) {
        switch (type) {
            case 0:
                showToast(getResources().getString(R.string.empty_staff_number));
                break;
            case 1:
                showToast(getResources().getString(R.string.empty_staff_name));
                break;
            case 2:
                showToast(getResources().getString(R.string.empty_staff_pwd));
                break;
            case 3:
                showToast(getResources().getString(R.string.empty_staff_sure));
                break;
            case 4:
                showToast(getResources().getString(R.string.empty_staff_phone));
                break;
            case 5:
                showToast(getResources().getString(R.string.empty_staff_salescommission));
                break;
            case 6:
                showToast(getResources().getString(R.string.pwd_equal_surepwd));
                break;
            case 7:
                showToast(getResources().getString(R.string.staff_is_exite));
                break;
        }

    }

    @OnClick({R.id.btn_save})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                addStaffActivityPresenter.submitStaffInfo(type);
                break;

        }
    }

}
