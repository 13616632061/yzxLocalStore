package com.yzx.yzxlocalstore.entity;

import com.yzx.yzxlocalstore.constant.Constants;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;
import org.greenrobot.greendao.DaoException;
import com.yzx.yzxlocalstore.greendao.DaoSession;
import com.yzx.yzxlocalstore.greendao.TypeBeanDao;
import com.yzx.yzxlocalstore.greendao.UserDao;

/**
 * Created by lyf on 2019/4/30.
 */

@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;//用户id
    @Unique
    private String number;//工号
    private String name;//姓名
    private String phone;//手机号码
    private Integer level=0;//用户等级 0表示商户 1表示员工
    private Boolean status=true;//账号状态
    private Double salesCommission=0.00;//销售提成
    private Boolean isShowBuyingPrice=true;//是否显示进货价
    private Boolean isShowBuyingProfit=true;//是否显示利润
    private Boolean isShowBuyingStore=true;//是否显示库存
    private String pwd;//用户密码

    @Generated(hash = 1629530544)
    public User(Long id, String number, String name, String phone, Integer level,
            Boolean status, Double salesCommission, Boolean isShowBuyingPrice,
            Boolean isShowBuyingProfit, Boolean isShowBuyingStore, String pwd) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.phone = phone;
        this.level = level;
        this.status = status;
        this.salesCommission = salesCommission;
        this.isShowBuyingPrice = isShowBuyingPrice;
        this.isShowBuyingProfit = isShowBuyingProfit;
        this.isShowBuyingStore = isShowBuyingStore;
        this.pwd = pwd;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", level=" + level +
                ", status=" + status +
                ", salesCommission=" + salesCommission +
                ", isShowBuyingPrice=" + isShowBuyingPrice +
                ", isShowBuyingProfit=" + isShowBuyingProfit +
                ", isShowBuyingStore=" + isShowBuyingStore +
                ", pwd='" + pwd + '\'' +
                '}';
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getSalesCommission() {
        return this.salesCommission;
    }

    public void setSalesCommission(Double salesCommission) {
        this.salesCommission = salesCommission;
    }

    public Boolean getIsShowBuyingPrice() {
        return this.isShowBuyingPrice;
    }

    public void setIsShowBuyingPrice(Boolean isShowBuyingPrice) {
        this.isShowBuyingPrice = isShowBuyingPrice;
    }

    public Boolean getIsShowBuyingProfit() {
        return this.isShowBuyingProfit;
    }

    public void setIsShowBuyingProfit(Boolean isShowBuyingProfit) {
        this.isShowBuyingProfit = isShowBuyingProfit;
    }

    public Boolean getIsShowBuyingStore() {
        return this.isShowBuyingStore;
    }

    public void setIsShowBuyingStore(Boolean isShowBuyingStore) {
        this.isShowBuyingStore = isShowBuyingStore;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
