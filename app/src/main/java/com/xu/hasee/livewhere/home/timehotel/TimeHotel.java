package com.xu.hasee.livewhere.home.timehotel;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.xu.hasee.livewhere.JsonUtis;
import com.xu.hasee.livewhere.NetUtils;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;
import com.xu.hasee.livewhere.home.hotel_detile.hotel_photo.RefreshLayout;

import java.util.List;

public class TimeHotel extends AppCompatActivity {
    private int firstVisiableItem;
    private int firstVisiableItemTop;
    private ListView lv;
    private List<TimeHotelEntitys> list;
    private ImageView back;
    private RefreshLayout rf;
    private int currentPage = 1;
    private TimeHotelAdapters adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_hotel);
        rf = ((RefreshLayout) findViewById(R.id.rf));
        lv = ((ListView) findViewById(R.id.lv));
        back = ((ImageView) findViewById(R.id.back));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        new MyTask().execute(String.format(UrlPath.timehotel, currentPage));
        rf.setColorSchemeResources(R.color.mycoloryellow, R.color.mycolorgray, R.color.mycolorgreen);
        rf.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                rf.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new MyTask().execute(String.format(UrlPath.timehotel, ++currentPage));
                        adapter.notifyDataSetChanged();
                        rf.setRefreshing(false);
                    }
                }, 3000);
            }
        });
    }

    class MyTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            return NetUtils.getData(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            list = JsonUtis.ParseJsonTimeHotel(s);
            adapter = new TimeHotelAdapters(TimeHotel.this, list);
            lv.setAdapter(adapter);
          //  lv.setSelectionFromTop(firstVisiableItem,firstVisiableItemTop);
          //  lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            //    @Override
             //   public void onScrollStateChanged(AbsListView view, int scrollState) {

            //    }

           //     @Override
            //    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            //        if(firstVisibleItem + visibleItemCount == totalItemCount){
             //           firstVisiableItem = lv.getFirstVisiblePosition();
            //            firstVisiableItemTop = lv.getChildAt(0).getTop();
            //            new MyTask().execute(String.format(UrlPath.timehotel, (++currentPage)));
             //           adapter.notifyDataSetChanged();
             //           lv.requestLayout();
            //        }
           //     }
           // });



            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TimeHotelEntitys timeHotelEntitys = list.get(position);
                    String hid = timeHotelEntitys.getHid();
                    Intent intent = new Intent(TimeHotel.this, TimeHotelInfo.class);
                    intent.putExtra("ids", hid);
                    startActivity(intent);
                }
            });
        }
    }
}
