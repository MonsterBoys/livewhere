package com.xu.hasee.livewhere.home.hotel_recommend;

/**
 * Created by Administrator on 2016/5/19 0019.
 */
public class RF1Bottoms_entitys {
    private String cbd_name;
    private float choosehere;
    private String descption;
    private String picture;

    public RF1Bottoms_entitys() {
    }

    public RF1Bottoms_entitys(String cbd_name, float choosehere, String descption, String picture) {
        this.cbd_name = cbd_name;
        this.choosehere = choosehere;
        this.descption = descption;
        this.picture = picture;
    }

    public String getCbd_name() {
        return cbd_name;
    }

    public void setCbd_name(String cbd_name) {
        this.cbd_name = cbd_name;
    }

    public float getChoosehere() {
        return choosehere;
    }

    public void setChoosehere(float choosehere) {
        this.choosehere = choosehere;
    }

    public String getDescption() {
        return descption;
    }

    public void setDescption(String descption) {
        this.descption = descption;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
