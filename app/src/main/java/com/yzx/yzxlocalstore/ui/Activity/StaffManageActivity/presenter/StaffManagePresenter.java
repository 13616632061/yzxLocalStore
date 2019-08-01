package com.yzx.yzxlocalstore.ui.Activity.StaffManageActivity.presenter;

import com.alibaba.android.arouter.launcher.ARouter;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.ui.Activity.StaffManageActivity.model.StaffManageModel;
import com.yzx.yzxlocalstore.ui.Activity.StaffManageActivity.view.StaffManageActivity;

import java.util.List;

/**
 * Created by lyf on 2019/5/14.
 */

public class StaffManagePresenter implements IStaffManagePresenter {

    private StaffManageModel mModel;
    private StaffManageActivity mView;

    public StaffManagePresenter(StaffManageActivity mView) {
        this.mView = mView;
        mModel = new StaffManageModel();
    }

    @Override
    public void getStaffData() {
        List<User> userList = mModel.getStaffData(mView);
        mView.getStaffData(userList);

    }

    @Override
    public void routeAddStaffActivity() {
        ARouter.getInstance().build(RouteMap.ROUTE_ADDSTAFF_ACTIVITY)
                .withInt("type", 0)
                .navigation();
    }

    @Override
    public void routeEditStaffActivity(long id) {
        ARouter.getInstance().build(RouteMap.ROUTE_ADDSTAFF_ACTIVITY)
                .withInt("type", 1)
                .withLong("id", id)
                .navigation();
    }
}
