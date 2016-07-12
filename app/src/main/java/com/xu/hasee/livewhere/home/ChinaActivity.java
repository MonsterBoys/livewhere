package com.xu.hasee.livewhere.home;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xu.hasee.livewhere.JsonUtis;
import com.xu.hasee.livewhere.NetUtils;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;
import com.xu.hasee.livewhere.home.hotel_detile.hotel_info.HotelInfoActivity;
import com.xu.hasee.livewhere.home.timehotel.TimeHotel;

import java.util.List;

public class ChinaActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView my_location;

    private TextView location_tv;
    private ImageView back;
    private TextView current_date;
    private TextView hotel_name;
    private TextView hotel_price;
    private TextView hotel_collections;
    private Button search_btn;
    private TextView always_holtel;
    private List<MyEntity_location> list;
    private MyEntity_location myEntity_location;
    private SQLiteDatabase db;
    private String hotelnames;
    private ImageView call;
    private String hotelid;
    private String hotel_names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china);
        initViewId();
        current_date.setText(NetUtils.getTime()[0]);
        MyTaskForLocation myTaskForLocation = new MyTaskForLocation();
        myTaskForLocation.execute(UrlPath.location_path);

    }

    public void initViewId() {
        my_location = ((ImageView) findViewById(R.id.my_location));
        call = ((ImageView) findViewById(R.id.call));
        location_tv = ((TextView) findViewById(R.id.location_tv));
        back = ((ImageView) findViewById(R.id.back));
        current_date = (TextView) findViewById(R.id.current_date);
        hotel_name = ((TextView) findViewById(R.id.hotel_name));
        hotel_price = ((TextView) findViewById(R.id.hotel_price));
        search_btn = ((Button) findViewById(R.id.search_btn));
        hotel_collections = ((TextView) findViewById(R.id.holtel_collections));
        always_holtel = ((TextView) findViewById(R.id.always_holtel));
        back.setOnClickListener(this);
        my_location.setOnClickListener(this);
        call.setOnClickListener(this);
        hotel_name.setOnClickListener(this);
        hotel_price.setOnClickListener(this);
        search_btn.setOnClickListener(this);
        hotel_collections.setOnClickListener(this);
        always_holtel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       /*
           String cityid = myEntity_location.getEcityid();*/
        switch (v.getId()) {
            case R.id.my_location:
                if(list!=null)
                {
                    location_tv.setText(myEntity_location.getAddress());
                }else {
                    Toast.makeText(ChinaActivity.this, "网络连接异常！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.back:
                this.finish();
                break;
            case R.id.call:
                Intent intent3=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"10086"));
                intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent3);
                break;
            case R.id.hotel_name:
                if(list!=null){
                    String cityid = myEntity_location.getEcityid();
                    Intent intent = new Intent(this, AbstractActivity.class);
                    intent.putExtra("cityid", cityid);
                    startActivityForResult(intent, 1);
                }else {
                    Toast.makeText(ChinaActivity.this, "网络连接异常！", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.hotel_price:
                if(list!=null){
                    Intent intent1 = new Intent(ChinaActivity.this,TimeHotel.class);
                    startActivity(intent1);
                }else {
                    Toast.makeText(ChinaActivity.this, "网络连接异常！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.search_btn:
                if(list!=null){
                        String cityid = myEntity_location.getEcityid();
                        Intent intent_search = new Intent(ChinaActivity.this, SearchHotelActivity.class);
                          intent_search.putExtra("hotel_name",hotel_names);
                         intent_search.putExtra("hotelid",hotelid);
                          intent_search.putExtra("cityid", cityid);
                        startActivity(intent_search);
                    }else {
                    Toast.makeText(ChinaActivity.this, "网络连接异常！", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.holtel_collections:
                Intent intent=new Intent(ChinaActivity.this,HotelCollectionActivity.class);
                startActivity(intent);
                break;
            case R.id.always_holtel:
                Intent intent2=new Intent(ChinaActivity.this,FavorateHotelActivity.class);
                startActivity(intent2);
                break;
        }

    }

    public class MyTaskForLocation extends AsyncTask<String, Void, String> {
        private String data;

        @Override
        protected String doInBackground(String... params) {
            data = NetUtils.getData(params[0]);

            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            if (s.equals("ERROR")) {
                Toast.makeText(ChinaActivity.this, "网络连接异常！", Toast.LENGTH_SHORT).show();
            }else {
                list = JsonUtis.PareJson(s);
                myEntity_location = list.get(0);
                if (location_tv.getText().toString().isEmpty()) {
                    location_tv.setText(myEntity_location.getCname());
                }
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 0) {
            if (data != null) {
                hotel_names = data.getStringExtra("hotel_name");
                hotelid = data.getStringExtra("hotelid");
                hotel_name.setText(hotel_names);
            }else {
                hotel_name.setText("");
                hotelid=null;
            }

        }
    }
}
