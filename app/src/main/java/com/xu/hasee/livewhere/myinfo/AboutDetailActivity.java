package com.xu.hasee.livewhere.myinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.xu.hasee.livewhere.R;

public class AboutDetailActivity extends AppCompatActivity {

    private ImageView about_detail_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_detail);
        about_detail_back = ((ImageView) findViewById(R.id.about_detail_back));
        about_detail_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
