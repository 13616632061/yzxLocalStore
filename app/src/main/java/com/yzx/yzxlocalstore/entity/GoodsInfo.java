package com.yzx.yzxlocalstore.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import com.yzx.yzxlocalstore.app.MyAplication;
import com.yzx.yzxlocalstore.greendao.DaoSession;
import com.yzx.yzxlocalstore.greendao.GoodsTypeDao;
import com.yzx.yzxlocalstore.greendao.GoodsInfoDao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/7/8.
 */

@Entity
public class GoodsInfo implements Parcelable ,Serializable{

    private static final long serialVersionUID = 5518784473903551250L;
    @Id(autoincrement = true)
    private Long id;
    private String goodName;//商品名字
    private Double goodPrice=0.00;//商品价格
    private Double goodOriginalPrice=0.00;//商品进价
    private Double goodStore=0.00;//商品库存
    private Double goodStoreWarningNum=0.00;//库存预警数量
    private Double goodProfit=0.00;//商品利润
    private Boolean goodStatus=true;//商品上下架状态
    private String goodCode;//商品条码
    private String goodPinyinCode;//商品拼音码
    private Integer goodLoaction=0;//商品栏目：1快捷栏，2计重栏
    private Double vipLevelOnePrice=0.00;//会员等级价格
    private Double vipLevelTwoPrice=0.00;
    private Double vipLevelThreePrice=0.00;
    private Double vipLevelFourthPrice=0.00;
    private Double vipLevelFivePrice=0.00;
    private String goodBriefIntroduction;//商品简介
    private String goodRemarks;//商品备注
    private Boolean isSelect=false;//商品是否选中
    private Boolean isAllSelect=false;//商品是否全选
    private Double num=1.0;//下单数量
    private String typeName;
    private Integer sort=-1;


    protected GoodsInfo(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        goodName = in.readString();
        if (in.readByte() == 0) {
            goodPrice = null;
        } else {
            goodPrice = in.readDouble();
        }
        if (in.readByte() == 0) {
            goodOriginalPrice = null;
        } else {
            goodOriginalPrice = in.readDouble();
        }
        if (in.readByte() == 0) {
            goodStore = null;
        } else {
            goodStore = in.readDouble();
        }
        if (in.readByte() == 0) {
            goodStoreWarningNum = null;
        } else {
            goodStoreWarningNum = in.readDouble();
        }
        if (in.readByte() == 0) {
            goodProfit = null;
        } else {
            goodProfit = in.readDouble();
        }
        byte tmpGoodStatus = in.readByte();
        goodStatus = tmpGoodStatus == 0 ? null : tmpGoodStatus == 1;
        goodCode = in.readString();
        goodPinyinCode = in.readString();
        if (in.readByte() == 0) {
            goodLoaction = null;
        } else {
            goodLoaction = in.readInt();
        }
        if (in.readByte() == 0) {
            vipLevelOnePrice = null;
        } else {
            vipLevelOnePrice = in.readDouble();
        }
        if (in.readByte() == 0) {
            vipLevelTwoPrice = null;
        } else {
            vipLevelTwoPrice = in.readDouble();
        }
        if (in.readByte() == 0) {
            vipLevelThreePrice = null;
        } else {
            vipLevelThreePrice = in.readDouble();
        }
        if (in.readByte() == 0) {
            vipLevelFourthPrice = null;
        } else {
            vipLevelFourthPrice = in.readDouble();
        }
        if (in.readByte() == 0) {
            vipLevelFivePrice = null;
        } else {
            vipLevelFivePrice = in.readDouble();
        }
        goodBriefIntroduction = in.readString();
        goodRemarks = in.readString();
        byte tmpIsSelect = in.readByte();
        isSelect = tmpIsSelect == 0 ? null : tmpIsSelect == 1;
        byte tmpIsAllSelect = in.readByte();
        isAllSelect = tmpIsAllSelect == 0 ? null : tmpIsAllSelect == 1;
        if (in.readByte() == 0) {
            num = null;
        } else {
            num = in.readDouble();
        }
        typeName = in.readString();
        if (in.readByte() == 0) {
            sort = null;
        } else {
            sort = in.readInt();
        }
    }

    @Generated(hash = 794828065)
    public GoodsInfo(Long id, String goodName, Double goodPrice,
            Double goodOriginalPrice, Double goodStore, Double goodStoreWarningNum,
            Double goodProfit, Boolean goodStatus, String goodCode,
            String goodPinyinCode, Integer goodLoaction, Double vipLevelOnePrice,
            Double vipLevelTwoPrice, Double vipLevelThreePrice,
            Double vipLevelFourthPrice, Double vipLevelFivePrice,
            String goodBriefIntroduction, String goodRemarks, Boolean isSelect,
            Boolean isAllSelect, Double num, String typeName, Integer sort) {
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
        this.num = num;
        this.typeName = typeName;
        this.sort = sort;
    }

