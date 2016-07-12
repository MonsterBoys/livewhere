package com.xu.hasee.livewhere.home.hotel_detile.hotel_info;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.xu.hasee.livewhere.JsonUtis;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelInfoFragment extends Fragment {


    private View view;
    private TextView base_tv;
    private TextView hotelservice;
    private ListView traffics_listview;
    private TextView contents;
    private Object data;
    private OkHttpClient client;
    private List<MyEntity_traffic> list;
    private ListView listview;


    public HotelInfoFragment() {
        // Required empty public constructor
    }

    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            List<MyEntity_hotelintroinfo> lists = ((List<MyEntity_hotelintroinfo>) msg.obj);
            MyEntity_hotelintroinfo  myEntity = lists.get(0);
            String[] base = myEntity.getBase();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < base.length; i++) {
                sb.append(base[i] + "  ");
            }
            base_tv.setText(sb.toString());
            String hotelservicestr = myEntity.getHotelservice();
            hotelservice.setText(hotelservicestr);
            String content = myEntity.getContent();
            contents.setText(content);
            list = myEntity.getList();
            MyAdapter_traffics adapter = new MyAdapter_traffics(getActivity(), list);
            int count = adapter.getCount();
            int totalheight = 0;
            for (int i = 0; i < count; i++) {
                View view = adapter.getView(i, null, listview);
                view.measure(0, 0);
                int measuredHeight = view.getMeasuredHeight();
                totalheight += measuredHeight;
            }
            ViewGroup.LayoutParams layoutParams = listview.getLayoutParams();
            int dividerHeight = listview.getDividerHeight();
            layoutParams.height = totalheight + dividerHeight;
            listview.setLayoutParams(layoutParams);
            listview.requestLayout();
            listview.setFocusable(false);
            listview.setAdapter(adapter);
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_hotel_info, null);
        listview = ((ListView) view.findViewById(R.id.traffics_listview));
        initData();
        client = new OkHttpClient();
        getDatas();

        return view;
    }

    private void initData() {
        base_tv = ((TextView) view.findViewById(R.id.base_tv));
        hotelservice = ((TextView) view.findViewById(R.id.hotelservice));
        traffics_listview = ((ListView) view.findViewById(R.id.traffics_listview));
        contents = ((TextView) view.findViewById(R.id.contents));
    }

    public void getDatas() {
        Bundle arguments = getArguments();
        String hotelid = arguments.getString("hotelid");
        Log.d("xyc", "getDatas: "+hotelid);
        Request.Builder builder = new Request.Builder().url(UrlPath.hotel_info_path);

        Request request = builder.build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String str = response.body().string();
                    List<MyEntity_hotelintroinfo> list = JsonUtis.PaseJsonintra(str);
                    Log.d("xyc", "onResponse: "+list.toString());
                    Message message = mhandler.obtainMessage();
                    message.obj = list;
                    mhandler.sendMessage(message);
                }else {
                    Toast.makeText(getActivity(), "NetError", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
