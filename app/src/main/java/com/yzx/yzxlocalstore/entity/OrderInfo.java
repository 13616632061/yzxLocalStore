package com.yzx.yzxlocalstore.entity;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
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

    @Id(autoincrement = true)
    private Long id;
    private String orderId;
    @Convert(columnType = String.class, converter = GoodsInfoToConverte.class)
    private List<GoodsInfo> goodsInfos;
    private Double goodTotalNum=0.00;
    private Double totalMoney=0.00;
    private Double freeMoney=0.00;
    private Double orderWeight=0.00;
    private Long orderCreatTime;
    private Integer orderStatus=0;//未完成：0，已完成：1
    private Integer orderPaySatus=0;//未支付：0，已支付：1
    @Convert(columnType = String.class, converter = UserToConverte.class)
    private User orderCreatPerson;
    private String orderCompleteTime;
    private Integer orderPayType=0;//未支付：0，现金支付：1，移动支付：2，会员支付：3
    private Double orderProfit=0.00;
    private Boolean isSelect=false;
    private Integer orderType=-1;


    @Generated(hash = 1048793375)
    public OrderInfo(Long id, String orderId, List<GoodsInfo> goodsInfos,
            Double goodTotalNum, Double totalMoney, Double freeMoney,
            Double orderWeight, Long orderCreatTime, Integer orderStatus,
            Integer orderPaySatus, User orderCreatPerson, String orderCompleteTime,
            Integer orderPayType, Double orderProfit, Boolean isSelect,
            Integer orderType) {
        this.id = id;
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


    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", goodsInfos=" + goodsInfos +
                ", goodTotalNum=" + goodTotalNum +
                ", totalMoney=" + totalMoney +
                ", freeMoney=" + freeMoney +
                ", orderWeight=" + orderWeight +
                ", orderCreatTime=" + orderCreatTime +
                ", orderStatus=" + orderStatus +
                ", orderPaySatus=" + orderPaySatus +
                ", orderCreatPerson=" + orderCreatPerson +
                ", orderCompleteTime='" + orderCompleteTime + '\'' +
                ", orderPayType=" + orderPayType +
                ", orderProfit=" + orderProfit +
                ", isSelect=" + isSelect +
                ", orderType=" + orderType +
                '}';
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
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


    public Double getGoodTotalNum() {
        return this.goodTotalNum;
    }


    public void setGoodTotalNum(Double goodTotalNum) {
        this.goodTotalNum = goodTotalNum;
    }


    public Double getTotalMoney() {
        return this.totalMoney;
    }


    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }


    public Double getFreeMoney() {
        return this.freeMoney;
    }


    public void setFreeMoney(Double freeMoney) {
        this.freeMoney = freeMoney;
    }


    public Double getOrderWeight() {
        return this.orderWeight;
    }


    public void setOrderWeight(Double orderWeight) {
        this.orderWeight = orderWeight;
    }


    public Long getOrderCreatTime() {
        return this.orderCreatTime;
    }


    public void setOrderCreatTime(Long orderCreatTime) {
        this.orderCreatTime = orderCreatTime;
    }


    public Integer getOrderStatus() {
        return this.orderStatus;
    }


    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }


    public Integer getOrderPaySatus() {
        return this.orderPaySatus;
    }


    public void setOrderPaySatus(Integer orderPaySatus) {
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


    public Integer getOrderPayType() {
        return this.orderPayType;
    }


    public void setOrderPayType(Integer orderPayType) {
        this.orderPayType = orderPayType;
    }


    public Double getOrderProfit() {
        return this.orderProfit;
    }


    public void setOrderProfit(Double orderProfit) {
        this.orderProfit = orderProfit;
    }


    public Boolean getIsSelect() {
        return this.isSelect;
    }


    public void setIsSelect(Boolean isSelect) {
        this.isSelect = isSelect;
    }


    public Integer getOrderType() {
        return this.orderType;
    }


    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
}
