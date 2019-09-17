package com.yzx.yzxlocalstore.entity;

import com.google.gson.Gson;

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
        List<String> list_str = Arrays.asList(databaseValue.split(","));
        List<GoodsInfo> list_transport = new ArrayList<>();
        for (String s : list_str) {
            list_transport.add(new Gson().fromJson(s, GoodsInfo.class));
        }
        return list_transport;
    }

    @Override
    public String convertToDatabaseValue(List<GoodsInfo> arrays) {
        if (arrays == null) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (GoodsInfo array : arrays) {
                String str = new Gson().toJson(array);
                sb.append(str);
                sb.append(",");
            }
            return sb.toString();

        }
    }
}
