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
    private long number;//工号
    private String name;//姓名
    private int level;//用户等级
    @Unique
    private String account;//用户名
    private String pwd;//用户密码

    @Generated(hash = 588465990)
    public User(Long id, long number, String name, int level, String account,
            String pwd) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.level = level;
        this.account = account;
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

    public long getNumber() {
        return this.number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
