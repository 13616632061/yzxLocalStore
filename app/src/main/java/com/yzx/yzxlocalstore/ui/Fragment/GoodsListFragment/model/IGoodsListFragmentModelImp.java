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
     */
    List<GoodsInfo> getGoodsInfo(int page);
}
