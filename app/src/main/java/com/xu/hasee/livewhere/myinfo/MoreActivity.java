package com.xu.hasee.livewhere.myinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.xu.hasee.livewhere.R;

import java.util.ArrayList;
import java.util.List;

public class MoreActivity extends AppCompatActivity {

    private ListView more_lv;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        list = new ArrayList<>();
        more_lv = ((ListView) findViewById(R.id.more_lv));
        ImageView more_back = (ImageView) findViewById(R.id.more_back);
        more_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initdata();
        MyAdapter myAdapter = new MyAdapter(this,list);
        more_lv.setAdapter(myAdapter);
        more_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent PhoneSecretintent = new Intent(MoreActivity.this, PhoneSecretActivity.class);
                        startActivity(PhoneSecretintent);
                        break;
                    case 1:
                        Intent SoftwareSetintent = new Intent(MoreActivity.this, SoftwareSetActivity.class);
                        startActivity(SoftwareSetintent);
                        break;
                    case 2:
                        Intent Feedbackintent = new Intent(MoreActivity.this, FeedbackActivity.class);
                        startActivity(Feedbackintent);
                        break;
                    case 3:
                        Intent HelpCenterintent = new Intent(MoreActivity.this, HelpCenterActivity.class);
                        startActivity(HelpCenterintent);
                        break;
                    case 4:
                        Intent AppRecommendintent = new Intent(MoreActivity.this, AppRecommendActivity.class);
                        startActivity(AppRecommendintent);
                        break;
                    case 5:
                        Intent Aboutintent = new Intent(MoreActivity.this, AboutActivity.class);
                        startActivity(Aboutintent);
                        break;
                }
            }
        });

    }

    private void initdata() {
        list.add("手机密保");
        list.add("软件设置");
        list.add("意见反馈");
        list.add("帮助中心");
        list.add("应用推荐");
        list.add("关于我们");

    }
}
