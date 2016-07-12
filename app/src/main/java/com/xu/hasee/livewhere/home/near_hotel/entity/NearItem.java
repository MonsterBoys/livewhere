package com.xu.hasee.livewhere.home.near_hotel.entity;

/**
 * Created by Administrator on 2016/5/19.
 */
public class NearItem {

    private String pic153;
    private String hotelname;
    private String xingji;
    private String esdname;
    private String comment_count;
    private String comment_scores;
    private String min_jiage;
    private String juli;
    private String id;

    public NearItem() {
    }

    public NearItem(String comment_count, String comment_scores, String esdname, String hotelname, String id, String juli, String min_jiage, String pic153, String xingji) {
        this.comment_count = comment_count;
        this.comment_scores = comment_scores;
        this.esdname = esdname;
        this.hotelname = hotelname;
        this.id = id;
        this.juli = juli;
        this.min_jiage = min_jiage;
        this.pic153 = pic153;
        this.xingji = xingji;
    }

    public String getComment_count() {
        return comment_count;
    }

    public void setComment_count(String comment_count) {
        this.comment_count = comment_count;
    }

    public String getComment_scores() {
        return comment_scores;
    }

    public void setComment_scores(String comment_scores) {
        this.comment_scores = comment_scores;
    }

    public String getEsdname() {
        return esdname;
    }

    public void setEsdname(String esdname) {
        this.esdname = esdname;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJuli() {
        return juli;
    }

    public void setJuli(String juli) {
        this.juli = juli;
    }

    public String getMin_jiage() {
        return min_jiage;
    }

    public void setMin_jiage(String min_jiage) {
        this.min_jiage = min_jiage;
    }

    public String getPic153() {
        return pic153;
    }

    public void setPic153(String pic153) {
        this.pic153 = pic153;
    }

    public String getXingji() {
        return xingji;
    }

    public void setXingji(String xingji) {
        this.xingji = xingji;
    }
}
