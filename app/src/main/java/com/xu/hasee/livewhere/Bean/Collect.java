package com.xu.hasee.livewhere.Bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2016/5/19 0019.
 */
public class Collect extends BmobObject {
    private String hotelid;
    private String username;
    private String hotelname;
    private String scores;
    private String xingji;
    private String address;
    private String price;
   private String pic153;

    public String getPic153() {
        return pic153;
    }

    public void setPic153(String pic153) {
        this.pic153 = pic153;
    }

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    public String getXingji() {
        return xingji;
    }

    public void setXingji(String xingji) {
        this.xingji = xingji;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}