package com.yzx.yzxlocalstore.entity;

/**
 * Created by Administrator on 2019/8/8.
 */

public class SaleGoodsInfo {

    private GoodsInfo goodsInfo;//商品信息
    private double num;//数量
    private double subtotalPrice;//小计
    private boolean isSelectItem;//是否选中

    public GoodsInfo getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public double getSubtotalPrice() {
        return subtotalPrice;
    }

    public void setSubtotalPrice(double subtotalPrice) {
        this.subtotalPrice = subtotalPrice;
    }

    public boolean isSelectItem() {
        return isSelectItem;
    }

    public void setSelectItem(boolean selectItem) {
        isSelectItem = selectItem;
    }

    @Override
    public String toString() {
        return "SaleGoodsInfo{" +
                "goodsInfo=" + goodsInfo +
                ", num=" + num +
                ", subtotalPrice=" + subtotalPrice +
                ", isSelectItem=" + isSelectItem +
                '}';
    }
}
