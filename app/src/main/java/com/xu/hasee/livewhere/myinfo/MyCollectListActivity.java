package com.xu.hasee.livewhere.myinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.home.HotelCollectionActivity;

public class MyCollectListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collect_list);
        ImageView mycollect_back = (ImageView) findViewById(R.id.mycollect_back);
        mycollect_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView myhotel_collections = (TextView) findViewById(R.id.myhotel_collections);
        myhotel_collections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HotelCollectionintent = new Intent(MyCollectListActivity.this, HotelCollectionActivity.class);
                startActivity(HotelCollectionintent);
            }
        });

        TextView hour_room_collections = (TextView) findViewById(R.id.hour_room_collections);
        hour_room_collections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        TextView strategy_collections = (TextView) findViewById(R.id.strategy_collections);
        strategy_collections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
