package com.yzx.yzxlocalstore.ui.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.User;

import java.util.List;

/**
 * Created by lyf on 2019/5/14.
 */

public class StaffManageFragmentAdapter extends BaseQuickAdapter<User, BaseViewHolder> {


    public StaffManageFragmentAdapter(int layoutResId, @Nullable List<User> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, User item) {
        helper.setText(R.id.tv_serial_number, item.getId() + "")
                .setText(R.id.tv_number, item.getNumber())
                .setText(R.id.tv_name, item.getName())
                .setText(R.id.tv_phone, item.getPhone())
                .setText(R.id.tv_role, item.getRoles())
                .setText(R.id.tv_sales_commission, item.getSalesCommission()+"%")
                .setText(R.id.tv_state, item.getStatusName());

        helper.addOnClickListener(R.id.btn_edit);
    }
}
