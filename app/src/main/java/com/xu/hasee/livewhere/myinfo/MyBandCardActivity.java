package com.xu.hasee.livewhere.myinfo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xu.hasee.livewhere.ConnectionUtil;
import com.xu.hasee.livewhere.LoadinganimationUtils;
import com.xu.hasee.livewhere.R;

public class MyBandCardActivity extends AppCompatActivity {
    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {


            if (ConnectionUtil.isConn(getApplicationContext())) {
                //有网络
                loadinganimationUtils.dismiss();
                band_error_iv.setImageResource(R.drawable.load_error);
                band_tv.setText("你什么都没有留下!");

            } else {
                //没网络
                loadinganimationUtils.dismiss();

                band_error_iv.setImageResource(R.drawable.load_error);
                band_tv.setText("当前网络无法连接,请检查网络设置!");
            }


        }
    };
    private ImageView band_error_iv;
    private TextView band_tv;
    private LoadinganimationUtils loadinganimationUtils;
    private ImageView band_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_band_card);


        //************************初始化加载动画图片的对象******************************
        band_error_iv = (ImageView) findViewById(R.id.band_error_iv);
        band_tv = (TextView) findViewById(R.id.band_tv);


        loadinganimationUtils = new LoadinganimationUtils(this, "正在努力加载中...", R.drawable.loading_animation);
        loadinganimationUtils.show();
        //******************************************************************************

        band_back = ((ImageView) findViewById(R.id.band_back));
        band_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mhandler.sendEmptyMessageDelayed(0, 3000);

    }
}

