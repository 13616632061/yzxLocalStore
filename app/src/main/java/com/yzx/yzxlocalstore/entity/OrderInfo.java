package com.yzx.yzxlocalstore.entity;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2019/9/17.
 */
@Entity
public class OrderInfo {

    private String orderId;
    @Convert(columnType = String.class, converter = GoodsInfoToConverte.class)
    private List<GoodsInfo> goodsInfos;
    private double goodTotalNum;
    private double totalMoney;
    private double freeMoney;
    private double orderWeight;
    private String orderCreatTime;
    private int orderStatus;
    private int orderPaySatus;
    @Convert(columnType = String.class, converter = UserToConverte.class)
    private User orderCreatPerson;
    private String orderCompleteTime;
    private int orderPayType;
    private double orderProfit;
    private boolean isSelect;
    private int orderType;
    @Generated(hash = 1811101871)
    public OrderInfo(String orderId, List<GoodsInfo> goodsInfos,
            double goodTotalNum, double totalMoney, double freeMoney,
            double orderWeight, String orderCreatTime, int orderStatus,
            int orderPaySatus, User orderCreatPerson, String orderCompleteTime,
            int orderPayType, double orderProfit, boolean isSelect, int orderType) {
        this.orderId = orderId;
        this.goodsInfos = goodsInfos;
        this.goodTotalNum = goodTotalNum;
        this.totalMoney = totalMoney;
        this.freeMoney = freeMoney;
        this.orderWeight = orderWeight;
        this.orderCreatTime = orderCreatTime;
        this.orderStatus = orderStatus;
        this.orderPaySatus = orderPaySatus;
        this.orderCreatPerson = orderCreatPerson;
        this.orderCompleteTime = orderCompleteTime;
        this.orderPayType = orderPayType;
        this.orderProfit = orderProfit;
        this.isSelect = isSelect;
        this.orderType = orderType;
    }
    @Generated(hash = 1695813404)
    public OrderInfo() {
    }
    public String getOrderId() {
        return this.orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public List<GoodsInfo> getGoodsInfos() {
        return this.goodsInfos;
    }
    public void setGoodsInfos(List<GoodsInfo> goodsInfos) {
        this.goodsInfos = goodsInfos;
    }

    public double getTotalMoney() {
        return this.totalMoney;
    }
    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
    public double getFreeMoney() {
        return this.freeMoney;
    }
    public void setFreeMoney(double freeMoney) {
        this.freeMoney = freeMoney;
    }
    public double getOrderWeight() {
        return this.orderWeight;
    }
    public void setOrderWeight(double orderWeight) {
        this.orderWeight = orderWeight;
    }
    public String getOrderCreatTime() {
        return this.orderCreatTime;
    }
    public void setOrderCreatTime(String orderCreatTime) {
        this.orderCreatTime = orderCreatTime;
    }
    public int getOrderStatus() {
        return this.orderStatus;
    }
    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
    public int getOrderPaySatus() {
        return this.orderPaySatus;
    }
    public void setOrderPaySatus(int orderPaySatus) {
        this.orderPaySatus = orderPaySatus;
    }
    public User getOrderCreatPerson() {
        return this.orderCreatPerson;
    }
    public void setOrderCreatPerson(User orderCreatPerson) {
        this.orderCreatPerson = orderCreatPerson;
    }
    public String getOrderCompleteTime() {
        return this.orderCompleteTime;
    }
    public void setOrderCompleteTime(String orderCompleteTime) {
        this.orderCompleteTime = orderCompleteTime;
    }
    public int getOrderPayType() {
        return this.orderPayType;
    }
    public void setOrderPayType(int orderPayType) {
        this.orderPayType = orderPayType;
    }
    public double getGoodTotalNum() {
        return this.goodTotalNum;
    }
    public void setGoodTotalNum(double goodTotalNum) {
        this.goodTotalNum = goodTotalNum;
    }
    public double getOrderProfit() {
        return this.orderProfit;
    }
    public void setOrderProfit(double orderProfit) {
        this.orderProfit = orderProfit;
    }
    public boolean getIsSelect() {
        return this.isSelect;
    }
    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }
    public int getOrderType() {
        return this.orderType;
    }
    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }


}
