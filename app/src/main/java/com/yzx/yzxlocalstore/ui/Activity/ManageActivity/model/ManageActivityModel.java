package com.yzx.yzxlocalstore.ui.Activity.ManageActivity.model;

import android.graphics.drawable.Drawable;

import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.ManageType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/7.
 */

public class ManageActivityModel implements IManageActivityModel {


    @Override
    public List<ManageType> initManageType() {
        String[] typeStr = new String[]{"报表", "商品", "出入库", "盘点", "员工", "会员", "设置", "关于"};
        int[] selectIcon = new int[]{R.drawable.form_red, R.drawable.good_red, R.drawable.outgo_red, R.drawable.inventory_red, R.drawable.staff_red,
                R.drawable.member_red, R.drawable.staff_red};
        int[] unSelectIcon = new int[]{R.drawable.form_gray, R.drawable.good_gray, R.drawable.outgo_gray, R.drawable.inventory_gray, R.drawable.staff_gray,
                R.drawable.member_gray, R.drawable.staff_gray};
        List<ManageType> manageTypeList = new ArrayList<>();
        for (int i = 0; i < typeStr.length; i++) {
            ManageType manageType = new ManageType();
            manageType.setName(typeStr[i]);
            manageType.setSelectIcon(selectIcon[i]);
            manageType.setUnSelectIcon(unSelectIcon[i]);
            manageType.setShow(true);
            manageTypeList.add(manageType);
        }
        return manageTypeList;
    }
}
