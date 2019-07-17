package com.yzx.yzxlocalstore.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by Administrator on 2019/7/2.
 */

@Entity
public class GoodsType implements Comparable<GoodsType>,Parcelable{

    @Id(autoincrement = true)
    private Long id;
    @Unique
    private String typeName;
    private int sort;
    private boolean status=true;
    private boolean isSelect;
    @Generated(hash = 1029656508)
    public GoodsType(Long id, String typeName, int sort, boolean status,
            boolean isSelect) {
        this.id = id;
        this.typeName = typeName;
        this.sort = sort;
        this.status = status;
        this.isSelect = isSelect;
    }
    @Generated(hash = 1568965165)
    public GoodsType() {
    }

    protected GoodsType(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        typeName = in.readString();
        sort = in.readInt();
        status = in.readByte() != 0;
        isSelect = in.readByte() != 0;
    }

    public static final Creator<GoodsType> CREATOR = new Creator<GoodsType>() {
        @Override
        public GoodsType createFromParcel(Parcel in) {
            return new GoodsType(in);
        }

        @Override
        public GoodsType[] newArray(int size) {
            return new GoodsType[size];
        }
    };

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTypeName() {
        return this.typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public int getSort() {
        return this.sort;
    }
    public void setSort(int sort) {
        this.sort = sort;
    }
    public boolean getStatus() {
        return this.status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean getIsSelect() {
        return this.isSelect;
    }
    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }


    @Override
    public int compareTo(@NonNull GoodsType goodsType) {
        return this.sort-goodsType.getSort();
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
        dest.writeString(typeName);
        dest.writeInt(sort);
        dest.writeByte((byte) (status ? 1 : 0));
        dest.writeByte((byte) (isSelect ? 1 : 0));
    }
}
