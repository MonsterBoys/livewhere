package com.xu.hasee.livewhere.home.hotel_recommend;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.xu.hasee.livewhere.JsonUtis;
import com.xu.hasee.livewhere.NetUtils;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;

import java.util.List;

/**
 * Created by Administrator on 2016/5/18 0018.
 */
public class RecommendFragment1 extends Fragment {
    private ListView lv1;
    private ImageView picture1;
    private TextView ctiyname;
    private TextView ctrip_dp_num;
    private TextView descption;
    private List<RF1Top_entitys> list;
    private List<RF1Bottoms_entitys> list0;
    private String cityid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend1, null);
        lv1 = ((ListView) view.findViewById(R.id.lv1));
        picture1 = ((ImageView) view.findViewById(R.id.picture1));
        ctiyname = ((TextView) view.findViewById(R.id.ctiyname));
        ctrip_dp_num = ((TextView) view.findViewById(R.id.ctrip_dp_num));
        descption = ((TextView) view.findViewById(R.id.descption));
//        Bundle bundle = new Bundle();
//        String cityid = bundle.getString("cityid");
        Bundle arguments = getArguments();
        cityid = arguments.getString("cityid");
        new MyTaskTop().execute(String.format(UrlPath.strategy, "2501"));
        //      new MyTaskBottom().execute(String.format(UrlPath.strategy, cityid));
        return view;
    }

    class MyTaskTop extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            return NetUtils.getData(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            if (cityid == "2506" || cityid == "0608" || cityid == "1915") {
                Toast.makeText(getActivity(), "无数据,请重新选择", Toast.LENGTH_SHORT).show();
            }
            list = JsonUtis.ParseJsonRF1(s);
            RF1Top_entitys rf1Top_entitys = list.get(0);
            Picasso.with(getActivity()).load(rf1Top_entitys.getPicture()).into(picture1);
            ctiyname.setText(rf1Top_entitys.getCtiyname());
            ctrip_dp_num.setText(rf1Top_entitys.getCtrip_dp_num() + "");
            descption.setText(rf1Top_entitys.getDescption());


        }
    }

    class MyTaskBottom extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... params) {
            return NetUtils.getData(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            list0 = JsonUtis.ParseJsonRF1Bottoms(s);
            RF1Bottom_adapters adapter = new RF1Bottom_adapters(getActivity(), list0);
            int count = adapter.getCount();
            int totalheight = 0;
            for (int i = 0; i < count; i++) {
                View view = adapter.getView(i, null, lv1);
                view.measure(0, 0);
                int measuredHeight = view.getMeasuredHeight();
                totalheight += measuredHeight;
            }
            ViewGroup.LayoutParams layoutParams = lv1.getLayoutParams();
            int dividerHeight = lv1.getDividerHeight();
            layoutParams.height = totalheight + dividerHeight;
            lv1.setLayoutParams(layoutParams);
            lv1.requestLayout();
            lv1.setAdapter(adapter);
        }
    }
}

