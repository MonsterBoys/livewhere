package com.xu.hasee.livewhere.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.xu.hasee.livewhere.Bean.Collect;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.home.hotel_detile.HoltelDetileActivity;
import com.xu.hasee.livewhere.myinfo.LoginActivity;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;

public class HotelCollectionActivity extends AppCompatActivity {

    private ImageView back;
    private ListView collection_listview;
    private List<Collect> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_collection);
        Bmob.initialize(this, "0f03f96433b9be913fcd8337ea01dc18");
        back = ((ImageView) this.findViewById(R.id.back));
        collection_listview = ((ListView) findViewById(R.id.collection_listview));
        getDataFromBmob();
        collection_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String hotelid = list.get(position).getHotelid();
                Intent intent=new Intent(HotelCollectionActivity.this, HoltelDetileActivity.class);
                intent.putExtra("ids",hotelid);
                startActivity(intent);
            }
        });
    }

    private void getDataFromBmob() {
        // final List<MyEntity_collection_search> list=new ArrayList<>();
        String username = null;
        BmobUser bmobUser = BmobUser.getCurrentUser(this);
        if (bmobUser != null) {
          
            username = (String) BmobUser.getObjectByKey(this, "username");
            BmobQuery<Collect> query = new BmobQuery<Collect>();
            
            query.addWhereEqualTo("username", username);
           
            query.setLimit(50);
          
            query.findObjects(this, new FindListener<Collect>() {
                @Override
                public void onSuccess(List<Collect> object) {
                    // TODO Auto-generated method stub
                    list=object;
                  
                    MyAdapter_collection adapter_collection = new MyAdapter_collection(object, HotelCollectionActivity.this);
                    collection_listview.setAdapter(adapter_collection);
                    for (Collect collect : object) {
                        Log.d("xyc", "onSuccess: " + collect.getHotelname());
                    }
                }

                @Override
                public void onError(int code, String msg) {
                    // TODO Auto-generated method stub
                 
                }
            });
        } else {
            
            Intent intent = new Intent(HotelCollectionActivity.this, LoginActivity.class);
            startActivity(intent);

        }


    }
}
