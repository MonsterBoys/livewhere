package com.xu.hasee.livewhere.home.hotel_detile.hotel_info;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xu.hasee.livewhere.R;

import java.util.ArrayList;
import java.util.List;

public class HotelInfoActivity extends AppCompatActivity {

    private ImageView info_back;
    private RadioGroup info_rdg;
    private List<Fragment> fragments;
    private RadioButton hotel_commend;
    private ViewPager viewPager;
    private List<RadioButton> radioButtons;
    private String hotelid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_info);
        info_back = ((ImageView) findViewById(R.id.info_back));
        info_rdg = ((RadioGroup) findViewById(R.id.info_rdg));
        viewPager = ((ViewPager) findViewById(R.id.viewpager));
        Intent intent = getIntent();
        hotelid = intent.getStringExtra("hotelid");

        initFraments();
        hotelinfo_viewpager_adapter adapter = new hotelinfo_viewpager_adapter(getSupportFragmentManager(), fragments);
        radioButtons.get(0).setChecked(true);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);
        info_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HotelInfoActivity.this.finish();
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioButtons.get(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        info_rdg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.hotel_commend:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.hotel_nearby:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.hotel_info:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });

    }

    private void initFraments() {
        radioButtons = new ArrayList<>();
        for (int i = 0; i < info_rdg.getChildCount(); i++) {
            RadioButton radioButton = ((RadioButton) info_rdg.getChildAt(i));
            radioButtons.add(radioButton);
        }
        fragments = new ArrayList<>();
        Bundle extras = new Bundle();
        HotelCommentFragment hotelCommentFragment = new HotelCommentFragment();
        HotelNearbyFragment hotelNearbyFragment = new HotelNearbyFragment();
        HotelInfoFragment hotelInfoFragment = new HotelInfoFragment();
        extras.putString("hotelid", hotelid);
        hotelCommentFragment.setArguments(extras);
        hotelNearbyFragment.setArguments(extras);
        hotelInfoFragment.setArguments(extras);
        fragments.add(hotelCommentFragment);
        fragments.add(hotelNearbyFragment);
        fragments.add(hotelInfoFragment);
    }


}
