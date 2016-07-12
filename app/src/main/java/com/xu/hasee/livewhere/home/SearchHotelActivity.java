package com.xu.hasee.livewhere.home;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.xu.hasee.livewhere.JsonUtis;
import com.xu.hasee.livewhere.NetUtils;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;

import java.util.ArrayList;
import java.util.List;

public class SearchHotelActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView search_back;
    private TextView search_title;
    private TextView search_edt;
    private RadioGroup rdg_title;
    private ViewPager vp;
    private RadioGroup rdg_select;
    private List<Fragment> fragments;
    private List<RadioButton> radioButtons;
    private List<MyEntity_hotelInfo> list;
    private ListView listView;
    /* private String tm1;
     private String tm2;*/
    private ViewPagerAdapter_hotel adapter;
    private String cityid;
    private String hotelid;
    private ImageView search_btn_abstract;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_hotel);
        Intent intent = getIntent();
        cityid = intent.getStringExtra("cityid");
        hotelid = intent.getStringExtra("hotelid");
        String hotel_name = intent.getStringExtra("hotel_name");
        fragments = new ArrayList<>();
        initId();
        initFramnets();
        if(hotel_name!=null){
            search_edt.setText(hotel_name);
        }else {
            search_edt.setText("");
        }
    }

    private void initFramnets() {

        radioButtons = new ArrayList<>();
        for (int i = 0; i < rdg_title.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) rdg_title.getChildAt(i);
            radioButtons.add(radioButton);
        }
        Bundle extras = new Bundle();
        extras.putString("cityid", cityid);
        Log.d("xyc", "initFramnets: " + hotelid);
        extras.putString("hotelid", hotelid);
        HotelFragment hotelFragment = new HotelFragment();
        Hotel2Fragment hotel2Fragment = new Hotel2Fragment();
        Hotel3Fragment hotel3Fragment = new Hotel3Fragment();
        hotelFragment.setArguments(extras);
        hotel2Fragment.setArguments(extras);
        hotel3Fragment.setArguments(extras);
        fragments.add(hotelFragment);
        fragments.add(hotel2Fragment);
        fragments.add(hotel3Fragment);
        adapter = new ViewPagerAdapter_hotel(getSupportFragmentManager(), fragments);
        radioButtons.get(0).setChecked(true);
        vp.setOffscreenPageLimit(2);
        vp.setAdapter(adapter);
    }

    private void initId() {
        search_back = ((ImageView) findViewById(R.id.search_back));
        search_title = ((TextView) findViewById(R.id.search_title));
        search_edt = ((TextView) findViewById(R.id.search_edt));
        rdg_title = ((RadioGroup) findViewById(R.id.rdg_title));
        vp = ((ViewPager) findViewById(R.id.vp));
        search_btn_abstract = ((ImageView) findViewById(R.id.search_btn_abstract));
        // rdg_select = ((RadioGroup) findViewById(R.id.rdg_select));
        search_back.setOnClickListener(this);
        search_title.setOnClickListener(this);
        search_edt.setOnClickListener(this);
        rdg_title.setOnClickListener(this);
        search_btn_abstract.setOnClickListener(this);
        vp.setOnClickListener(this);
        //  rdg_select.setOnClickListener(this);

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
        rdg_title.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.all_hotel:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.fast_hotel:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.now_hotel:
                        vp.setCurrentItem(2);
                        break;

                }
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.search_back:
                this.finish();
                break;
            case R.id.search_edt:
                Intent intent = new Intent(SearchHotelActivity.this, AbstractActivity.class);
                intent.putExtra("flag","search");
                intent.putExtra("cityid", cityid);
                startActivityForResult(intent, 2);
                break;
            case R.id.search_btn_abstract:
                // Log.d("xyc", "onCheckedChanged: "+hotelid);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2 && resultCode == 0) {
            if (data != null) {
                String hotel_name = data.getStringExtra("hotel_name");
                hotelid = data.getStringExtra("hotelid");
                Log.d("xyc", "onActivityResult: " + hotelid);
                search_edt.setText(hotel_name);
            } else {
                search_edt.setText("");
            }
        }
    }

}
