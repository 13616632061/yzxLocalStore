package com.yzx.yzxlocalstore.utils;

/**
 * Created by Administrator on 2019/7/22.
 */

public class SaveDataHelpUtitls {

    private volatile static SaveDataHelpUtitls mInstance;

    private SaveDataHelpUtitls() {

    }

    public static SaveDataHelpUtitls getInstance() {
        if (mInstance == null) {
            synchronized (SaveDataHelpUtitls.class) {
                if (mInstance == null) {
                    mInstance = new SaveDataHelpUtitls();
                }
            }
        }
        return mInstance;
    }
}
