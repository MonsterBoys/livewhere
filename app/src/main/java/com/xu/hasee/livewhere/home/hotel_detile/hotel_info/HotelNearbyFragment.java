package com.xu.hasee.livewhere.home.hotel_detile.hotel_info;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.xu.hasee.livewhere.JsonUtis;
import com.xu.hasee.livewhere.NetUtils;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelNearbyFragment extends Fragment {
    private ExpandableListView elv;
    private List<GroupEntity> list;

    public HotelNearbyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotel_nearby, null);
        elv = (ExpandableListView) view.findViewById(R.id.elv);
        initData();
        Bundle arguments = getArguments();
        String hotelid = arguments.getString("hotelid");
        MyTask myTask = new MyTask();
        myTask.execute(String.format(UrlPath.nearby, hotelid));
        elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // 屏蔽GroupItem的点击事件
                return false;
            }
        });
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition,
                                        long id) {
                Toast.makeText(getActivity(), "groupPosition:" + groupPosition + ";childPosition:" + childPosition,
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return view;
    }

    private void initData() {
        //list = new ArrayList<GroupEntity>();
        String[] namestr = new String[]{"购物", "美食推荐", "休闲娱乐"};

       /* for (int i = 0; i < namestr.length; i++) {
            List<ChildEntity> ces = new ArrayList<ChildEntity>();
            for (int j = 0; j < 5; j++) {
                ChildEntity ce = new ChildEntity("张三" + i, "[签名] 123456--" + j);
                ces.add(ce);
            }
            GroupEntity ge = new GroupEntity(name, ces);
            list.add(ge);
        }*/
    }

    class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            return NetUtils.getData(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            if (s.equals("ERROR")) {
                Toast.makeText(getActivity(), "网路异常，请检查网络！！", Toast.LENGTH_SHORT).show();
            } else {
                list = JsonUtis.PaseJsonNearby(s);
                MyAdapter adapter = new MyAdapter(list, getActivity());
                elv.setAdapter(adapter);
                // 去掉默认向下的箭头
                elv.setGroupIndicator(null);
                for (int i = 0; i < list.size(); i++) {
                    // 表示展开某一个item
                    elv.expandGroup(i);
                }
            }
        }
    }
}
