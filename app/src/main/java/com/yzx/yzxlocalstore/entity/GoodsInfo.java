package com.yzx.yzxlocalstore.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import com.yzx.yzxlocalstore.app.MyAplication;
import com.yzx.yzxlocalstore.greendao.DaoSession;
import com.yzx.yzxlocalstore.greendao.GoodsTypeDao;
import com.yzx.yzxlocalstore.greendao.GoodsInfoDao;

/**
 * Created by Administrator on 2019/7/8.
 */

@Entity
public class GoodsInfo implements Parcelable {

    @Id(autoincrement = true)
    private Long id;
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
    private boolean isSelect;//商品是否选中
    private boolean isAllSelect;//商品是否全选
    private String typeName;
    @Generated(hash = 1343439262)
    public GoodsInfo(Long id, String goodName, double goodPrice,
            double goodOriginalPrice, double goodStore, double goodStoreWarningNum,
            double goodProfit, boolean goodStatus, String goodCode,
            String goodPinyinCode, int goodLoaction, double vipLevelOnePrice,
            double vipLevelTwoPrice, double vipLevelThreePrice,
            double vipLevelFourthPrice, double vipLevelFivePrice,
            String goodBriefIntroduction, String goodRemarks, boolean isSelect,
            boolean isAllSelect, String typeName) {
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
        this.isSelect = isSelect;
        this.isAllSelect = isAllSelect;
        this.typeName = typeName;
    }
    @Generated(hash = 1227172248)
    public GoodsInfo() {
    }

    protected GoodsInfo(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        goodName = in.readString();
        goodPrice = in.readDouble();
        goodOriginalPrice = in.readDouble();
        goodStore = in.readDouble();
        goodStoreWarningNum = in.readDouble();
        goodProfit = in.readDouble();
        goodStatus = in.readByte() != 0;
        goodCode = in.readString();
        goodPinyinCode = in.readString();
        goodLoaction = in.readInt();
        vipLevelOnePrice = in.readDouble();
        vipLevelTwoPrice = in.readDouble();
        vipLevelThreePrice = in.readDouble();
        vipLevelFourthPrice = in.readDouble();
        vipLevelFivePrice = in.readDouble();
        goodBriefIntroduction = in.readString();
        goodRemarks = in.readString();
        isSelect = in.readByte() != 0;
        isAllSelect = in.readByte() != 0;
        typeName = in.readString();
    }

    public static final Creator<GoodsInfo> CREATOR = new Creator<GoodsInfo>() {
        @Override
        public GoodsInfo createFromParcel(Parcel in) {
            return new GoodsInfo(in);
        }

        @Override
        public GoodsInfo[] newArray(int size) {
            return new GoodsInfo[size];
        }
    };

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
    public int getGoodLoaction() {
        return this.goodLoaction;
    }
    public void setGoodLoaction(int goodLoaction) {
        this.goodLoaction = goodLoaction;
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
    public boolean getIsSelect() {
        return this.isSelect;
    }
    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }
    public boolean getIsAllSelect() {
        return this.isAllSelect;
    }
    public void setIsAllSelect(boolean isAllSelect) {
        this.isAllSelect = isAllSelect;
    }
    public String getTypeName() {
        return this.typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(goodName);
        dest.writeDouble(goodPrice);
        dest.writeDouble(goodOriginalPrice);
        dest.writeDouble(goodStore);
        dest.writeDouble(goodStoreWarningNum);
        dest.writeDouble(goodProfit);
        dest.writeByte((byte) (goodStatus ? 1 : 0));
        dest.writeString(goodCode);
        dest.writeString(goodPinyinCode);
        dest.writeInt(goodLoaction);
        dest.writeDouble(vipLevelOnePrice);
        dest.writeDouble(vipLevelTwoPrice);
        dest.writeDouble(vipLevelThreePrice);
        dest.writeDouble(vipLevelFourthPrice);
        dest.writeDouble(vipLevelFivePrice);
        dest.writeString(goodBriefIntroduction);
        dest.writeString(goodRemarks);
        dest.writeByte((byte) (isSelect ? 1 : 0));
        dest.writeByte((byte) (isAllSelect ? 1 : 0));
        dest.writeString(typeName);
    }
}
