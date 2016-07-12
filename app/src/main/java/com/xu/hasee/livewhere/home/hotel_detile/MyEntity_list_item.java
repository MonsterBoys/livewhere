package com.xu.hasee.livewhere.home.hotel_detile;

import java.util.List;

/**
 * Created by hasee on 2016/5/14.
 */
public class MyEntity_list_item {
    private String title;
    private String bed;
    private String area;
    private String adsl;
    private String floor;
    private String rid;
    private String spic;
    private String planname;
    private String totalprice;
    private String jiangjin;


    public MyEntity_list_item() {
    }

    public MyEntity_list_item(String title, String bed, String area, String adsl, String floor, String rid, String spic, String planname, String totalprice, String jiangjin) {
        this.title = title;
        this.bed = bed;
        this.area = area;
        this.adsl = adsl;
        this.floor = floor;
        this.rid = rid;
        this.spic = spic;
        this.planname = planname;
        this.totalprice = totalprice;
        this.jiangjin = jiangjin;
    }

    public String getPlanname() {
        return planname;
    }

    public void setPlanname(String planname) {
        this.planname = planname;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getJiangjin() {
        return jiangjin;
    }

    public void setJiangjin(String jiangjin) {
        this.jiangjin = jiangjin;
    }

    public String getSpic() {
        return spic;
    }

    public void setSpic(String spic) {
        this.spic = spic;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getAdsl() {
        return adsl;
    }

    public void setAdsl(String adsl) {
        this.adsl = adsl;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
