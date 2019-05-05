package com.yzx.yzxlocalstore.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by lyf on 2019/4/30.
 */

@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;//用户id
    private int level;//用户等级
    @Unique
    private String name;//用户名
    private String pwd;//用户密码

    @Generated(hash = 1302448903)
    public User(Long id, int level, String name, String pwd) {
        this.id = id;
        this.level = level;
        this.name = name;
        this.pwd = pwd;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
