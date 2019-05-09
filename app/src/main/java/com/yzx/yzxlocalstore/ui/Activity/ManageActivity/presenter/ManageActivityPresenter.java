package com.yzx.yzxlocalstore.ui.Activity.ManageActivity.presenter;

import android.view.Gravity;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.Utils;
import com.chaychan.library.BottomBarItem;
import com.yzx.lib.base.BaseFragment;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.ManageType;
import com.yzx.yzxlocalstore.ui.Activity.ManageActivity.model.ManageActivityModel;
import com.yzx.yzxlocalstore.ui.Activity.ManageActivity.view.ManageActivity;

import java.util.List;

/**
 * Created by lyf on 2019/5/7.
 */

public class ManageActivityPresenter implements IManageActivityPresenter {

    private ManageActivityModel mManageActivityModel;
    private ManageActivity mManageActivity;

    public ManageActivityPresenter(ManageActivity mManageActivity) {
        this.mManageActivity = mManageActivity;
        mManageActivityModel = new ManageActivityModel();
    }

    @Override
    public void initManageType() {
        List<ManageType> manageTypeList = mManageActivityModel.initManageType();
        List<BaseFragment> fragmentList = mManageActivityModel.initManageFragment();

        mManageActivity.initManageType(manageTypeList, fragmentList);
    }

    @Override
    public BottomBarItem createTopBarItem(ManageType manageType) {
        BottomBarItem item = new BottomBarItem.Builder(mManageActivity)
                .titleTextSize(8)
                .titleNormalColor(R.color.color_707070)
                .titleSelectedColor(R.color.color_f5260b)
                //还有很多属性，详情请查看Builder里面的方法
                .create(manageType.getUnSelectIcon(), manageType.getSelectIcon(), manageType.getName());
        item.setGravity(Gravity.CENTER_VERTICAL);
        item.setPadding(15,0,15,0);

        return item;
    }

}
