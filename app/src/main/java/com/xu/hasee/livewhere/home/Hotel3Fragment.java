package com.xu.hasee.livewhere.home;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.xu.hasee.livewhere.JsonUtis;
import com.xu.hasee.livewhere.NetUtils;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;
import com.xu.hasee.livewhere.home.hotel_detile.HoltelDetileActivity;
import com.xu.hasee.livewhere.home.hotel_detile.hotel_photo.RefreshLayout;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Hotel3Fragment extends Fragment {

    private String urlpath;
    private View view;
    private ListView listview;
    private List<MyEntity_hotelInfo> list;
    private int pageCount = 1;
    private MyAdapter_holtel adapter_holtel;

    public Hotel3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_hotel, null);
        listview = ((ListView) view.findViewById(R.id.listview));
        final RefreshLayout myRefreshListView = (RefreshLayout)
                view.findViewById(R.id.swipe_layout);
        final String tm1 = NetUtils.getTime()[0];
        final String tm2 = NetUtils.getTime()[1];
        Bundle arguments = getArguments();
        final String cityid = arguments.getString("cityid");
        MyTask myTask = new MyTask();
        myTask.execute(String.format(UrlPath.nowhotel_path, tm2, pageCount, cityid, tm1));
        myRefreshListView.setColorSchemeResources(R.color.mycolorgray, R.color.mycolorgreen);
        myRefreshListView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //  Toast.makeText(getActivity(),"refresh", Toast.LENGTH_SHORT).show();
                myRefreshListView.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        //   datas.add(new Date().toGMTString());
                        MyTask myTask = new MyTask();
                        myTask.execute(String.format(UrlPath.allhotel_path, tm2, ++pageCount, cityid, tm1));
                        adapter_holtel.notifyDataSetChanged();

                        myRefreshListView.setRefreshing(false);
                    }
                }, 3000);
            }
        });

        myRefreshListView.setOnLoadListener(new RefreshLayout.OnLoadListener() {

            @Override
            public void onLoad() {

                // Toast.makeText(getActivity(), "load", Toast.LENGTH_SHORT).show();

                myRefreshListView.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                     /*   datas.add(new Date().toGMTString());
                        adapter.notifyDataSetChanged();*/
                        MyTask myTask = new MyTask();
                        myTask.execute(String.format(UrlPath.allhotel_path, tm2, ++pageCount, cityid, tm1));
                        adapter_holtel.notifyDataSetChanged();

                        myRefreshListView.setLoading(false);
                    }
                }, 3000);

            }
        });
        return view;
    }

    class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            return NetUtils.getData(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            if (s.equals("ERROR")) {
                Toast.makeText(getActivity(), "网络连接异常！", Toast.LENGTH_SHORT).show();
            } else {
                list = JsonUtis.PaseJsonHoTelInfo(s);
                adapter_holtel = new MyAdapter_holtel(getActivity(), list);
                listview.setAdapter(adapter_holtel);
                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getActivity(), HoltelDetileActivity.class);
                        String ids = list.get(position).getId();
                        intent.putExtra("esdname",list.get(position).getEsdname());
                        intent.putExtra("price", list.get(position).getMin_jiage());
                        intent.putExtra("ids", ids);
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
