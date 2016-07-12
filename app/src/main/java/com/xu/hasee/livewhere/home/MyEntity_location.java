package com.xu.hasee.livewhere.home;

/**
 * Created by hasee on 2016/5/12.
 */
public class MyEntity_location {
    private String address;
    private String cname;
    private String ecityid;
    private String short_address;
    private String zcityid;

    public MyEntity_location() {
    }

    public MyEntity_location(String address, String zcityid, String ecityid, String short_address, String cname) {
        this.address = address;
        this.zcityid = zcityid;
        this.ecityid = ecityid;
        this.short_address = short_address;
        this.cname = cname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEcityid() {
        return ecityid;
    }

    public void setEcityid(String ecityid) {
        this.ecityid = ecityid;
    }

    public String getShort_address() {
        return short_address;
    }

    public void setShort_address(String short_address) {
        this.short_address = short_address;
    }

    public String getZcityid() {
        return zcityid;
    }

    public void setZcityid(String zcityid) {
        this.zcityid = zcityid;
    }
}
