package com.yzx.yzxlocalstore.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;

/**
 * Created by Administrator on 2019/10/15.
 */

public class TypeToConverte implements PropertyConverter<List<TypeBean>, String>  {
    @Override
    public List<TypeBean> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        // 先得获得这个，然后再typeToken.getType()，否则会异常
        TypeToken<List<TypeBean>> typeToken = new TypeToken<List<TypeBean>>(){};
        return new Gson().fromJson(databaseValue, typeToken.getType());
    }

    @Override
    public String convertToDatabaseValue(List<TypeBean> arrays) {
        if (arrays == null||arrays.size()==0) {
            return null;
        } else {
            String sb = new Gson().toJson(arrays);
            return sb;

        }
    }
}
