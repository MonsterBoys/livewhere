package com.xu.hasee.livewhere.home.hotel_recommend;

/**
 * Created by Administrator on 2016/5/18 0018.
 */
public class HaoRecommend_entitys {
    private int hotelid;
    private String hotelname;
    private String title;
    private String pic;

    public HaoRecommend_entitys() {

    }

    public HaoRecommend_entitys(int hotelid, String hotelname, String title, String pic) {
        this.hotelid = hotelid;
        this.hotelname = hotelname;
        this.title = title;
        this.pic = pic;
    }

    public int getHotelid() {
        return hotelid;
    }

    public void setHotelid(int hotelid) {
        this.hotelid = hotelid;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
