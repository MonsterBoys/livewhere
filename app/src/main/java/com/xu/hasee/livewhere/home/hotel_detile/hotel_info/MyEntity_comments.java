package com.xu.hasee.livewhere.home.hotel_detile.hotel_info;

import java.util.List;

/**
 * Created by hasee on 2016/5/16.
 */
public class MyEntity_comments  {
    private  String total;
    private String haopings;
    private String badcnts;
    private String midcnts;
    private String piccnts;
    private List<MyEntity_content> content;

    public MyEntity_comments(String total, String haopings, String badcnts, String midcnts, String piccnts, List<MyEntity_content> content) {
        this.total = total;
        this.haopings = haopings;
        this.badcnts = badcnts;
        this.midcnts = midcnts;
        this.piccnts = piccnts;
        this.content = content;
    }

    public MyEntity_comments() {
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getHaopings() {
        return haopings;
    }

    public void setHaopings(String haopings) {
        this.haopings = haopings;
    }

    public String getBadcnts() {
        return badcnts;
    }

    public void setBadcnts(String badcnts) {
        this.badcnts = badcnts;
    }

    public String getMidcnts() {
        return midcnts;
    }

    public void setMidcnts(String midcnts) {
        this.midcnts = midcnts;
    }

    public String getPiccnts() {
        return piccnts;
    }

    public void setPiccnts(String piccnts) {
        this.piccnts = piccnts;
    }

    public List<MyEntity_content> getContent() {
        return content;
    }

    public void setContent(List<MyEntity_content> content) {
        this.content = content;
    }
}
