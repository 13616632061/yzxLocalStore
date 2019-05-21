package com.yzx.yzxlocalstore.ui.Activity.AddStaffActivity.view;

import com.yzx.yzxlocalstore.entity.User;

/**
 * Created by lyf on 2019/5/21.
 */

public interface IAddStaffActivityView {

    /**
     * 初始化收银权限
     */
    void initCashAuthority();

    User submitStaffInfo();
    //员工是否启用
    boolean isEnable();
    //员工编号
    String getNumber();
    //姓名
    String getName();
    //密码
    String getPwd();
    //二次确定密码
    String getSurePwd();
    //手机号码
    String getPhone();
    //销售提成
    String getSalesCommission();
    //新增成功
    void addStaffSuccess();
    //新增失败
    void addStaffFail(int type);

}
