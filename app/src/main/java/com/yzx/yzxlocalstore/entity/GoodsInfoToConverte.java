package com.yzx.yzxlocalstore.entity;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019/9/17.
 */

public class GoodsInfoToConverte  implements PropertyConverter<List<GoodsInfo>, String> {
    @Override
    public List<GoodsInfo> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        // 先得获得这个，然后再typeToken.getType()，否则会异常
        Log.e("创建订单","databaseValue: "+databaseValue);

        TypeToken<List<GoodsInfo>> typeToken = new TypeToken<List<GoodsInfo>>(){};
        return new Gson().fromJson(databaseValue, typeToken.getType());
    }

    @Override
    public String convertToDatabaseValue(List<GoodsInfo> arrays) {
        if (arrays == null||arrays.size()==0) {
            return null;
        } else {
            String sb = new Gson().toJson(arrays);
            return sb;

        }
    }
}
