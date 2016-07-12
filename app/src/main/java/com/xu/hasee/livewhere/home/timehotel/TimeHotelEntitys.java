package com.xu.hasee.livewhere.home.timehotel;

/**
 * Created by Administrator on 2016/5/20 0020.
 */
public class TimeHotelEntitys {
    private String hid;
    private String pic153;
    private String hotelname;
    private String comment_scores;
    private int comment_count;
    private String xingji;
    private String price;
    private String unit;
    private  String esdname;


    public TimeHotelEntitys(String hid, String pic153, String hotelname, String comment_scores, int comment_count, String xingji, String price, String unit,String esdname) {
        this.hid = hid;
        this.pic153 = pic153;
        this.hotelname = hotelname;
        this.comment_scores = comment_scores;
        this.comment_count = comment_count;
        this.xingji = xingji;
        this.price = price;
        this.unit = unit;
        this.esdname=esdname;
    }

    public TimeHotelEntitys(String pic153, String hotelname, String comment_scores, int comment_count, String xingji, String price,String esdname) {
        this.pic153 = pic153;
        this.hotelname = hotelname;
        this.comment_scores = comment_scores;
        this.comment_count = comment_count;
        this.xingji = xingji;
        this.price = price;
        this.esdname=esdname;
    }

    public String getEsdname() {
        return esdname;
    }

    public void setEsdname(String esdname) {
        this.esdname = esdname;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getPic153() {
        return pic153;
    }

    public void setPic153(String pic153) {
        this.pic153 = pic153;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getComment_scores() {
        return comment_scores;
    }

    public void setComment_scores(String comment_scores) {
        this.comment_scores = comment_scores;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getXingji() {
        return xingji;
    }

    public void setXingji(String xingji) {
        this.xingji = xingji;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
