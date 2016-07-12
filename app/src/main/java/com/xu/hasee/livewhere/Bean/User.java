package com.xu.hasee.livewhere.Bean;

import java.util.Date;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2016/5/13 0013.
 */
public class User extends BmobUser {
    private String name;    //姓名
    private String nickname;//昵称
    private String sex;     //性别
    private String birthday;//生日

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
