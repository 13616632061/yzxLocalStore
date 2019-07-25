package com.yzx.yzxlocalstore.entity;

import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2019/7/1.
 */

@Entity
public class TypeBean {
    @Id(autoincrement = true)
    private Long typeId;
    private Long id;//登录用户id
    private String name;
    private String channelTag;
    private int typeCode;//1为常用栏目
    @Generated(hash = 2094889216)
    public TypeBean(Long typeId, Long id, String name, String channelTag,
            int typeCode) {
        this.typeId = typeId;
        this.id = id;
        this.name = name;
        this.channelTag = channelTag;
        this.typeCode = typeCode;
    }
    @Generated(hash = 119682038)
    public TypeBean() {
    }
    public Long getTypeId() {
        return this.typeId;
    }
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getChannelTag() {
        return this.channelTag;
    }
    public void setChannelTag(String channelTag) {
        this.channelTag = channelTag;
    }
    public int getTypeCode() {
        return this.typeCode;
    }
    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    @Override
    public String toString() {
        return "TypeBean{" +
                "typeId=" + typeId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", channelTag='" + channelTag + '\'' +
                ", typeCode=" + typeCode +
                '}';
    }
}
