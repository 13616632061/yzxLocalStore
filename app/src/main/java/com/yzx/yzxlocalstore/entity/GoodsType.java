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
    private Integer sort=-1;
    private Boolean status=true;
    private Boolean isSelect=false;

    protected GoodsType(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        typeName = in.readString();
        if (in.readByte() == 0) {
            sort = null;
        } else {
            sort = in.readInt();
        }
        byte tmpStatus = in.readByte();
        status = tmpStatus == 0 ? null : tmpStatus == 1;
        byte tmpIsSelect = in.readByte();
        isSelect = tmpIsSelect == 0 ? null : tmpIsSelect == 1;
    }

    @Generated(hash = 25456874)
    public GoodsType(Long id, String typeName, Integer sort, Boolean status,
            Boolean isSelect) {
        this.id = id;
        this.typeName = typeName;
        this.sort = sort;
        this.status = status;
        this.isSelect = isSelect;
    }

    @Generated(hash = 1568965165)
    public GoodsType() {
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
        if (sort == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(sort);
        }
        dest.writeByte((byte) (status == null ? 0 : status ? 1 : 2));
        dest.writeByte((byte) (isSelect == null ? 0 : isSelect ? 1 : 2));
    }

    @Override
    public int compareTo(@NonNull GoodsType o) {
        return 0;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", sort=" + sort +
                ", status=" + status +
                ", isSelect=" + isSelect +
                '}';
    }

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

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getIsSelect() {
        return this.isSelect;
    }

    public void setIsSelect(Boolean isSelect) {
        this.isSelect = isSelect;
    }
}
