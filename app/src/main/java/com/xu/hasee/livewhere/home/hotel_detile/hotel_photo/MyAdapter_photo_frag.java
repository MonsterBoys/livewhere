package com.xu.hasee.livewhere.home.hotel_detile.hotel_photo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by hasee on 2016/5/18.
 */
public class MyAdapter_photo_frag extends FragmentPagerAdapter {

    private List<Fragment> list;

    public MyAdapter_photo_frag(FragmentManager fm,  List<Fragment> list) {
        super(fm);
        this.list = list;
    }
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
