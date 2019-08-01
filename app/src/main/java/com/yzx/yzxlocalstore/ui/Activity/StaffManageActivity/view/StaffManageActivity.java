package com.yzx.yzxlocalstore.ui.Activity.StaffManageActivity.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yzx.lib.base.BaseActivity;
import com.yzx.lib.entity.MessageEvent;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.ui.Adapter.StaffManageFragmentAdapter;
import com.yzx.yzxlocalstore.ui.Activity.StaffManageActivity.presenter.StaffManagePresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

@Route(path = RouteMap.ROUTE_STAFF_MANAGE_ACTIVITY)
public class StaffManageActivity extends BaseActivity implements IStaffManageActivityView {

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
    private StaffManagePresenter mPresenter;
    private StaffManageFragmentAdapter adapter;
    private List<User> mUserList = new ArrayList<>();

    @Override
    public int getContentView() {
        return R.layout.activity_staff_manage;
    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);
        inintTitle(getResources().getString(R.string.staffManage));
        mPresenter = new StaffManagePresenter(this);
        mPresenter.getStaffData();
    }

    @Override
    public void getStaffData(List<User> userList) {
        mUserList.clear();
        mUserList.addAll(userList);
        if (adapter == null) {
            adapter = new StaffManageFragmentAdapter(this,R.layout.item_staff_manage_fragment, mUserList);
            list.setAdapter(adapter);
            list.setLayoutManager(new LinearLayoutManager(this));
        } else {
            adapter.notifyDataSetChanged();
        }
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.btn_edit:
                        mPresenter.routeEditStaffActivity(mUserList.get(position).getId());
                        break;
                }
            }
        });
    }


    @OnClick({R.id.btn_add_staff})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_staff://新增员工
                mPresenter.routeAddStaffActivity();
                break;
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(MessageEvent msg) {
        if (msg.getKey().equals("addStaffSuccess")) {
            mPresenter.getStaffData();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
