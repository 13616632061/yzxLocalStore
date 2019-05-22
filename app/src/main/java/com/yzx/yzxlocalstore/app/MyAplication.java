package com.yzx.yzxlocalstore.app;

import android.database.sqlite.SQLiteDatabase;

import com.yzx.lib.app.LibAplication;
import com.yzx.yzxlocalstore.greendao.DaoMaster;
import com.yzx.yzxlocalstore.greendao.DaoSession;

/**
 * Created by lyf on 2019/4/30.
 */

public class MyAplication extends LibAplication {

    @Override
    public void onCreate() {
        super.onCreate();

        initGreenDao();
    }

    /**
     * 初始化GreenDao,直接在Application中进行初始化操作
     */
    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "aserbao.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    private static DaoSession daoSession;
    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
