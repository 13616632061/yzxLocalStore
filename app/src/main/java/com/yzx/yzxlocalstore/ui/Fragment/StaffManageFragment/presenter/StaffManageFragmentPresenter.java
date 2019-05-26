package com.yzx.yzxlocalstore.ui.Fragment.StaffManageFragment.presenter;

import android.app.Activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.ui.Fragment.StaffFragment.presenter.IStaffFragmentPresenter;
import com.yzx.yzxlocalstore.ui.Fragment.StaffManageFragment.model.StaffManageFragmentModel;
import com.yzx.yzxlocalstore.ui.Fragment.StaffManageFragment.view.StaffManageFragment;

import java.util.List;

/**
 * Created by lyf on 2019/5/14.
 */

public class StaffManageFragmentPresenter implements IStaffManageFragmentPresenter {

    private Activity mActivity;
    private StaffManageFragmentModel staffManageFragmentModel;
    private StaffManageFragment staffManageFragment;
    private List<User> userList;

    public StaffManageFragmentPresenter(StaffManageFragment staffManageFragment) {
        this.staffManageFragment = staffManageFragment;
        staffManageFragmentModel = new StaffManageFragmentModel();
    }

    @Override
    public void getStaffData() {
        userList = staffManageFragmentModel.getStaffData(staffManageFragment.getContext());
        staffManageFragment.getStaffData(userList);

    }

    @Override
    public void routeAddStaffActivity() {
        ARouter.getInstance().build(RouteMap.ROUTE_ADDSTAFF_ACTIVITY)
                .withInt("type",0)
                .navigation();
    }

    @Override
    public void routeEditStaffActivity(int position) {
        ARouter.getInstance().build(RouteMap.ROUTE_ADDSTAFF_ACTIVITY)
                .withInt("type",1)
                .withLong("id",userList.get(position).getId())
                .navigation();
    }
}
