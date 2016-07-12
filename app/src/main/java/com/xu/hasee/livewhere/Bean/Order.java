package com.xu.hasee.livewhere.Bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2016/5/20 0020.
 */
public class Order extends BmobObject {
    private String username;
    private String name;
    private String cashback;
    private String adress;
    private String orderId;
    private String orderstate;
    private String bookdate;
    private String bookmoney;
    private String paytype;
    private String housetype;
    private String checkintime;
    private String checkinperson;
    private String telephone;

    public String getUsername() {
        return username;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCashback() {
        return cashback;
    }

    public void setCashback(String cashback) {
        this.cashback = cashback;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate;
    }

    public String getBookdate() {
        return bookdate;
    }

    public void setBookdate(String bookdate) {
        this.bookdate = bookdate;
    }

    public String getBookmoney() {
        return bookmoney;
    }

    public void setBookmoney(String bookmoney) {
        this.bookmoney = bookmoney;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype;
    }

    public String getCheckintime() {
        return checkintime;
    }

    public void setCheckintime(String checkintime) {
        this.checkintime = checkintime;
    }

    public String getCheckinperson() {
        return checkinperson;
    }

    public void setCheckinperson(String checkinperson) {
        this.checkinperson = checkinperson;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
