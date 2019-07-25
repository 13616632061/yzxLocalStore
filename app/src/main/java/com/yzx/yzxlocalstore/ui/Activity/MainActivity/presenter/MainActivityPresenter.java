package com.yzx.yzxlocalstore.ui.Activity.MainActivity.presenter;

import com.blankj.utilcode.util.FileIOUtils;
import com.cheng.channel.Channel;
import com.google.gson.Gson;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.ManageChannelType;
import com.yzx.yzxlocalstore.entity.ManageType;
import com.yzx.yzxlocalstore.entity.TypeBean;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.model.MainActivityModel;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.view.MainActivity;
import com.yzx.yzxlocalstore.utils.LoginUserUtil;

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
        if (mModel.isInitTypeChannel()) {
            return;
        }
        String[] typNameList = new String[]{
                mView.getResources().getString(R.string.putOrder),
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
        List<TypeBean> typeBeanList = new ArrayList<>();
        for (String typeName : typNameList) {
            TypeBean typeBean = new TypeBean();
            typeBean.setId(LoginUserUtil.getInstance().getLoginUser().getId());
            typeBean.setName(typeName);
            if (typeName.equals(R.string.putOrder)){
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

}
