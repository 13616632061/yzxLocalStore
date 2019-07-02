package com.yzx.yzxlocalstore.ui.Activity.MainActivity.presenter;

import com.cheng.channel.Channel;

import java.util.List;

/**
 * Created by Administrator on 2019/6/28.
 */

public interface IMainActivityPresenterImp {

    //显示更多分类信息
    void showMoreTypeChannel();

    //获取管理分类信息
    List<Channel> getTypeChannel();
}
