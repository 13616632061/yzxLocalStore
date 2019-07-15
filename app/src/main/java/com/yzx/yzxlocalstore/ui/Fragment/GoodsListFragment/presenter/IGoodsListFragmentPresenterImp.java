package com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.presenter;

/**
 * Created by Administrator on 2019/7/9.
 */

public interface IGoodsListFragmentPresenterImp {

    void initAdapter();

    //查询商品
    void getGoodsInfo(int page);

    //商品选中状态 type:0全选，1单个选中
    void editGoodsInfoSelectStatus(int type, int position);

    //是否全部选中
    boolean isAllSelect();

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
