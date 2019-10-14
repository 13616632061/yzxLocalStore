package com.yzx.yzxlocalstore.ui.Activity.MainActivity.MainToAction;

import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.yzx.lib.util.EventBusMapUtil;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.utils.LoginUserUtil;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2019/8/1.
 * Mian页面跳转
 */

public class MainToAction {

    public static void toAction(Context context, String name) {
        if (context.getResources().getString(R.string.goodsManage).equals(name)) {//商品管理
            ARouter.getInstance().build(RouteMap.ROUTE_GOODS_MANAGE_ACTIVITY).navigation();
        } else if (context.getResources().getString(R.string.staffManage).equals(name)) {//员工管理
            ARouter.getInstance().build(RouteMap.ROUTE_STAFF_MANAGE_ACTIVITY).navigation();
        } else if (context.getResources().getString(R.string.orderManage).equals(name)) {//订单管理
            ARouter.getInstance().build(RouteMap.ROUTE_ORDER_MANAGE_ACTIVITY).navigation();
        }else if (context.getResources().getString(R.string.loginOut).equals(name)) {//登出
            EventBus.getDefault().post(EventBusMapUtil.getObjectMap("loginOut", null));
        }
    }
}
