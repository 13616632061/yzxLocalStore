package com.yzx.yzxlocalstore.ui.Activity.MainActivity.presenter;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.LogUtils;
import com.cheng.channel.Channel;
import com.google.gson.Gson;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.ManageChannelType;
import com.yzx.yzxlocalstore.entity.ManageType;
import com.yzx.yzxlocalstore.entity.TypeBean;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.MainToAction.MainToAction;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.model.MainActivityModel;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.view.MainActivity;
import com.yzx.yzxlocalstore.utils.LoginUserUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/6/28.
 */

public class MainActivityPresenter implements IMainActivityPresenterImp {

    private MainActivity mView;
    private MainActivityModel mModel;

    public MainActivityPresenter(MainActivity mView) {
        this.mView = mView;
        mModel = new MainActivityModel();
    }

    /**
     * 初始化管理栏目
     */
    @Override
    public void initTypeChannel() {
        String[] typNameList = new String[]{
                mView.getResources().getString(R.string.moreType),
                mView.getResources().getString(R.string.putOrder),
                mView.getResources().getString(R.string.loginOut),
                mView.getResources().getString(R.string.changeShifts),
                mView.getResources().getString(R.string.cashBox),
                mView.getResources().getString(R.string.lockScreen),
                mView.getResources().getString(R.string.print),
                mView.getResources().getString(R.string.getOrder),
                mView.getResources().getString(R.string.rejectedGood),
                mView.getResources().getString(R.string.cashPrize),
                mView.getResources().getString(R.string.changeMoney),
                mView.getResources().getString(R.string.onCredit),
                mView.getResources().getString(R.string.retail),
                mView.getResources().getString(R.string.takeOutFood),
                mView.getResources().getString(R.string.detele),
                mView.getResources().getString(R.string.goodsManage),
                mView.getResources().getString(R.string.staffManage),
                mView.getResources().getString(R.string.orderManage),
                mView.getResources().getString(R.string.reportForm),
                mView.getResources().getString(R.string.inventory),
                mView.getResources().getString(R.string.vip),
                mView.getResources().getString(R.string.set)
        };
        if (mModel.isInitTypeChannel(typNameList.length)) {
            return;
        }
        List<TypeBean> typeBeanList = new ArrayList<>();
        for (String typeName : typNameList) {
            TypeBean typeBean = new TypeBean();
            typeBean.setId(LoginUserUtil.getInstance().getLoginUser().getId());
            typeBean.setName(typeName);
            if (typeName.equals(mView.getResources().getString(R.string.moreType))) {
                typeBean.setTypeCode(1);
            }
            typeBeanList.add(typeBean);
        }
        for (TypeBean bean : typeBeanList) {
            mModel.initTypeChannel(bean);
        }
    }

    //显示更多分类信息
    @Override
    public void showMoreTypeChannel() {
        mView.showMoreTypeChannel();
    }

    /**
     * 获取底部管理分类
     */
    @Override
    public void getBottomType() {
        mView.mBottomTypeData().clear();
        mView.mBottomTypeData().addAll(mModel.getBottomType());
        mView.mainBottomTypeAdapter().notifyDataSetChanged();
    }

    /**
     * 设置底部管理分类的视图
     */
    @Override
    public void setBottomTypeView() {
        mView.setBottomTypeView();
    }

    /**
     * 底部管理分类点击事件
     *
     * @param name
     */
    @Override
    public void setBottomTypeOnClick(String name) {
        if (mView.getResources().getString(R.string.moreType).equals(name)) {//更多
            mView.showMoreTypeChannel();
        } else {
            MainToAction.toAction(mView, name);
        }
    }

}
