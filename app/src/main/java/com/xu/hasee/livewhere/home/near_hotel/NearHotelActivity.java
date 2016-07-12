package com.xu.hasee.livewhere.home.near_hotel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.xu.hasee.livewhere.JsonUtis;
import com.xu.hasee.livewhere.NetUtils;
import com.xu.hasee.livewhere.OkHttpUtils;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;
import com.xu.hasee.livewhere.home.hotel_detile.HoltelDetileActivity;
import com.xu.hasee.livewhere.home.near_hotel.adapter.NearHotelAdapter;
import com.xu.hasee.livewhere.home.near_hotel.entity.NearItem;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class NearHotelActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView image_back;

    private NearItem nearItem;
    private Callback callback;
    private List<NearItem>list;
    private int currentpager=1;
    private NearHotelAdapter adapter;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    list= (List<NearItem>) msg.obj;
                    adapter = new NearHotelAdapter(getApplication(),list);
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    srl.setRefreshing(false);
            }
        }
    };


    private String tm1;
    private String tm2;
    private SwipeRefreshLayout srl;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_hotel);


        tm1 = NetUtils.getTime()[0];
        tm2 = NetUtils.getTime()[1];




        initView();


        initNetork();

        updateData();


       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ids=list.get(position).getId();
                Intent intent=new Intent(NearHotelActivity.this, HoltelDetileActivity.class);
                intent.putExtra("ids",ids);
                startActivity(intent);
            }
        });

    }

    private void updateData() {
        srl.setColorSchemeColors(Color.BLUE,Color.GREEN,Color.RED);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        OkHttpUtils.getData(String.format(UrlPath.near_hotel_path,++currentpager,tm2,tm1),callback);

                    }
                },3000);
            }
        });
    }

    private void initNetork() {
        callback = new Callback(){

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                         if (response.isSuccessful()){
                             String path=response.body().string();
                             parsejson(path);
                         }
            }
        };
        OkHttpUtils.getData(String.format(UrlPath.near_hotel_path,currentpager,tm2,tm1),callback);
    }

    private void parsejson(String jsonpath) {
        list= JsonUtis.ParseNearHotelItem(jsonpath);

        Message message=new Message();
        message.obj=list;
        handler.sendMessage(message);
    }



    private void initView() {
        srl = ((SwipeRefreshLayout) findViewById(R.id.srl));
        listView = ((ListView) findViewById(R.id.listView));
        image_back = ((ImageView) findViewById(R.id.go_back));

        image_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.go_back:
               this.finish();
               break;
       }
    }
}
