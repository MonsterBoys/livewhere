package com.xu.hasee.livewhere.home.hotel_recommend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.xu.hasee.livewhere.R;

import java.util.List;

public class InformationRcommend_activitys extends AppCompatActivity {
    private ImageView iv;
    private RecyclerView lv;
    private List<String> list;
    private RadioGroup rg;
    private FragmentManager manager;
    private Fragment currentFragment;
    private FragmentTransaction transaction;
    private String cityid;
    private String cityname;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_rcommend);
        Intent intent = getIntent();
        cityid = intent.getStringExtra("cityid");
        cityname = intent.getStringExtra("cityname");
//        Bundle bundle1 = new Bundle();
//        bundle1.putString("cityid", cityid);
//        bundle1.putString("cityname", cityname);


        bundle = new Bundle();
        bundle.putString("cityid", cityid);
        bundle.putString("cityname", cityname);


        manager = getSupportFragmentManager();
        currentFragment = new RecommendFragment1();
        currentFragment.setArguments(bundle);
        manager.beginTransaction().add(R.id.ll, currentFragment).commit();


        rg = ((RadioGroup) findViewById(R.id.rg));
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Fragment fragment = null;
                switch (checkedId) {
                    case R.id.rrb1:
                        fragment = new RecommendFragment1();
                        fragment.setArguments(bundle);
                        break;
                    case R.id.rrb2:
                        fragment = new RecommendFragment2();
                        fragment.setArguments(bundle);
                        break;
                    case R.id.rrb3:
                        fragment = new RecommendFragment3();
                        break;
                }

                transaction = manager.beginTransaction();
                if (fragment.isAdded()) {
                    transaction.hide(currentFragment).show(fragment);
                } else {
                    transaction.hide(currentFragment).add(R.id.ll, fragment);
                }
                transaction.commit();
                currentFragment = fragment;
            }
        });

    }
}
