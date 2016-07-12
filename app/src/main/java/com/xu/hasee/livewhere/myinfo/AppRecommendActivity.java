package com.xu.hasee.livewhere.myinfo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xu.hasee.livewhere.Bean.AppRecommend;
import com.xu.hasee.livewhere.R;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AppRecommendActivity extends AppCompatActivity {

    private ListView app_lv;
    private OkHttpClient okHttpClient;
    private ImageView app_back;
    private Handler mhandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            app_lv.setAdapter(appAdapter);

            super.handleMessage(msg);
        }
    };
    private AppAdapter appAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_recommend);
        initview();
        initdata();
    }

    private void initview() {
        okHttpClient = new OkHttpClient();
        app_back = ((ImageView) findViewById(R.id.app_back));
        app_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        app_lv = ((ListView) findViewById(R.id.app_lv));

    }

    private void initdata() {
        Request request = new Request.Builder().url("http://app.api.zhuna.cn/v30/misc/appList.php?os=android&os=android&code=8e1b7c48aa9891c4bef34c9613068d0b&agentId=800&unionId=0&version=3.4.0&os=android").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    parserJson(response.body().string());
                }
            }
        });
    }

    private void parserJson( String string) {
        JSONObject object = JSON.parseObject(string);
        JSONArray result = object.getJSONArray("result");
        List<AppRecommend.ResultBean> list = JSON.parseArray(result + "", AppRecommend.ResultBean.class);
        appAdapter = new AppAdapter(list,AppRecommendActivity.this);
        mhandler.sendEmptyMessage(0);

    }
}
