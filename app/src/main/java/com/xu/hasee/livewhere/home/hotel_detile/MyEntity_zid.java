package com.xu.hasee.livewhere.home.hotel_detile;

import java.util.List;

/**
 * Created by hasee on 2016/5/16.
 */
public class MyEntity_zid {
    private String zid;
    private List<MyEntity_list_item> list;

    public MyEntity_zid(String zid, List<MyEntity_list_item> list) {
        this.zid = zid;
        this.list = list;
    }

    public MyEntity_zid() {
    }

    public String getZid() {
        return zid;
    }

    public void setZid(String zid) {
        this.zid = zid;
    }

    public List<MyEntity_list_item> getList() {
        return list;
    }

    public void setList(List<MyEntity_list_item> list) {
        this.list = list;
    }
}
