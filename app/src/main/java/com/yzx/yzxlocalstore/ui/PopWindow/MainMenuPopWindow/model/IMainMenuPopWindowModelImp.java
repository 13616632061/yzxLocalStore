package com.yzx.yzxlocalstore.ui.PopWindow.MainMenuPopWindow.model;

import com.yzx.yzxlocalstore.entity.TypeBean;
import com.yzx.yzxlocalstore.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2019/7/25.
 */

public interface IMainMenuPopWindowModelImp {
    //获取管理分类信息
    List<TypeBean> getTypeInfo();

    //更新分类信息
    void updateTypeInfo(TypeBean typeBean);

    //清除分类信息数据
    void clearAllTypeInfo();

    //添加分类信息
    void addTypeInfo(TypeBean typeBean);

    //更新员工信息
    void updateStaffInfo(User user);
}
