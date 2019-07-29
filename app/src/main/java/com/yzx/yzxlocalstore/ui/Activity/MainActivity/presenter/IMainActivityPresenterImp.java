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

    //获取底部管理分类
    void getBottomType();

    void setBottomTypeView();

    //底部管理分类点击事件
    void setBottomTypeOnClick(String name);
}
