package com.yzx.yzxlocalstore.ui.Activity.AddStaffActivity.presenter;

import android.text.TextUtils;

import com.apkfuns.logutils.LogUtils;
import com.yzx.lib.entity.MessageEvent;
import com.yzx.yzxlocalstore.R;
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

    private AddStaffActivity mView;
    private AddStaffActivityModel mModel;
    private List<User> users;

    public AddStaffActivityPresenter(AddStaffActivity mView) {
        this.mView = mView;
        mModel = new AddStaffActivityModel();
    }

    @Override
    public void initCashAuthority() {
        mView.initCashAuthority();
    }

    @Override
    public void submitStaffInfo(int type) {

        if (TextUtils.isEmpty(mView.getNumber())) {//编号
            mView.addStaffFail(0);
            return;
        }
        if (TextUtils.isEmpty(mView.getName())) {
            mView.addStaffFail(1);//姓名
            return;
        }
        if (TextUtils.isEmpty(mView.getPwd())) {
            mView.addStaffFail(2);//密码
            return;
        }
        if (TextUtils.isEmpty(mView.getSurePwd())) {
            mView.addStaffFail(3);//确定密码
            return;
        }
        if (TextUtils.isEmpty(mView.getPhone())) {
            mView.addStaffFail(4);//手机号
            return;
        }
        if (TextUtils.isEmpty(mView.getSalesCommission())) {
            mView.addStaffFail(5);//销售提成
            return;
        }
        if (!mView.getPwd().equals(mView.getSurePwd())) {
            mView.addStaffFail(6);//密码与确认密码是否一致
            return;
        }
        if (type == 0 && mModel.isExiteStaff(mView.getNumber())) {
            mView.addStaffFail(7);//员工是否存在
            return;
        }

        if (type == 0) {//新增
            User user = new User();
            user.setStatus(mView.isEnable());
            user.setNumber(mView.getNumber());
            user.setName(mView.getName());
            user.setPwd(mView.getPwd());
            user.setPhone(mView.getPhone());
            user.setSalesCommission(Double.parseDouble(mView.getSalesCommission()));
            user.setLevel(1);
            mModel.addStaffInfo(user);
        } else if (type == 1) {//编辑
            LogUtils.e(users);
            users.get(0).setStatus(mView.isEnable());
            users.get(0).setStatus(mView.isEnable());
            users.get(0).setNumber(mView.getNumber());
            users.get(0).setName(mView.getName());
            users.get(0).setPwd(mView.getPwd());
            users.get(0).setPhone(mView.getPhone());
            users.get(0).setSalesCommission(Double.parseDouble(mView.getSalesCommission()));
            mModel.updateStaffInfo(users.get(0));
        }

        if (mModel.isExiteStaff(mView.getNumber())) {
            mView.addStaffSuccess(type);
            EventBus.getDefault().post(new MessageEvent("addStaffSuccess", ""));
        }

    }

    @Override
    public void getStaffInfo(long id, int type) {
        mView.initTitle(type);
        if (id == -1) {
            mView.setRoles(mView.getResources().getString(R.string.staffer));
            return;
        }
        users = mModel.getStaffInfo(id);
        if (users.size() > 0) {
            mView.setEnable(users.get(0).getStatus());
            mView.setNumber(users.get(0).getNumber());
            mView.setName(users.get(0).getName());
            mView.setPwd(users.get(0).getPwd());
            mView.setSurePwd(users.get(0).getPwd());
            mView.setPhone(users.get(0).getPhone());
            if (users.get(0).getLevel() == 0) {
                mView.setRoles(mView.getResources().getString(R.string.business));
            } else {
                mView.setRoles(mView.getResources().getString(R.string.staffer));
            }
            mView.setSalesCommission(users.get(0).getSalesCommission() + "");
        }
    }
}
