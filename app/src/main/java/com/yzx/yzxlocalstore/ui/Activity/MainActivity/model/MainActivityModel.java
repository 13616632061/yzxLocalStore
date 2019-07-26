package com.yzx.yzxlocalstore.ui.Activity.MainActivity.model;

import android.content.Context;
import android.util.Log;

import com.apkfuns.logutils.LogUtils;
import com.blankj.utilcode.util.FileIOUtils;
import com.yzx.lib.util.FileUtil;
import com.yzx.yzxlocalstore.app.MyAplication;
import com.yzx.yzxlocalstore.constant.Constants;
import com.yzx.yzxlocalstore.entity.TypeBean;
import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.greendao.DaoSession;
import com.yzx.yzxlocalstore.greendao.GreenDaoHelp;
import com.yzx.yzxlocalstore.greendao.TypeBeanDao;
import com.yzx.yzxlocalstore.greendao.UserDao;
import com.yzx.yzxlocalstore.utils.LoginUserUtil;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by Administrator on 2019/7/1.
 */

public class MainActivityModel implements IMainActivityModelImp {
    /**
     * 登录用户是否已经初始管理栏目
     *
     * @return
     */
    @Override
    public boolean isInitTypeChannel() {
        boolean isInitTypeChannel = false;
        long count = GreenDaoHelp.getDaoSession().getTypeBeanDao().queryBuilder().where(TypeBeanDao.Properties.Id.eq(LoginUserUtil.getInstance().getLoginUser().getId())).count();
        if (count > 0) {
            isInitTypeChannel = true;
        }
        return isInitTypeChannel;
    }

    /**
     * 初始化管理栏目
     */
    @Override
    public void initTypeChannel(TypeBean typeBean) {
        GreenDaoHelp.getDaoSession().getTypeBeanDao().insert(typeBean);
    }

    /**
     * 获取底部管理分类
     *
     * @return
     */
    @Override
    public List<TypeBean> getBottomType() {
        List<TypeBean> list = GreenDaoHelp.getDaoSession().getTypeBeanDao().queryBuilder().where(TypeBeanDao.Properties.TypeCode.eq(1)).list();
        return list;
    }


}