    @Generated(hash = 1227172248)
    public GoodsInfo() {
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
        if (goodPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(goodPrice);
        }
        if (goodOriginalPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(goodOriginalPrice);
        }
        if (goodStore == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(goodStore);
        }
        if (goodStoreWarningNum == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(goodStoreWarningNum);
        }
        if (goodProfit == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(goodProfit);
        }
        dest.writeByte((byte) (goodStatus == null ? 0 : goodStatus ? 1 : 2));
        dest.writeString(goodCode);
        dest.writeString(goodPinyinCode);
        if (goodLoaction == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(goodLoaction);
        }
        if (vipLevelOnePrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(vipLevelOnePrice);
        }
        if (vipLevelTwoPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(vipLevelTwoPrice);
        }
        if (vipLevelThreePrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(vipLevelThreePrice);
        }
        if (vipLevelFourthPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(vipLevelFourthPrice);
        }
        if (vipLevelFivePrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(vipLevelFivePrice);
        }
        dest.writeString(goodBriefIntroduction);
        dest.writeString(goodRemarks);
        dest.writeByte((byte) (isSelect == null ? 0 : isSelect ? 1 : 2));
        dest.writeByte((byte) (isAllSelect == null ? 0 : isAllSelect ? 1 : 2));
        if (num == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(num);
        }
        dest.writeString(typeName);
        if (sort == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(sort);
        }
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

    public Double getGoodPrice() {
        return this.goodPrice;
    }

    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Double getGoodOriginalPrice() {
        return this.goodOriginalPrice;
    }

    public void setGoodOriginalPrice(Double goodOriginalPrice) {
        this.goodOriginalPrice = goodOriginalPrice;
    }

    public Double getGoodStore() {
        return this.goodStore;
    }

    public void setGoodStore(Double goodStore) {
        this.goodStore = goodStore;
    }

    public Double getGoodStoreWarningNum() {
        return this.goodStoreWarningNum;
    }

    public void setGoodStoreWarningNum(Double goodStoreWarningNum) {
        this.goodStoreWarningNum = goodStoreWarningNum;
    }

    public Double getGoodProfit() {
        return this.goodProfit;
    }

    public void setGoodProfit(Double goodProfit) {
        this.goodProfit = goodProfit;
    }

    public Boolean getGoodStatus() {
        return this.goodStatus;
    }

    public void setGoodStatus(Boolean goodStatus) {
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

    public Integer getGoodLoaction() {
        return this.goodLoaction;
    }

    public void setGoodLoaction(Integer goodLoaction) {
        this.goodLoaction = goodLoaction;
    }

    public Double getVipLevelOnePrice() {
        return this.vipLevelOnePrice;
    }

    public void setVipLevelOnePrice(Double vipLevelOnePrice) {
        this.vipLevelOnePrice = vipLevelOnePrice;
    }

    public Double getVipLevelTwoPrice() {
        return this.vipLevelTwoPrice;
    }

    public void setVipLevelTwoPrice(Double vipLevelTwoPrice) {
        this.vipLevelTwoPrice = vipLevelTwoPrice;
    }

    public Double getVipLevelThreePrice() {
        return this.vipLevelThreePrice;
    }

    public void setVipLevelThreePrice(Double vipLevelThreePrice) {
        this.vipLevelThreePrice = vipLevelThreePrice;
    }

    public Double getVipLevelFourthPrice() {
        return this.vipLevelFourthPrice;
    }

    public void setVipLevelFourthPrice(Double vipLevelFourthPrice) {
        this.vipLevelFourthPrice = vipLevelFourthPrice;
    }

    public Double getVipLevelFivePrice() {
        return this.vipLevelFivePrice;
    }

    public void setVipLevelFivePrice(Double vipLevelFivePrice) {
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

    public Boolean getIsSelect() {
        return this.isSelect;
    }

    public void setIsSelect(Boolean isSelect) {
        this.isSelect = isSelect;
    }

    public Boolean getIsAllSelect() {
        return this.isAllSelect;
    }

    public void setIsAllSelect(Boolean isAllSelect) {
        this.isAllSelect = isAllSelect;
    }

    public Double getNum() {
        return this.num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


}
