package com.yzx.yzxlocalstore.ui.Activity.AddStaffActivity.presenter;

import android.text.TextUtils;

import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.ui.Activity.AddStaffActivity.AddStaffActivity;

/**
 * Created by lyf on 2019/5/21.
 */

public class AddStaffActivityPresenter  implements IAddStaffActivityPresenter{

    private AddStaffActivity addStaffActivity;

    public AddStaffActivityPresenter(AddStaffActivity addStaffActivity) {
        this.addStaffActivity = addStaffActivity;
    }

    @Override
    public void initCashAuthority() {
        addStaffActivity.initCashAuthority();
    }

    @Override
    public void submitStaffInfo() {
        User user=new User();
        user.setEnable(addStaffActivity.isEnable());
        if(TextUtils.isEmpty(addStaffActivity.getNumber())){
            addStaffActivity.addStaffFail(0);
        }
    }
}
