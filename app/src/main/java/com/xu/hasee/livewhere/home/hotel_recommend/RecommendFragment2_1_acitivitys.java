package com.xu.hasee.livewhere.home.hotel_recommend;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xu.hasee.livewhere.JsonUtis;
import com.xu.hasee.livewhere.NetUtils;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;

import java.util.List;

public class RecommendFragment2_1_acitivitys extends AppCompatActivity {

    private ImageView pic;
    private TextView hotelname;
    private TextView content;
    private List<Fragment2_1_entitys> list;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_fragment2_1_acitivitys);
        Intent intent = getIntent();
        int hotelid = intent.getIntExtra("hotelid", 46748);
        initView();
        new MyTask().execute(String.format(UrlPath.goodHotelintroduce, hotelid));
        new MyTaskBottom().execute(String.format(UrlPath.goodHotelintroduce, hotelid));
        lv.setFocusable(false);
    }

    private void initView() {
        hotelname = ((TextView) findViewById(R.id.hotelname));
        pic = ((ImageView) findViewById(R.id.pic));
        content = ((TextView) findViewById(R.id.content));
        lv = ((ListView) findViewById(R.id.lv));
        ImageView back = ((ImageView) findViewById(R.id.back));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
            list = JsonUtis.ParseJsonFrgment2_1(s);
            Fragment2_1_entitys fragment2_1_entitys = list.get(0);
            hotelname.setText(fragment2_1_entitys.getHotelname());
            Picasso.with(RecommendFragment2_1_acitivitys.this).load(fragment2_1_entitys.getPic()).into(pic);
            content.setText(fragment2_1_entitys.getContent());
        }
    }

    class MyTaskBottom extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            return NetUtils.getData(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            List<Fragment2_1Bottom_entitys> list = JsonUtis.ParseJsonFrgment2_1Bottom(s);
            Fragment2_1Bottom_adapters adapter = new Fragment2_1Bottom_adapters(RecommendFragment2_1_acitivitys.this, list);
            int count = adapter.getCount();
            int totalheight = 0;
            for (int i = 0; i < count; i++) {
                View view = adapter.getView(i, null, lv);
                view.measure(0, 0);
                int measuredHeight = view.getMeasuredHeight();
                totalheight += measuredHeight;
            }
            ViewGroup.LayoutParams layoutParams = lv.getLayoutParams();
            int dividerHeight = lv.getDividerHeight();
            layoutParams.height = totalheight + dividerHeight;
            lv.setLayoutParams(layoutParams);
            lv.requestLayout();
            lv.setAdapter(adapter);
        }
    }
}
