package com.xu.hasee.livewhere.home.hotel_recommend;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xu.hasee.livewhere.JsonUtis;
import com.xu.hasee.livewhere.NetUtils;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;

import java.util.List;

/**
 * Created by Administrator on 2016/5/18 0018.
 */
public class RecommendFragment2 extends Fragment implements View.OnClickListener {
    private ListView lv;
    private ImageView back;
    private List<HaoRecommend_entitys> list;
    private String cityid;
    private String cityname;
    private TextView cityname1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend2, null);
        Bundle bundle = getArguments();
        cityid = bundle.getString("cityid");
        cityname = bundle.getString("cityname");
        lv = ((ListView) view.findViewById(R.id.lvv));
        back = ((ImageView) view.findViewById(R.id.back));
        cityname1 = ((TextView) view.findViewById(R.id.cityname));
        MyFragmentTask2 myFragmentTask2 = new MyFragmentTask2();
        myFragmentTask2.execute(String.format(UrlPath.HAORECOMMENDPATH, cityid));
        back.setOnClickListener(this);
        cityname1.setText(cityname + "好酒店");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                getActivity().finish();
                break;
        }
    }

    class MyFragmentTask2 extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            return NetUtils.getData(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            list = JsonUtis.ParseJsonHaoRecommend(s);
            RecommendFragment2_adapter adapter = new RecommendFragment2_adapter(getActivity(), list);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    HaoRecommend_entitys haoRecommend_entitys = list.get(position);
                    int hotelid = haoRecommend_entitys.getHotelid();
                    Intent intent = new Intent(getActivity(), RecommendFragment2_1_acitivitys.class);
                    intent.putExtra("hotelid", hotelid);
                    startActivity(intent);
                }
            });
        }
    }
}

