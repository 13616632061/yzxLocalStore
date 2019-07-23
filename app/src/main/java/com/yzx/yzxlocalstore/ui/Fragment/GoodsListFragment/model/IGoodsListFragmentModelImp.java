package com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.model;

import com.yzx.yzxlocalstore.entity.GoodsInfo;

import java.util.List;

/**
 * Created by Administrator on 2019/7/9.
 */

public interface IGoodsListFragmentModelImp {


    /**
     * 查询商品
     *
     * @param page 页数
     * @param type 商品类型 0全部商品，1缺货商品,2库存预警
     * @return
     */
    List<GoodsInfo> getGoodsInfo(int page, int type);

    //所有商品数量
    long getAllGoodsNum(int type);

    //缺货商品数量
    String getLackGoodsInfom();

    //库存预警
    String getWarningGoodsNum();

    //删除商品
    void deteleGoodsInfo(List<GoodsInfo> goodsInfoList);

    //编辑商品
    void editGoodsInfo(List<GoodsInfo> goodsInfoList);

    //添加商品
    void addGoodsInfo(GoodsInfo goodsInfo);

    //搜索
    List<GoodsInfo> qureyGoodsInfo(String content);
}
