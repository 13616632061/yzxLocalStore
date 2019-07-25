package com.yzx.yzxlocalstore.ui.PopWindow.MainMenuPopWindow.presenter;

import com.cheng.channel.Channel;
import com.yzx.yzxlocalstore.entity.TypeBean;

import java.util.List;

/**
 * Created by Administrator on 2019/7/25.
 */

public interface IMainMenuPopWindowPresenterImp {

    //获取常用管理分类信息
    List<Channel> getCommonlyType();

    //获取更多管理分类信息
    List<Channel> getMoreType();


    //正常状态点击事件
    void typeItemClick(int position, Channel channel);

    //编辑完成
    void typeEditFinish(List<Channel> channelList);
}
