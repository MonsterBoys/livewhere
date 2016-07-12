package com.xu.hasee.livewhere.home;

/**
 * Created by hasee on 2016/5/12.
 */
public class MyEntity_hotelInfo {
    private String hotelname;
    private String comment_scores;
    private String comment_count;
    private String xingji;
    private String esdname;
    private String min_jiage;
    private String pic153;
    private String id;
    public MyEntity_hotelInfo(String pic153, String min_jiage, String hotelname, String comment_scores, String comment_count, String xingji, String esdname,String id) {
        this.pic153 = pic153;
        this.min_jiage = min_jiage;
        this.hotelname = hotelname;
        this.comment_scores = comment_scores;
        this.comment_count = comment_count;
        this.xingji = xingji;
        this.esdname = esdname;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MyEntity_hotelInfo() {
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

    public String getEsdname() {
        return esdname;
    }

    public void setEsdname(String esdname) {
        this.esdname = esdname;
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
}
