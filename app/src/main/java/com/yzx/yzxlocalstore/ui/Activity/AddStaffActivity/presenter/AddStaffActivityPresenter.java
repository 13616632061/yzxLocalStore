package com.yzx.yzxlocalstore.ui.Activity.AddStaffActivity.presenter;

import android.text.TextUtils;

import com.apkfuns.logutils.LogUtils;
import com.yzx.lib.entity.MessageEvent;
import com.yzx.yzxlocalstore.constant.Constants;
import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.ui.Activity.AddStaffActivity.view.AddStaffActivity;
import com.yzx.yzxlocalstore.ui.Activity.AddStaffActivity.model.AddStaffActivityModel;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by lyf on 2019/5/21.
 */

public class AddStaffActivityPresenter implements IAddStaffActivityPresenter {

    private AddStaffActivity addStaffActivity;
    private AddStaffActivityModel addStaffActivityModel;
    private int level = 1;
    private long id;

    public AddStaffActivityPresenter(AddStaffActivity addStaffActivity) {
        this.addStaffActivity = addStaffActivity;
        addStaffActivityModel = new AddStaffActivityModel();
    }

    @Override
    public void initCashAuthority() {
        addStaffActivity.initCashAuthority();
    }

    @Override
    public void submitStaffInfo(int type) {

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
        if (type == 0 && addStaffActivityModel.isExiteStaff(addStaffActivity.getNumber())) {
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
        user.setLevel(level);
        if (type == 0) {//新增
            addStaffActivityModel.addStaffInfo(user);
        } else if (type == 1) {
            user.setId(id);
            LogUtils.e(user);
            addStaffActivityModel.updateStaffInfo(user);
        }

        addStaffActivity.addStaffSuccess(type);
        EventBus.getDefault().post(new MessageEvent("addStaffSuccess", ""));
    }

    @Override
    public void getStaffInfo(long id, int type) {
        addStaffActivity.initTitle(type);
        if (id == -1) {
            addStaffActivity.setRoles(Constants.STAFFER_ROLES[1]);
            return;
        }
        List<User> users = addStaffActivityModel.getStaffInfo(id);
        addStaffActivity.setEnable(users.get(0).getStatus());
        addStaffActivity.setNumber(users.get(0).getNumber());
        addStaffActivity.setName(users.get(0).getName());
        addStaffActivity.setPwd(users.get(0).getPwd());
        addStaffActivity.setSurePwd(users.get(0).getPwd());
        addStaffActivity.setPhone(users.get(0).getPhone());
        addStaffActivity.setRoles(users.get(0).getRoles());
        addStaffActivity.setSalesCommission(users.get(0).getSalesCommission() + "");
        level = users.get(0).getLevel();
        id=users.get(0).getId();
    }
}
