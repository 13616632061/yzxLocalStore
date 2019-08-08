package com.yzx.yzxlocalstore.ui.Activity.MainActivity.presenter;

import com.cheng.channel.Channel;
import com.yzx.yzxlocalstore.entity.SaleGoodsInfo;
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

    /**
     * 初始化左边销售商品信息Adapter
     */
    void setLeftSaleGoodsListView();

    //销售商品信息数据
    List<SaleGoodsInfo> saleGoodsInfoData();

    //设置选中的销售商品信息item
    void setSelectSaleGoodsInfoItem(int position);

    //添加销售商品
    void addSaleGoodsInfo();

    //删除选中的item
    void removeSelectSaleGoodsInfoItem();

    //销售商品的总重量
    void setTotalWeight();

    //销售商品的总数量
    void setTotalGoodNum();

    //销售商品的总价格
    void setTotalPrice();

    //应收金额
    void setReceivableMoney();
}
