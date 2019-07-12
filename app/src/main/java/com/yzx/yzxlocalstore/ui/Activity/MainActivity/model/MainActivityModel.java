package com.yzx.yzxlocalstore.ui.Activity.MainActivity.model;

import android.content.Context;
import android.util.Log;

import com.apkfuns.logutils.LogUtils;
import com.blankj.utilcode.util.FileIOUtils;
import com.yzx.lib.util.FileUtil;
import com.yzx.yzxlocalstore.app.MyAplication;
import com.yzx.yzxlocalstore.constant.Constants;
import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.greendao.DaoSession;
import com.yzx.yzxlocalstore.greendao.UserDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by Administrator on 2019/7/1.
 */

public class MainActivityModel implements IMainActivityModelImp {
    //获取管理分类信息
    @Override
    public String getTypeChannel(Context context) {
        DaoSession daoSession = ((MyAplication) context.getApplicationContext()).getDaoSession();
        QueryBuilder<User> queryBuilder = daoSession.queryBuilder(User.class);
        List<User> userList = queryBuilder.where(UserDao.Properties.Id.eq(Constants.loginUserInfo.getId())).list();
        String typeStr = null;
        if (userList.get(0).getTypeBeanList().size() > 0) {
            typeStr = userList.get(0).getTypeBeanList().toString();
        } else {
            typeStr = FileUtil.readAssetsJson(context, "manegetype.json");
        }
        LogUtils.e("typeStr4:" + typeStr);
        return typeStr;
    }
}
