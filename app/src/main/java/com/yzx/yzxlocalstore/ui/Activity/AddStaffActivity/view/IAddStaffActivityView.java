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

    //初始化页面标题
    void initTitle(int type);

    //员工是否启用
    boolean isEnable();

    //设置员工是否启用
    void setEnable(boolean enable);

    //员工编号
    String getNumber();

    void setNumber(String number);

    //姓名
    String getName();

    void setName(String name);

    //密码
    String getPwd();

    void setPwd(String pwd);

    //二次确定密码
    String getSurePwd();

    void setSurePwd(String surePwd);

    //初始化角色信息
    void setRoles(String roles);

    //手机号码
    String getPhone();

    void setPhone(String phone);

    //销售提成
    String getSalesCommission();

    void setSalesCommission(String salesCommission);

    //新增成功
    void addStaffSuccess(int type);

    //新增失败
    void addStaffFail(int type);

}
