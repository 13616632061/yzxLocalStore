package com.yzx.yzxlocalstore.ui.PopWindow.MainMenuPopWindow.presenter;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.apkfuns.logutils.LogUtils;
import com.chad.library.adapter.base.util.TouchEventUtil;
import com.cheng.channel.Channel;
import com.yzx.lib.util.EventBusMapUtil;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.TypeBean;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.MainToAction.MainToAction;
import com.yzx.yzxlocalstore.ui.PopWindow.MainMenuPopWindow.model.MainMenuPopWindowModel;
import com.yzx.yzxlocalstore.ui.PopWindow.MainMenuPopWindow.view.MainMenuPopWindow;
import com.yzx.yzxlocalstore.utils.LoginUserUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/7/25.
 */

public class MainMenuPopWindowPresenter implements IMainMenuPopWindowPresenterImp {

    private MainMenuPopWindow mView;
    private MainMenuPopWindowModel mModel;
    private Context mContext;

    public MainMenuPopWindowPresenter(Context mContext, MainMenuPopWindow mView) {
        this.mView = mView;
        this.mContext = mContext;
        mModel = new MainMenuPopWindowModel();
    }

    /**
     * 获取常用管理分类信息
     *
     * @return
     */
    @Override
    public List<Channel> getCommonlyType() {
        List<Channel> mChannelTypeList = new ArrayList<>();
        List<TypeBean> typeList = mModel.getTypeInfo();
        LogUtils.e("TypeBean: " + typeList);
        for (TypeBean typeBean : typeList) {
            if (typeBean.getTypeCode() == 1) {
                Channel channel = new Channel(typeBean.getName(), typeBean.getTypeCode(), null);
                mChannelTypeList.add(channel);
            }
        }
        return mChannelTypeList;
    }

    /**
     * 获取更多管理分类信息
     *
     * @return
     */
    @Override
    public List<Channel> getMoreType() {
        List<Channel> mChannelTypeList = new ArrayList<>();
        List<TypeBean> typeList = mModel.getTypeInfo();
        for (TypeBean typeBean : typeList) {
            if (typeBean.getTypeCode() != 1) {
                Channel channel = new Channel(typeBean.getName(), typeBean.getTypeCode(), null);
                mChannelTypeList.add(channel);
            }
        }
        return mChannelTypeList;
    }


    /**
     * 正常状态点击事件
     *
     * @param position
     * @param channel
     */
    @Override
    public void typeItemClick(int position, Channel channel) {
        MainToAction.toAction(mContext, channel.getChannelName());
    }

    /**
     * 编辑完成
     *
     * @param channelList
     */
    @Override
    public void typeEditFinish(List<Channel> channelList) {
        //编辑后的新集合
        List<TypeBean> newTypeList = new ArrayList<>();
        //设置常用分类
        for (Channel channel : channelList) {
            TypeBean typeBean = new TypeBean();
            typeBean.setTypeCode(1);
            typeBean.setName(channel.getChannelName());
            typeBean.setId(LoginUserUtil.getInstance().getLoginUser().getId());
            newTypeList.add(typeBean);
        }
        //更多分类
        for (Channel channel : mView.getOtherChannel()) {
            TypeBean typeBean = new TypeBean();
            typeBean.setTypeCode(0);
            typeBean.setName(channel.getChannelName());
            typeBean.setId(LoginUserUtil.getInstance().getLoginUser().getId());
            newTypeList.add(typeBean);
        }
        //清除久数据，保存新数据
        mModel.clearAllTypeInfo();
        for (int i = 0; i < newTypeList.size(); i++) {
            mModel.addTypeInfo(newTypeList.get(i));
        }
        EventBus.getDefault().post(EventBusMapUtil.getObjectMap("updateManageType", null));
    }


}
