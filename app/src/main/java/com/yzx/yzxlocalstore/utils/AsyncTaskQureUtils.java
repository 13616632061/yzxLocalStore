package com.yzx.yzxlocalstore.utils;

import android.os.AsyncTask;

/**
 * Created by Administrator on 2019/7/16.
 */

public class AsyncTaskQureUtils extends AsyncTask {

    public AsyncTaskQureUtils(preBefore mpreBefore, QureData mQureData, Success mSuccess) {
        this.mpreBefore = mpreBefore;
        this.mQureData = mQureData;
        this.mSuccess = mSuccess;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mpreBefore != null) {
            mpreBefore.before();
        }
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        if (mQureData != null) {
            return mQureData.qureData();
        }else {
            return null;
        }
    }

    @Override
    protected void onPostExecute(Object object) {
        super.onPostExecute(object);
        if (mSuccess != null) {
            mSuccess.Success(object);
        }
    }

    public interface preBefore {
        void before();
    }

    public preBefore mpreBefore;

    public void setPreBefore(preBefore mpreBefore) {
        this.mpreBefore = mpreBefore;
    }

    public interface QureData {
        Object qureData();
    }

    public QureData mQureData;

    public void setQureData(QureData mQureData) {
        this.mQureData = mQureData;
    }

    public interface Success {
        void Success(Object o);
    }

    public Success mSuccess;

    public void setSuccess(Success mSuccess) {
        this.mSuccess = mSuccess;
    }
}
