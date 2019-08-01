package com.yzx.yzxlocalstore.ui.Activity.ManageActivity.model;

import android.support.v4.app.Fragment;

import com.yzx.lib.base.BaseFragment;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.Constants;
import com.yzx.yzxlocalstore.entity.ManageType;
import com.yzx.yzxlocalstore.ui.Fragment.AboutFragment;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsManageFragment;
import com.yzx.yzxlocalstore.ui.Fragment.InventoryFragment;
import com.yzx.yzxlocalstore.ui.Fragment.MemberFragment;
import com.yzx.yzxlocalstore.ui.Fragment.OutGoStoreFragment;
import com.yzx.yzxlocalstore.ui.Fragment.ReportFormFragment;
import com.yzx.yzxlocalstore.ui.Fragment.SetFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/7.
 */

public class ManageActivityModel implements IManageActivityModel {


    @Override
    public List<ManageType> initManageType() {
        int[] selectIcon = new int[]{R.drawable.form_red, R.drawable.good_red, R.drawable.outgo_red, R.drawable.inventory_red, R.drawable.staff_red,
                R.drawable.member_red, R.drawable.set_red, R.drawable.msg_red};
        int[] unSelectIcon = new int[]{R.drawable.form_gray, R.drawable.good_gray, R.drawable.outgo_gray, R.drawable.inventory_gray, R.drawable.staff_gray,
                R.drawable.member_gray, R.drawable.set_gray, R.drawable.msg_gray};
        List<ManageType> manageTypeList = new ArrayList<>();
        for (int i = 0; i < Constants.MANAGE_TYPE.length; i++) {
            ManageType manageType = new ManageType();
            manageType.setName(Constants.MANAGE_TYPE[i]);
            manageType.setSelectIcon(selectIcon[i]);
            manageType.setUnSelectIcon(unSelectIcon[i]);
            manageType.setShow(true);
            manageTypeList.add(manageType);
        }
        return manageTypeList;
    }

    @Override
    public List<Fragment> initManageFragment() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new ReportFormFragment());
        fragmentList.add(new GoodsManageFragment());
        fragmentList.add(new OutGoStoreFragment());
        fragmentList.add(new InventoryFragment());
        fragmentList.add(new MemberFragment());
        fragmentList.add(new SetFragment());
        fragmentList.add(new AboutFragment());
        return fragmentList;
    }
}
