package com.xu.hasee.livewhere.home.small_strategy;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.xu.hasee.livewhere.JsonUtis;
import com.xu.hasee.livewhere.NetUtils;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;

import java.util.List;

public class SmallStrategy extends Activity {
    private List<SmallStrategyEntitys> list;
    private GridView gv;
    private ImageView back1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_strategy);
        gv = ((GridView) findViewById(R.id.gv));
        back1 = ((ImageView) findViewById(R.id.back1));
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        new MyTask().execute(UrlPath.smallstrategy);
    }

    class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            return NetUtils.getData(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            list = JsonUtis.ParseJsonSmall(s);
            SmallStrategyAdapters adapters = new SmallStrategyAdapters(SmallStrategy.this, list);
            gv.setAdapter(adapters);
            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String kid = list.get(position).getKid();
                    Intent intent = new Intent(SmallStrategy.this,SmallStrategy2.class);
                    intent.putExtra("kid",kid);
                    startActivity(intent);

                }
            });
        }
    }
}
