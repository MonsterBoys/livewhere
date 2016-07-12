package com.xu.hasee.livewhere.home.hotel_recommend;

/**
 * Created by Administrator on 2016/5/19 0019.
 */
public class Fragment2_1_entitys {
    private String hotelname;
    private String pic;
    private String content;

    public Fragment2_1_entitys(String hotelname, String pic, String content) {
        this.hotelname = hotelname;
        this.pic = pic;
        this.content = content;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
