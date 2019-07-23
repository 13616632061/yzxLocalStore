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

    //所有商品数量
    void setAllGoodsNum(String allGoodsNum);

    //是否选中所有商品类型
    void isSelectAllGoodsType(boolean isSelectAllGoods);

    //缺货商品数量
    void setLackGoodsInfom(String lackGoodsNum);

    //是否选中缺货商品类型
    void isSelectLackGoodsType(boolean iisSelectLackGoods);

    //库存预警
    void setWarningGoodsNum(String warningGoodsNum);

    //是否选中库存预警商品类型
    void isSelectWarningGoodsType(boolean isSelectWarningGoods);

    //编辑商品
    void goToEditGoodsInfo(GoodsInfo goodInfo);

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

    //每页最多显示多少条
    void setMaxShowPage(String num);

    //当前页的记录
    void setCurRecord(long totalNum, long page, long firstNum, long lastNum);

    //商品导入
    void importGoodsInfo();

    //商品导出
    void exportGoodsInfo();

    //标签打印
    void printLabel();


    //获取搜索文本
    String getEtSearchContent();

    //显示提示信息
    void showErrorMsg(int type);


}
