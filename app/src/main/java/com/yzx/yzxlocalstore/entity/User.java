package com.yzx.yzxlocalstore.entity;

import com.yzx.yzxlocalstore.constant.Constants;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by lyf on 2019/4/30.
 */

@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;//用户id
    private String number;//工号
    private String name;//姓名
    private String phone;//手机号码
    private int level;//用户等级
    private boolean status;//账号状态
    private boolean enable;//是否启用
    private double salesCommission;//销售提成
    private boolean isShowBuyingPrice;//是否显示进货价
    private boolean isShowBuyingProfit;//是否显示利润
    private boolean isShowBuyingStore;//是否显示库存

    @Unique
    private String account;//用户名
    private String pwd;//用户密码

    @Generated(hash = 57019867)
    public User(Long id, String number, String name, String phone, int level, boolean status,
            boolean enable, double salesCommission, boolean isShowBuyingPrice,
            boolean isShowBuyingProfit, boolean isShowBuyingStore, String account,
            String pwd) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.phone = phone;
        this.level = level;
        this.status = status;
        this.enable = enable;
        this.salesCommission = salesCommission;
        this.isShowBuyingPrice = isShowBuyingPrice;
        this.isShowBuyingProfit = isShowBuyingProfit;
        this.isShowBuyingStore = isShowBuyingStore;
        this.account = account;
        this.pwd = pwd;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public double getSalesCommission() {
        return salesCommission;
    }

    public void setSalesCommission(double salesCommission) {
        this.salesCommission = salesCommission;
    }

    public boolean isShowBuyingPrice() {
        return isShowBuyingPrice;
    }

    public void setShowBuyingPrice(boolean showBuyingPrice) {
        isShowBuyingPrice = showBuyingPrice;
    }

    public boolean isShowBuyingProfit() {
        return isShowBuyingProfit;
    }

    public void setShowBuyingProfit(boolean showBuyingProfit) {
        isShowBuyingProfit = showBuyingProfit;
    }

    public boolean isShowBuyingStore() {
        return isShowBuyingStore;
    }

    public void setShowBuyingStore(boolean showBuyingStore) {
        isShowBuyingStore = showBuyingStore;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public boolean getEnable() {
        return this.enable;
    }

    public boolean getIsShowBuyingPrice() {
        return this.isShowBuyingPrice;
    }

    public void setIsShowBuyingPrice(boolean isShowBuyingPrice) {
        this.isShowBuyingPrice = isShowBuyingPrice;
    }

    public boolean getIsShowBuyingProfit() {
        return this.isShowBuyingProfit;
    }

    public void setIsShowBuyingProfit(boolean isShowBuyingProfit) {
        this.isShowBuyingProfit = isShowBuyingProfit;
    }

    public boolean getIsShowBuyingStore() {
        return this.isShowBuyingStore;
    }

    public void setIsShowBuyingStore(boolean isShowBuyingStore) {
        this.isShowBuyingStore = isShowBuyingStore;
    }

    /**
     * 角色名称
     *
     * @return
     */
    public String getRoles() {
        if (level == 0) {
            return Constants.STAFFER_ROLES[0];
        } else {
            return Constants.STAFFER_ROLES[1];
        }
    }

    /**
     * 状态名称
     *
     * @return
     */
    public String getStatusName() {
        if (status) {
            return Constants.STAFFER_STATUS[0];
        } else {
            return Constants.STAFFER_STATUS[1];
        }
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return this.status;
    }
}
