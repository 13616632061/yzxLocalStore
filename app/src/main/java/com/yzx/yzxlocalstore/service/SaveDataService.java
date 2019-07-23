package com.yzx.yzxlocalstore.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.utils.ExcelUtil;

import java.util.List;

public class SaveDataService extends Service {

    private ExcelUtil mExcelUtil;

    public SaveDataService() {
    }

    public class SaveDataBinder extends Binder {

        public void initExcel(int type) {
            switch (type) {
                case 1:
                    mExcelUtil.initExcel(getResources().getString(R.string.goods_infos), getResources().getStringArray(R.array.goodsInfoHeader));
                    break;
            }

        }

        public void saveGoodsInfoData(List<GoodsInfo> objList, String excelName) {
            mExcelUtil.writeObjListToExcel(objList, excelName);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mExcelUtil = ExcelUtil.getInstance();
    }
}
