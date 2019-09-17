package com.yzx.yzxlocalstore.entity;

import com.google.gson.Gson;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019/9/17.
 */

public class UserToConverte implements PropertyConverter<User, String> {
    @Override
    public User convertToEntityProperty(String databaseValue) {
        return new Gson().fromJson(databaseValue, User.class);
    }

    @Override
    public String convertToDatabaseValue(User entityProperty) {
        return new Gson().toJson(entityProperty);
    }
}
