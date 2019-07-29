package com.yzx.yzxlocalstore.ui.Activity.MainActivity.model;

import android.content.Context;

import com.yzx.yzxlocalstore.entity.TypeBean;

import java.util.List;

/**
 * Created by Administrator on 2019/7/1.
 */

public interface IMainActivityModelImp {
    //登录用户是否已经初始管理栏目
    boolean isInitTypeChannel(int curTypeCount);

    //初始化管理栏目
    void initTypeChannel(TypeBean typeBean);

    //获取底部管理分类
    List<TypeBean> getBottomType();


}
