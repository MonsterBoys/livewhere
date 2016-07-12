package com.xu.hasee.livewhere.home.hotel_detile.hotel_photo;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.home.hotel_detile.hotel_info.HotelInfoActivity;

import java.util.ArrayList;
import java.util.List;

public class HotelPhotoActivity extends AppCompatActivity {

    private ImageView photo_back;
    private RadioGroup radioGroup;
    private List<Fragment> fragments;
    private ViewPager vp;
    private List<RadioButton> radioButtons;
    private String hotelid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_photo_main);
        photo_back = ((ImageView) findViewById(R.id.photo_back));
        radioGroup = ((RadioGroup) findViewById(R.id.rdg_title));
        vp = ((ViewPager) findViewById(R.id.vp));
        Intent intent = getIntent();
        hotelid = intent.getStringExtra("hotelid");
        fragments = new ArrayList<>();
        initFramnets();
        photo_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HotelPhotoActivity.this.finish();
            }
        });
    }
    private void initFramnets() {
        radioButtons = new ArrayList<>();
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
            radioButtons.add(radioButton);
        }
        Hotel_pro_Fragment hotel_pro_fragment = new Hotel_pro_Fragment();
        CustomerFragment customerFragment = new CustomerFragment();
        Bundle extras=new Bundle();
        extras.putString("hotelid",hotelid);
        hotel_pro_fragment.setArguments(extras);
        customerFragment.setArguments(extras);
        fragments.add(hotel_pro_fragment);
        fragments.add(customerFragment);
        MyAdapter_photo_frag adapter = new MyAdapter_photo_frag(getSupportFragmentManager(), fragments);
        radioButtons.get(0).setChecked(true);
        vp.setOffscreenPageLimit(2);
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.hotel_pro:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.customer_pro:
                        vp.setCurrentItem(1);
                        break;
                }
            }
        });
    }
}
