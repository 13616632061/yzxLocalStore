package com.yzx.yzxlocalstore.ui.PopWindow.MainMenuPopWindow.presenter;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.apkfuns.logutils.LogUtils;
import com.cheng.channel.Channel;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.TypeBean;
import com.yzx.yzxlocalstore.ui.PopWindow.MainMenuPopWindow.model.MainMenuPopWindowModel;
import com.yzx.yzxlocalstore.ui.PopWindow.MainMenuPopWindow.view.MainMenuPopWindow;

import java.util.ArrayList;
import java.util.List;

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
        LogUtils.e("TypeBean: " + typeList);
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
        if (channel.getChannelName().equals(mContext.getResources().getString(R.string.goodsManage))) {//商品管理
            ARouter.getInstance().build(RouteMap.ROUTE_GOODS_MANAGE_ACTIVITY).navigation();
        }
    }

    /**
     * 编辑完成
     *
     * @param channelList
     */
    @Override
    public void typeEditFinish(List<Channel> channelList) {
        List<TypeBean> typeBeanList = mModel.getTypeInfo();
        //将所有的分类设为非常用
        for (int i = 0; i < typeBeanList.size(); i++) {
            typeBeanList.get(i).setTypeCode(0);
        }
        //设置常用分类
        for (Channel channel : channelList) {
            for (int i = 0; i < typeBeanList.size(); i++) {
                if (typeBeanList.get(i).getName().equals(channel.getChannelName())) {
                    typeBeanList.get(i).setTypeCode(1);
                }
            }
        }
        //更新数据库
        for (int i = 0; i < typeBeanList.size(); i++) {
            mModel.updateTypeInfo(typeBeanList.get(i));
        }
    }


}
