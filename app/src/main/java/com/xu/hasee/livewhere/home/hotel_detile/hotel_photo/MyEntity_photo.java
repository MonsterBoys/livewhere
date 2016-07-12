package com.xu.hasee.livewhere.home.hotel_detile.hotel_photo;

/**
 * Created by hasee on 2016/5/18.
 */
public class MyEntity_photo {
    private String title;
    private String picsmall;

    public MyEntity_photo() {
    }

    public MyEntity_photo(String title, String picsmall) {
        this.title = title;
        this.picsmall = picsmall;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicsmall() {
        return picsmall;
    }

    public void setPicsmall(String picsmall) {
        this.picsmall = picsmall;
    }
}
