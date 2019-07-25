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
    private int level;//用户等级 0表示商户 1表示员工
    private boolean status;//账号状态
    private double salesCommission;//销售提成
    private boolean isShowBuyingPrice;//是否显示进货价
    private boolean isShowBuyingProfit;//是否显示利润
    private boolean isShowBuyingStore;//是否显示库存
    private String pwd;//用户密码
    @Generated(hash = 1560097334)
    public User(Long id, String number, String name, String phone, int level,
            boolean status, double salesCommission, boolean isShowBuyingPrice,
            boolean isShowBuyingProfit, boolean isShowBuyingStore, String pwd) {
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
    public int getLevel() {
        return this.level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public boolean getStatus() {
        return this.status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public double getSalesCommission() {
        return this.salesCommission;
    }
    public void setSalesCommission(double salesCommission) {
        this.salesCommission = salesCommission;
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
    public String getPwd() {
        return this.pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
  
}
