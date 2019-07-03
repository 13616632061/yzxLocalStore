package com.yzx.yzxlocalstore.entity;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2019/7/2.
 */

@Entity
public class GoodsType implements Comparable<GoodsType>{

    @Id(autoincrement = true)
    private Long id;
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
}
