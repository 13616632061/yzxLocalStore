package com.yzx.yzxlocalstore.entity;

import org.greenrobot.greendao.annotation.Entity;
import java.util.List;

/**
 * Created by Administrator on 2019/7/1.
 */

public class ManageChannelType {

    private List<TypeBean> type;

    public List<TypeBean> getType() {
        return type;
    }

    public void setType(List<TypeBean> type) {
        this.type = type;
    }

}
