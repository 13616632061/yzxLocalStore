package com.yzx.yzxlocalstore.ui.Fragment.StaffManageFragment.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yzx.lib.base.BaseFragment;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.ui.Adapter.StaffManageFragmentAdapter;
import com.yzx.yzxlocalstore.ui.Fragment.StaffManageFragment.presenter.StaffManageFragmentPresenter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by lyf on 2019/5/9.
 * 员工管理
 */

public class StaffManageFragment extends BaseFragment implements IStaffManageFragmentView {


    @InjectView(R.id.et_search)
    EditText etSearch;
    @InjectView(R.id.tv_all_roles)
    TextView tvAllRoles;
    @InjectView(R.id.tv_state)
    TextView tvState;
    @InjectView(R.id.list)
    RecyclerView list;
    @InjectView(R.id.btn_role_manage)
    Button btnRoleManage;
    @InjectView(R.id.btn_add_staff)
    Button btnAddStaff;
    private StaffManageFragmentPresenter staffManageFragmentPresenter;
    private StaffManageFragmentAdapter adapter;

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_staff_manage;
    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        staffManageFragmentPresenter = new StaffManageFragmentPresenter(this);
        staffManageFragmentPresenter.getStaffData();
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void getStaffData(List<User> userList) {
        adapter = new StaffManageFragmentAdapter(R.layout.item_staff_manage_fragment, userList);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(mActivity));

    }

    /**
     * 新增员工
     */
    @Override
    public void routeAddStaffActivity() {
        ARouter.getInstance().build(RouteMap.ROUTE_ADDSTAFF_ACTIVITY).navigation();
    }

    @OnClick({R.id.btn_add_staff})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_staff://新增员工
                staffManageFragmentPresenter.routeAddStaffActivity();
                break;
        }
    }

}
