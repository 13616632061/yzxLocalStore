package com.yzx.yzxlocalstore.ui.PopWindow.MainMenuPopWindow.model;

import com.yzx.yzxlocalstore.entity.TypeBean;
import com.yzx.yzxlocalstore.greendao.GreenDaoHelp;
import com.yzx.yzxlocalstore.greendao.TypeBeanDao;
import com.yzx.yzxlocalstore.utils.LoginUserUtil;

import java.util.List;

/**
 * Created by Administrator on 2019/7/25.
 */

public class MainMenuPopWindowModel implements IMainMenuPopWindowModelImp {
    /**
     * 获取管理分类信息
     *
     * @return
     */
    @Override
    public List<TypeBean> getTypeInfo() {
        List<TypeBean> list = GreenDaoHelp.getDaoSession().getTypeBeanDao().queryBuilder().where(TypeBeanDao.Properties.Id.eq(LoginUserUtil.getInstance().getLoginUser().getId())).list();
        return list;
    }

    /**
     * 更新分类信息
     *
     * @param typeBean
     */
    @Override
    public void updateTypeInfo(TypeBean typeBean) {
        GreenDaoHelp.getDaoSession().getTypeBeanDao().update(typeBean);
    }

    @Override
    public void clearAllTypeInfo() {
        GreenDaoHelp.getDaoSession().getTypeBeanDao().deleteAll();
    }

    @Override
    public void addTypeInfo(TypeBean typeBean) {
        GreenDaoHelp.getDaoSession().getTypeBeanDao().insert(typeBean);
    }
}
