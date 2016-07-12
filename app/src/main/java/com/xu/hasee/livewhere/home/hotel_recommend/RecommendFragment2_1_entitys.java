package com.xu.hasee.livewhere.home.hotel_recommend;

import java.util.List;

/**
 * Created by Administrator on 2016/5/18 0018.
 */
public class RecommendFragment2_1_entitys {
    private int hotelid;
    private String hotelname;
    private String content;
    private String title;
    private String pic;
    private String hotel_section_type_name;
    private List<Txt_pics_entitys> l;

    public RecommendFragment2_1_entitys() {
    }

    public RecommendFragment2_1_entitys(int hotelid, String hotelname, String content, String title, String pic, String hotel_section_type_name, List<Txt_pics_entitys> l) {
        this.hotelid = hotelid;
        this.hotelname = hotelname;
        this.content = content;
        this.title = title;
        this.pic = pic;
        this.hotel_section_type_name = hotel_section_type_name;
        this.l = l;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getHotel_section_type_name() {
        return hotel_section_type_name;
    }

    public void setHotel_section_type_name(String hotel_section_type_name) {
        this.hotel_section_type_name = hotel_section_type_name;
    }

    public List<Txt_pics_entitys> getL() {
        return l;
    }

    public void setL(List<Txt_pics_entitys> l) {
        this.l = l;
    }
}