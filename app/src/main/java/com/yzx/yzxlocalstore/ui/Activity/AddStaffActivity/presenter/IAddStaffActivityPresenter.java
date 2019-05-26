package com.yzx.yzxlocalstore.ui.Activity.AddStaffActivity.presenter;

import com.yzx.yzxlocalstore.entity.User;

/**
 * Created by lyf on 2019/5/21.
 */

public interface IAddStaffActivityPresenter {

    /**
     * 初始化收银权限
     */
    void initCashAuthority();

    void submitStaffInfo(int type);

    void getStaffInfo(long id,int type);
}
