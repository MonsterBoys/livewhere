package com.xu.hasee.livewhere.home.hotel_detile.hotel_photo;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xu.hasee.livewhere.JsonUtis;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Hotel_pro_Fragment extends Fragment {


    public Hotel_pro_Fragment() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;
    public Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            List<MyEntity_photo> myEntity_photos = (List<MyEntity_photo>) msg.obj;
            adapter = new MyAdapter_photo(getActivity(),myEntity_photos);
            recyclerView.setAdapter(adapter);
        }
    };
    private MyAdapter_photo adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.activity_hotel_photo,null);
        recyclerView = ((RecyclerView) view.findViewById(R.id.recyclerview));
        Bundle arguments = getArguments();
        String hotelid = arguments.getString("hotelid");
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        OkHttpClient client = new OkHttpClient();
        Request.Builder builder = new Request.Builder().url(String.format(UrlPath.hotel_photo,hotelid));
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
                    List<MyEntity_photo> list= JsonUtis.PaseJsonPhoto(str);
                    Message message = mhandler.obtainMessage();
                    message.obj = list;
                    mhandler.sendMessage(message);
                } else {
                    Toast.makeText(getActivity(), "网络连接异常", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}
