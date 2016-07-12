package com.xu.hasee.livewhere.home.hotel_recommend;

/**
 * Created by Administrator on 2016/5/19 0019.
 */
public class RF1Top_entitys {
    private String picture;
    private String ctiyname;
    private long ctrip_dp_num;
    private String descption;

    public RF1Top_entitys() {
    }

    public RF1Top_entitys(String picture, String ctiyname, long ctrip_dp_num, String descption) {
        this.picture = picture;
        this.ctiyname = ctiyname;
        this.ctrip_dp_num = ctrip_dp_num;
        this.descption = descption;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCtiyname() {
        return ctiyname;
    }

    public void setCtiyname(String ctiyname) {
        this.ctiyname = ctiyname;
    }

    public long getCtrip_dp_num() {
        return ctrip_dp_num;
    }

    public void setCtrip_dp_num(long ctrip_dp_num) {
        this.ctrip_dp_num = ctrip_dp_num;
    }

    public String getDescption() {
        return descption;
    }

    public void setDescption(String descption) {
        this.descption = descption;
    }
}

