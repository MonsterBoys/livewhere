package com.xu.hasee.livewhere.myinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xu.hasee.livewhere.R;

public class AboutActivity extends AppCompatActivity {

    private TextView about_zhuna;
    private TextView about_weburl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initView();

    }

    private void initView() {
        ((ImageView) findViewById(R.id.about_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        about_zhuna = ((TextView) findViewById(R.id.about_zhuna));
        about_zhuna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this, AboutDetailActivity.class);
                startActivity(intent);
            }
        });

        about_weburl = ((TextView) findViewById(R.id.about_weburl));
        about_weburl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this, ZhunawebActivity.class);
                startActivity(intent);
            }
        });
    }
}
