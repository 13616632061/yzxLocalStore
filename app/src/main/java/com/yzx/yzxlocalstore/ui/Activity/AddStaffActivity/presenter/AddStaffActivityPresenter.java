package com.yzx.yzxlocalstore.ui.Activity.AddStaffActivity.presenter;

import android.text.TextUtils;

import com.blankj.utilcode.util.LogUtils;
import com.yzx.lib.entity.MessageEvent;
import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.ui.Activity.AddStaffActivity.AddStaffActivity;
import com.yzx.yzxlocalstore.ui.Activity.AddStaffActivity.model.AddStaffActivityModel;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by lyf on 2019/5/21.
 */

public class AddStaffActivityPresenter implements IAddStaffActivityPresenter {

    private AddStaffActivity addStaffActivity;
    private AddStaffActivityModel addStaffActivityModel;

    public AddStaffActivityPresenter(AddStaffActivity addStaffActivity) {
        this.addStaffActivity = addStaffActivity;
        addStaffActivityModel = new AddStaffActivityModel();
    }

    @Override
    public void initCashAuthority() {
        addStaffActivity.initCashAuthority();
    }

    @Override
    public void submitStaffInfo() {

        if (TextUtils.isEmpty(addStaffActivity.getNumber())) {//编号
            addStaffActivity.addStaffFail(0);
            return;
        }
        if (TextUtils.isEmpty(addStaffActivity.getName())) {
            addStaffActivity.addStaffFail(1);//姓名
            return;
        }
        if (TextUtils.isEmpty(addStaffActivity.getPwd())) {
            addStaffActivity.addStaffFail(2);//密码
            return;
        }
        if (TextUtils.isEmpty(addStaffActivity.getSurePwd())) {
            addStaffActivity.addStaffFail(3);//确定密码
            return;
        }
        if (TextUtils.isEmpty(addStaffActivity.getPhone())) {
            addStaffActivity.addStaffFail(4);//手机号
            return;
        }
        if (TextUtils.isEmpty(addStaffActivity.getSalesCommission())) {
            addStaffActivity.addStaffFail(5);//销售提成
            return;
        }
        if (!addStaffActivity.getPwd().equals(addStaffActivity.getSurePwd())) {
            addStaffActivity.addStaffFail(6);//密码与确认密码是否一致
            return;
        }
        if (addStaffActivityModel.isExiteStaff(addStaffActivity.getNumber())) {
            addStaffActivity.addStaffFail(7);//员工是否存在
            return;
        }
        User user = new User();
        user.setStatus(addStaffActivity.isEnable());
        user.setNumber(addStaffActivity.getNumber());
        user.setName(addStaffActivity.getName());
        user.setPwd(addStaffActivity.getPwd());
        user.setPhone(addStaffActivity.getPhone());
        user.setSalesCommission(Double.parseDouble(addStaffActivity.getSalesCommission()));
        user.setLevel(1);
        user.setAccount(addStaffActivity.getNumber());

        addStaffActivityModel.addStaffInfo(user);
        addStaffActivity.addStaffSuccess();
        EventBus.getDefault().post(new MessageEvent("addStaffSuccess", ""));
    }
}
