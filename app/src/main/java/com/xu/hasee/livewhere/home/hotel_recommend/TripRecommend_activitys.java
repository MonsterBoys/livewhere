package com.xu.hasee.livewhere.home.hotel_recommend;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.xu.hasee.livewhere.JsonUtis;
import com.xu.hasee.livewhere.NetUtils;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;

import java.util.List;

public class TripRecommend_activitys extends AppCompatActivity {
    private List<Recommend_entitys> list;
    private ListView lv_recommend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_recommend);
        initView();
        MySyncTask mySyncTask = new MySyncTask();
        mySyncTask.execute(UrlPath.TRIPRECOMMENDPATH);
    }


    private void initView() {
        lv_recommend = ((ListView) findViewById(R.id.lv_recommend));
    }

    public void iv_recommend_back(View view) {
        finish();
    }

    class MySyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            list = JsonUtis.PaseJsonRecommend(s);
            Recommend_adapters adapters = new Recommend_adapters(list, TripRecommend_activitys.this);
            lv_recommend.setAdapter(adapters);
            lv_recommend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(TripRecommend_activitys.this, InformationRcommend_activitys.class);
                    Recommend_entitys recommend_entitys = list.get(position);
                    String cityid = recommend_entitys.getCityid();
                    String cityname = recommend_entitys.getTv_recomment1();
                    intent.putExtra("cityid", cityid);
                    intent.putExtra("cityname", cityname);
                    startActivity(intent);
                }
            });
        }

        @Override
        protected String doInBackground(String... params) {
            return NetUtils.getData(params[0]);
        }
    }
}