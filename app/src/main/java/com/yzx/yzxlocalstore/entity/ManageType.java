package com.yzx.yzxlocalstore.entity;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2019/5/7.
 * 管理页面分类实体
 */

public class ManageType {
    private String name;
    private String channelTag;
    private int  selectIcon;
    private int  unSelectIcon;
    private boolean isShow;

    public String getChannelTag() {
        return channelTag;
    }

    public void setChannelTag(String channelTag) {
        this.channelTag = channelTag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSelectIcon() {
        return selectIcon;
    }

    public void setSelectIcon(int selectIcon) {
        this.selectIcon = selectIcon;
    }

    public int getUnSelectIcon() {
        return unSelectIcon;
    }

    public void setUnSelectIcon(int unSelectIcon) {
        this.unSelectIcon = unSelectIcon;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }
}
