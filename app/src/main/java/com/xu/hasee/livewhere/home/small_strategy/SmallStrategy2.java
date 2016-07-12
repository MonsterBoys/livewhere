package com.xu.hasee.livewhere.home.small_strategy;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.xu.hasee.livewhere.JsonUtis;
import com.xu.hasee.livewhere.NetUtils;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;

import java.util.List;

public class SmallStrategy2 extends Activity {

    private ListView lv;
    private List<SmallStrategyEntitys2> list;
    private ImageView back2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_strategy2);
        lv = ((ListView) findViewById(R.id.lv));
        Intent intent = getIntent();
        String kid = intent.getStringExtra("kid");
        back2 = ((ImageView) findViewById(R.id.back2));
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        new MyTask().execute(String.format(UrlPath.smallstrategy2, kid));
    }

    class MyTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            return NetUtils.getData(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            list = JsonUtis.ParseJsonSmall2(s);
            SmallStrategyAdapters2 adapters2 = new SmallStrategyAdapters2(SmallStrategy2.this, list);
            lv.setAdapter(adapters2);
        }
    }
}
