package com.xu.hasee.livewhere.home.hotel_detile.hotel_info;

/**
 * Created by hasee on 2016/5/16.
 */
public class MyEntity_content {
    private String time;
    private String username;
    private String content;

    public MyEntity_content(String time, String username, String content) {
        this.time = time;
        this.username = username;
        this.content = content;
    }

    public MyEntity_content() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
