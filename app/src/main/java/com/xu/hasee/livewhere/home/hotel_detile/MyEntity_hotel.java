package com.xu.hasee.livewhere.home.hotel_detile;

import java.util.List;

/**
 * Created by hasee on 2016/5/14.
 */
public class MyEntity_hotel {
    private   String hotelname;
    private String address;
    private String comment_scores;
    private String comment_count;
    private String xingji;
    private String zhuangxiu;
    private String[] pictures;

    public MyEntity_hotel(String hotelname, String address, String comment_scores, String comment_count, String xingji, String zhuangxiu, String[] pictures) {
        this.hotelname = hotelname;
        this.address = address;
        this.comment_scores = comment_scores;
        this.comment_count = comment_count;
        this.xingji = xingji;
        this.zhuangxiu = zhuangxiu;
        this.pictures = pictures;
    }

    public MyEntity_hotel(String hotelname, String address, String comment_scores, String comment_count, String xingji, String zhuangxiu) {
        this.hotelname = hotelname;
        this.address = address;
        this.comment_scores = comment_scores;
        this.comment_count = comment_count;
        this.xingji = xingji;
        this.zhuangxiu = zhuangxiu;
    }

    public String[] getPictures() {
        return pictures;
    }

    public void setPictures(String[] pictures) {
        this.pictures = pictures;
    }

    public MyEntity_hotel() {
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment_scores() {
        return comment_scores;
    }

    public void setComment_scores(String comment_scores) {
        this.comment_scores = comment_scores;
    }

    public String getComment_count() {
        return comment_count;
    }

    public void setComment_count(String comment_count) {
        this.comment_count = comment_count;
    }

    public String getXingji() {
        return xingji;
    }

    public void setXingji(String xingji) {
        this.xingji = xingji;
    }

    public String getZhuangxiu() {
        return zhuangxiu;
    }

    public void setZhuangxiu(String zhuangxiu) {
        this.zhuangxiu = zhuangxiu;
    }
}
