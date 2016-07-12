package com.xu.hasee.livewhere.home.hotel_detile;

/**
 * Created by hasee on 2016/5/17.
 */
public class MyEntity_plans {
    private String planname;
    private String totalprice;
    private String jiangjin;

    public MyEntity_plans(String planname, String totalprice, String jiangjin) {
        this.planname = planname;
        this.totalprice = totalprice;
        this.jiangjin = jiangjin;
    }

    public MyEntity_plans() {
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
}
