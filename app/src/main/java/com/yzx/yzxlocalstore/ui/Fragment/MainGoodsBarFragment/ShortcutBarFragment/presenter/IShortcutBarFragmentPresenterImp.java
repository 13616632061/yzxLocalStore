package com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.ShortcutBarFragment.presenter;

import com.yzx.yzxlocalstore.entity.GoodsInfo;

import java.util.List;

/**
 * Created by Administrator on 2019/10/9.
 */

public interface IShortcutBarFragmentPresenterImp {

    //初始化快捷商品适配器
    void initShortcutBarFragmentAdapter();

    //快捷商品数据
    List<GoodsInfo> getData();

    //获取快捷商品数据
    void getShortcutBarData();

    //获取快捷栏的宽度
    int getLayoutWidth();
}
