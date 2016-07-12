package com.xu.hasee.livewhere.home;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.home.calltaxi.TaxiActivity;
import com.xu.hasee.livewhere.home.hotel_recommend.TripRecommend_activitys;
import com.xu.hasee.livewhere.home.small_strategy.SmallStrategy;
import com.xu.hasee.livewhere.home.near_hotel.NearHotelActivity;
import com.xu.hasee.livewhere.home.timehotel.TimeHotel;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private List<ImageView> imgs;
    private List<Integer>  imgsId;
    private ViewPager viewPager;
    private LinearLayout dot_layout;
    private int currentPosition;
    private View view;
    private ImageView order_holtel;
    private ImageView nearby_holtel;
    private ImageView order_car;
    private ImageView strategy;
    private ImageView hour_room;
    private ImageView recommend;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, null);
        initFindViewId();
        initViewPager();

        ViewPagerAdapter_home adapter_home = new ViewPagerAdapter_home(getActivity(), imgsId);
        viewPager.setAdapter(adapter_home);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                dot_layout.getChildAt(currentPosition).setEnabled(true);
                dot_layout.getChildAt(position % imgsId.size()).setEnabled(false);
                currentPosition = position % imgsId.size();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    public void initFindViewId() {
        viewPager = ((ViewPager) view.findViewById(R.id.vp));
        dot_layout = ((LinearLayout) view.findViewById(R.id.dot_layout));
        order_holtel = ((ImageView) view.findViewById(R.id.order_holtel));
        nearby_holtel = ((ImageView) view.findViewById(R.id.nearby_holtel));
        order_car = ((ImageView) view.findViewById(R.id.order_car));
        strategy = ((ImageView) view.findViewById(R.id.strategy));
        hour_room = ((ImageView) view.findViewById(R.id.hour_room));
        recommend = ((ImageView) view.findViewById(R.id.recommend));
        order_holtel.setOnClickListener(this);
        nearby_holtel.setOnClickListener(this);
        order_car.setOnClickListener(this);
        strategy.setOnClickListener(this);
        hour_room.setOnClickListener(this);
        recommend.setOnClickListener(this);
//        viewPager.setOffscreenPageLimit(2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.order_holtel:
                Intent intent=new Intent(getActivity(),ChinaActivity.class);
                startActivity(intent);
                break;
            case R.id.nearby_holtel:
                Intent intent_near=new Intent(getActivity(), NearHotelActivity.class);
                startActivity(intent_near);
                break;
            case R.id.order_car:
                Intent intent_car=new Intent(getActivity(), TaxiActivity.class);
                startActivity(intent_car);
                break;
            case R.id.strategy:
                Intent intent_strategy = new Intent(getActivity(), SmallStrategy.class);
                startActivity(intent_strategy);
                break;
            case R.id.hour_room:
                Intent intent_hour_room = new Intent(getActivity(), TimeHotel.class);
                startActivity(intent_hour_room);
                break;
            case R.id.recommend:
                Intent intent_recommend = new Intent(getActivity(), TripRecommend_activitys.class);
                startActivity(intent_recommend);
                break;
        }
    }

    private void initViewPager() {
       /* imgs = new ArrayList<>();*/
        imgsId=new ArrayList<>();
        for(int i=0;i<3;i++){
            imgsId.add(R.drawable.home_beanmorenoff);
        }
        for (int i = 0; i < imgsId.size(); i++) {
            final ImageView dot_img = new ImageView(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            params.leftMargin = 10;
            dot_img.setAdjustViewBounds(true);
            dot_img.setLayoutParams(params);
            dot_img.setBackgroundResource(R.drawable.dot_selector);
            dot_img.setTag(i);
            dot_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = (int) v.getTag();
                    viewPager.setCurrentItem(position, true);
                }
            });
            dot_layout.addView(dot_img);
            dot_img.setEnabled(true);
        }
        dot_layout.getChildAt(0).setEnabled(false);
    }


}
