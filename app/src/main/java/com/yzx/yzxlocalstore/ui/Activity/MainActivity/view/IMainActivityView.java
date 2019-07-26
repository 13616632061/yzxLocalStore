package com.yzx.yzxlocalstore.ui.Activity.MainActivity.view;

import com.yzx.yzxlocalstore.entity.TypeBean;
import com.yzx.yzxlocalstore.ui.Adapter.MainBottomTypeAdapter;

import java.util.List;

/**
 * Created by Administrator on 2019/6/28.
 */

public interface IMainActivityView {

    //显示更多分类信息
    void showMoreTypeChannel();

    //设置底部功能分类视图
    void setBottomTypeView();

    //底部功能管理分类适配器
    MainBottomTypeAdapter mainBottomTypeAdapter();

    //底部功能管理分类数据
    List<TypeBean> mBottomTypeData();
}