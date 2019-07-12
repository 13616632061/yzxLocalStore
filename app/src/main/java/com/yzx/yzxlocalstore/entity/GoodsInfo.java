package com.yzx.yzxlocalstore.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import com.yzx.yzxlocalstore.greendao.DaoSession;
import com.yzx.yzxlocalstore.greendao.GoodsTypeDao;
import com.yzx.yzxlocalstore.greendao.GoodsInfoDao;

/**
 * Created by Administrator on 2019/7/8.
 */

@Entity
public class GoodsInfo {

    @Id(autoincrement = true)
    private Long id;
    @Unique
    private String goodName;//商品名字
    private double goodPrice;//商品价格
    private double goodOriginalPrice;//商品进价
    private double goodStore;//商品库存
    private double goodStoreWarningNum;//库存预警数量
    private double goodProfit;//商品利润
    private boolean goodStatus;//商品上下架状态
    private String goodCode;//商品条码
    private String goodPinyinCode;//商品拼音码
    private int goodLoaction;//商品栏目：1快捷栏，2计重栏
    private double vipLevelOnePrice;//会员等级价格
    private double vipLevelTwoPrice;
    private double vipLevelThreePrice;
    private double vipLevelFourthPrice;
    private double vipLevelFivePrice;
    private String goodBriefIntroduction;//商品简介
    private String goodRemarks;//商品备注
    @ToOne(joinProperty = "id")
    private GoodsType goodsType;//商品分类
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1612499996)
    private transient GoodsInfoDao myDao;

    @Generated(hash = 461236040)
    public GoodsInfo(Long id, String goodName, double goodPrice, double goodOriginalPrice,
            double goodStore, double goodStoreWarningNum, double goodProfit,
            boolean goodStatus, String goodCode, String goodPinyinCode, int goodLoaction,
            double vipLevelOnePrice, double vipLevelTwoPrice, double vipLevelThreePrice,
            double vipLevelFourthPrice, double vipLevelFivePrice,
            String goodBriefIntroduction, String goodRemarks) {
        this.id = id;
        this.goodName = goodName;
        this.goodPrice = goodPrice;
        this.goodOriginalPrice = goodOriginalPrice;
        this.goodStore = goodStore;
        this.goodStoreWarningNum = goodStoreWarningNum;
        this.goodProfit = goodProfit;
        this.goodStatus = goodStatus;
        this.goodCode = goodCode;
        this.goodPinyinCode = goodPinyinCode;
        this.goodLoaction = goodLoaction;
        this.vipLevelOnePrice = vipLevelOnePrice;
        this.vipLevelTwoPrice = vipLevelTwoPrice;
        this.vipLevelThreePrice = vipLevelThreePrice;
        this.vipLevelFourthPrice = vipLevelFourthPrice;
        this.vipLevelFivePrice = vipLevelFivePrice;
        this.goodBriefIntroduction = goodBriefIntroduction;
        this.goodRemarks = goodRemarks;
    }

    @Generated(hash = 1227172248)
    public GoodsInfo() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodName() {
        return this.goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public double getGoodPrice() {
        return this.goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public double getGoodOriginalPrice() {
        return this.goodOriginalPrice;
    }

    public void setGoodOriginalPrice(double goodOriginalPrice) {
        this.goodOriginalPrice = goodOriginalPrice;
    }

    public double getGoodStore() {
        return this.goodStore;
    }

    public void setGoodStore(double goodStore) {
        this.goodStore = goodStore;
    }

    public double getGoodStoreWarningNum() {
        return this.goodStoreWarningNum;
    }

    public void setGoodStoreWarningNum(double goodStoreWarningNum) {
        this.goodStoreWarningNum = goodStoreWarningNum;
    }

    public double getGoodProfit() {
        return this.goodProfit;
    }

    public void setGoodProfit(double goodProfit) {
        this.goodProfit = goodProfit;
    }

    public boolean getGoodStatus() {
        return this.goodStatus;
    }

    public void setGoodStatus(boolean goodStatus) {
        this.goodStatus = goodStatus;
    }

    public String getGoodCode() {
        return this.goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getGoodPinyinCode() {
        return this.goodPinyinCode;
    }

    public void setGoodPinyinCode(String goodPinyinCode) {
        this.goodPinyinCode = goodPinyinCode;
    }


    @Generated(hash = 2084741788)
    private transient Long goodsType__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 834357729)
    public GoodsType getGoodsType() {
        Long __key = this.id;
        if (goodsType__resolvedKey == null || !goodsType__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            GoodsTypeDao targetDao = daoSession.getGoodsTypeDao();
            GoodsType goodsTypeNew = targetDao.load(__key);
            synchronized (this) {
                goodsType = goodsTypeNew;
                goodsType__resolvedKey = __key;
            }
        }
        return goodsType;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1203001536)
    public void setGoodsType(GoodsType goodsType) {
        synchronized (this) {
            this.goodsType = goodsType;
            id = goodsType == null ? null : goodsType.getId();
            goodsType__resolvedKey = id;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1127636671)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getGoodsInfoDao() : null;
    }

    public double getVipLevelOnePrice() {
        return this.vipLevelOnePrice;
    }

    public void setVipLevelOnePrice(double vipLevelOnePrice) {
        this.vipLevelOnePrice = vipLevelOnePrice;
    }

    public double getVipLevelTwoPrice() {
        return this.vipLevelTwoPrice;
    }

    public void setVipLevelTwoPrice(double vipLevelTwoPrice) {
        this.vipLevelTwoPrice = vipLevelTwoPrice;
    }

    public double getVipLevelThreePrice() {
        return this.vipLevelThreePrice;
    }

    public void setVipLevelThreePrice(double vipLevelThreePrice) {
        this.vipLevelThreePrice = vipLevelThreePrice;
    }

    public double getVipLevelFourthPrice() {
        return this.vipLevelFourthPrice;
    }

    public void setVipLevelFourthPrice(double vipLevelFourthPrice) {
        this.vipLevelFourthPrice = vipLevelFourthPrice;
    }

    public double getVipLevelFivePrice() {
        return this.vipLevelFivePrice;
    }

    public void setVipLevelFivePrice(double vipLevelFivePrice) {
        this.vipLevelFivePrice = vipLevelFivePrice;
    }

    public String getGoodBriefIntroduction() {
        return this.goodBriefIntroduction;
    }

    public void setGoodBriefIntroduction(String goodBriefIntroduction) {
        this.goodBriefIntroduction = goodBriefIntroduction;
    }

    public String getGoodRemarks() {
        return this.goodRemarks;
    }

    public void setGoodRemarks(String goodRemarks) {
        this.goodRemarks = goodRemarks;
    }

    public int getGoodLoaction() {
        return this.goodLoaction;
    }

    public void setGoodLoaction(int goodLoaction) {
        this.goodLoaction = goodLoaction;
    }
}
