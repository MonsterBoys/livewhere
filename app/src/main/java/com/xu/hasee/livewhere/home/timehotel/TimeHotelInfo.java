package com.xu.hasee.livewhere.home.timehotel;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.xu.hasee.livewhere.JsonUtis;
import com.xu.hasee.livewhere.NetUtils;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;

import java.util.List;

public class TimeHotelInfo extends AppCompatActivity {

    private GridView gv;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_hotel_info);
        back = ((ImageView) findViewById(R.id.back));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        gv = ((GridView) findViewById(R.id.gv));
        Intent intent = getIntent();
        String ids = intent.getStringExtra("ids");
        new MyTask().execute(String.format(UrlPath.timehotelinfo, ids));
    }

    class MyTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            return NetUtils.getData(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            List<TimeHotelInfoEntitys> list = JsonUtis.ParseJsonTimeHotelInfo(s);
            TimeHotelInfoAdapters adapters = new TimeHotelInfoAdapters(TimeHotelInfo.this, list);
            gv.setAdapter(adapters);
        }
    }
}
