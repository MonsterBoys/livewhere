package com.xu.hasee.livewhere.home.hotel_detile.hotel_info;

import java.util.List;

/**
 * Created by hasee on 2016/5/17.
 */
public class MyEntity_hotelintroinfo {
    private String[] base;
    private String hotelservice;
    private String content;
    private List<MyEntity_traffic> list;
    public MyEntity_hotelintroinfo() {
    }

    public MyEntity_hotelintroinfo(String[] base, String hotelservice, String content, List<MyEntity_traffic> list) {
        this.base = base;
        this.hotelservice = hotelservice;
        this.content = content;
        this.list = list;
    }

    public String[] getBase() {
        return base;
    }

    public List<MyEntity_traffic> getList() {
        return list;
    }

    public void setList(List<MyEntity_traffic> list) {
        this.list = list;
    }

    public void setBase(String[] base) {
        this.base = base;
    }

    public String getHotelservice() {
        return hotelservice;
    }

    public void setHotelservice(String hotelservice) {
        this.hotelservice = hotelservice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
