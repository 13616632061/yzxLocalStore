package com.yzx.yzxlocalstore.ui.Activity.MainActivity.presenter;

import com.blankj.utilcode.util.FileIOUtils;
import com.cheng.channel.Channel;
import com.google.gson.Gson;
import com.yzx.yzxlocalstore.entity.ManageChannelType;
import com.yzx.yzxlocalstore.entity.ManageType;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.model.MainActivityModel;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.view.MainActivity;

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

    //显示更多分类信息
    @Override
    public void showMoreTypeChannel() {
        mView.showMoreTypeChannel();
    }

    //获取管理分类信息
    @Override
    public List<Channel> getTypeChannel() {
        List<Channel> mChannelTypeList = new ArrayList<>();

        ManageChannelType manageType = new Gson().fromJson(mModel.getTypeChannel(mView), ManageChannelType.class);
        if (manageType != null) {
            for (int i = 0; i < manageType.getType().size(); i++) {
                Channel channel = new Channel(manageType.getType().get(i).getName(), 1, manageType.getType().get(i));
                mChannelTypeList.add(channel);
            }
        }
        return mChannelTypeList;
    }
}
