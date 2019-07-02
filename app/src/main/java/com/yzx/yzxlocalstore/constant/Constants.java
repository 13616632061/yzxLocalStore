package com.yzx.yzxlocalstore.constant;

import com.yzx.yzxlocalstore.entity.User;

/**
 * Created by lyf on 2019/5/7.
 */

public class Constants {
    //登录用户信息
    public static User loginUserInfo;
    //管理分类
    public static String[] MANAGE_TYPE = new String[]{"报表", "商品", "出入库", "盘点", "员工", "会员", "设置", "关于"};
    //员工管理分类
    public static String[] STAFFER_MANAGE_TYPE = new String[]{"员工管理", "敏感操作记录"};
    //员工角色
    public static String[] STAFFER_ROLES = new String[]{"商家", "员工"};
    //员工状态
    public static String[] STAFFER_STATUS = new String[]{"开启", "禁用"};
    //收银权限
    public static String[] STAFFER_CASH_AUTHORITY = new String[]{"显示进货价", "显示利润", "显示库存"};
    //商品管理分类
    public static String[] GOODS_MANAGE_TYPE = new String[]{"商品列表", "商品分类"};
}
