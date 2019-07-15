package com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.view;

import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.ui.Adapter.GoodsListFragmentAdapter;

import java.util.List;

/**
 * Created by Administrator on 2019/7/9.
 */

public interface IGoodsListFragmentView {
    //商品列表适配器
    void initAdapter();

    GoodsListFragmentAdapter getAdapter();

    //商品数据
    List<GoodsInfo> getData();

    //商品全选状态显示
    void showAllSelectStatus();

    //是否全部选中
    void setAllSelect(boolean isAllSelect);

    boolean isAllSelect();

    //全部商品
    void allGoodsInfo();

    //缺货商品
    void lackGoodsInfo();

    //库存预警商品
    void warningGoodsInfo();

    //添加商品
    void addGoodsInfo();

    //删除商品
    void deteleGoodsInfo();

    //商品上架
    void upShelfGoodsInfo();

    //商品下架
    void dowmShelfGoodsInfo();

    //商品导入
    void importGoodsInfo();

    //商品导出
    void exportGoodsInfo();

    //标签打印
    void printLabel();

    //首页
    void firstPage();

    //尾页
    void lastPage();

    //上一页
    void previousPage();

    //下一页
    void nextPage();


}
