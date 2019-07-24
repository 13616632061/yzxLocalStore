package com.yzx.yzxlocalstore.ui.Activity.MainActivity.presenter;

import com.cheng.channel.Channel;
import com.yzx.yzxlocalstore.entity.TypeBean;

import java.util.List;

/**
 * Created by Administrator on 2019/6/28.
 */

public interface IMainActivityPresenterImp {

    //初始化管理栏目
    void initTypeChannel();

    //显示更多分类信息
    void showMoreTypeChannel();

    //获取管理分类信息
    List<Channel> getTypeChannel();
}
