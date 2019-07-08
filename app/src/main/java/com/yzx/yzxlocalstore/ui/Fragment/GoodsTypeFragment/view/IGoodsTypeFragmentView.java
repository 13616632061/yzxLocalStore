package com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.view;

import com.yzx.yzxlocalstore.entity.GoodsType;
import com.yzx.yzxlocalstore.ui.Adapter.GoodsTypeFragmentAdapter;

import java.util.List;

/**
 * Created by Administrator on 2019/7/2.
 */

public interface IGoodsTypeFragmentView {
    //初始化适配器
    void initAdapter();

    //获取适配器
    GoodsTypeFragmentAdapter getAdapter();

    //分类数据
    List<GoodsType> getGoodsTypeDatas();

    //商品分类数量
    void setGoodsTypeNum(int num);

    //新增分类
    void addGoodsType();

    //删除分类
    void deleteGoodsType();

    //编辑分类
    void editGoodsType(GoodsType goodsType);

    //是否全选
    void setAllSelect(boolean isAllSelect);

    boolean isAllSelect();

    //全选
    void allSelect();

    //操作提示信息
    void showToastMsg(int type);
}
