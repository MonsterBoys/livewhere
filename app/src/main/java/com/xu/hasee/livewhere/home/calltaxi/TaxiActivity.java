package com.xu.hasee.livewhere.home.calltaxi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xu.hasee.livewhere.R;

/**
 * Created by Administrator on 2016/5/18.
 */
public class TaxiActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView image_back;
    private ImageView image_head;
    private TextView text_refresh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taxi_main);

        initView();
    }

    private void initView() {
        image_back = ((ImageView) findViewById(R.id.go_back));
        text_refresh = ((TextView) findViewById(R.id.refresh));
        image_head = ((ImageView) findViewById(R.id.image_head));
        initOnClick();
    }

    private void initOnClick() {
        image_back.setOnClickListener(this);
        text_refresh.setOnClickListener(this);
        image_head.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.go_back:
                this.finish();
                break;
            case R.id.refresh:
                break;
            case R.id.image_head:
                Intent intent_head=new Intent(TaxiActivity.this,Taxi_Head_Activity.class);
                startActivity(intent_head);
                break;
        }
    }
}
