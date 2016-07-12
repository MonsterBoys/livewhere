package com.xu.hasee.livewhere.home;

/**
 * Created by hasee on 2016/5/12.
 */
public class MyEntity_hotelname {
    private String hotelname;
    private String hotelid;

    public MyEntity_hotelname(String hotelname, String hotelid) {
        this.hotelname = hotelname;
        this.hotelid = hotelid;
    }

    public MyEntity_hotelname() {
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }
}
