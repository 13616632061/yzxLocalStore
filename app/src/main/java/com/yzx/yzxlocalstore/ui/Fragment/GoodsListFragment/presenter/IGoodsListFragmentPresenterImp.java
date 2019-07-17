package com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.presenter;

import com.yzx.yzxlocalstore.entity.GoodsInfo;

import java.util.List;

/**
 * Created by Administrator on 2019/7/9.
 */

public interface IGoodsListFragmentPresenterImp {

    void initAdapter();

    //查询商品
    void getGoodsInfo(int page, int type);

    //商品选中状态 type:0全选，1单个选中
    void editGoodsInfoSelectStatus(int type, int position);

    //是否全部选中
    boolean isAllSelect();

    //所有商品数量
    void setAllGoodsNum();

    //缺货商品数量
    void setLackGoodsInfom();

    //库存预警
    void setWarningGoodsNum();

    //是否选中所有商品类型
    void isSelectAllGoodsType(boolean isSelectAllGoods);

    //是否选中缺货商品类型
    void isSelectLackGoodsType(boolean iisSelectLackGoods);

    //是否选中库存预警商品类型
    void isSelectWarningGoodsType(boolean isSelectWarningGoods);

    //缺货商品
    void lackGoodsInfo();

    //库存预警商品
    void warningGoodsInfo();

    //添加商品
    void addGoodsInfo();

    //删除商品
    void deteleGoodsInfo();

    //显示操作提示框
    void showHandleGoodsInfoTipMsg(int type);

    //获取选中商品信息
    List<GoodsInfo> getSelectGoodsInfo();

    //是否存在选中商品
    boolean isExistSelectGoodsInfo();

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

    //编辑商品
    void goToEditGoodsInfo(GoodsInfo goodInfo);

}
