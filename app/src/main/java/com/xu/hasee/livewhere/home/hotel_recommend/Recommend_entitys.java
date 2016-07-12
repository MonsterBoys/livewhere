package com.xu.hasee.livewhere.home.hotel_recommend;

/**
 * Created by Administrator on 2016/5/11 0011.
 */
public class Recommend_entitys {
    private String cityid;
    private String iv_recommend_listview;
    private String tv_recomment1;
    private String tv_recomment2;

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getIv_recommend_listview() {
        return iv_recommend_listview;
    }

    public void setIv_recommend_listview(String iv_recommend_listview) {
        this.iv_recommend_listview = iv_recommend_listview;
    }

    public String getTv_recomment1() {
        return tv_recomment1;
    }

    public void setTv_recomment1(String tv_recomment1) {
        this.tv_recomment1 = tv_recomment1;
    }

    public String getTv_recomment2() {
        return tv_recomment2;
    }

    public void setTv_recomment2(String tv_recomment2) {
        this.tv_recomment2 = tv_recomment2;
    }

    public Recommend_entitys() {
    }

    public Recommend_entitys(String cityid, String iv_recommend_listview, String tv_recomment1, String tv_recomment2) {
        this.cityid = cityid;
        this.iv_recommend_listview = iv_recommend_listview;
        this.tv_recomment1 = tv_recomment1;
        this.tv_recomment2 = tv_recomment2;
    }
}