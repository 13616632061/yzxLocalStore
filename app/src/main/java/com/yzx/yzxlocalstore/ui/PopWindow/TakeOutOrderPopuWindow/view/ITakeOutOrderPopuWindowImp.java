package com.yzx.yzxlocalstore.ui.PopWindow.TakeOutOrderPopuWindow.view;

import com.yzx.yzxlocalstore.ui.Adapter.TakeOutOrderPopuWindowAdapter;

/**
 * Created by Administrator on 2019/10/10.
 */

public interface ITakeOutOrderPopuWindowImp {

    //初始化视图
    void initView();

    //初始化数据列表
    TakeOutOrderPopuWindowAdapter initTakeOutOrderPopuWindowAdapter();

    //退出
    void exit();
}
