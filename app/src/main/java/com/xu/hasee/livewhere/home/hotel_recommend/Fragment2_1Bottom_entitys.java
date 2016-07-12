package com.xu.hasee.livewhere.home.hotel_recommend;

/**
 * Created by Administrator on 2016/5/19 0019.
 */
public class Fragment2_1Bottom_entitys {
    private String hotel_section_type_name;
    private String pics;

    public Fragment2_1Bottom_entitys(String hotel_section_type_name, String pics) {
        this.hotel_section_type_name = hotel_section_type_name;
        this.pics = pics;
    }

    public String getHotel_section_type_name() {
        return hotel_section_type_name;
    }

    public void setHotel_section_type_name(String hotel_section_type_name) {
        this.hotel_section_type_name = hotel_section_type_name;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }
}
