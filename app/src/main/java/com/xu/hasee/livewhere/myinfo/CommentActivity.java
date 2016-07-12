package com.xu.hasee.livewhere.myinfo;

import android.content.Intent;
import android.net.Uri;
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

public class CommentActivity extends AppCompatActivity {

    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {


            if (ConnectionUtil.isConn(getApplicationContext())) {
                //有网络
                loadinganimationUtils.dismiss();
                comment_error_iv.setImageResource(R.drawable.load_error);
                comment_tv.setText("没有找到可点评的酒店!");

            } else {
                //没网络
                loadinganimationUtils.dismiss();

                comment_error_iv.setImageResource(R.drawable.load_error);
                comment_tv.setText("当前网络无法连接,请检查网络设置!");
            }


        }
    };
    private LoadinganimationUtils loadinganimationUtils;
    private ImageView comment_error_iv;
    private TextView comment_tv;
    private ImageView comment_back;
    private ImageView comment_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        //************************初始化加载动画图片的对象******************************
        comment_error_iv = (ImageView) findViewById(R.id.comment_error_iv);
        comment_tv = (TextView) findViewById(R.id.comment_tv);


        loadinganimationUtils = new LoadinganimationUtils(this, "正在努力加载中...", R.drawable.loading_animation);
        loadinganimationUtils.show();
        //******************************************************************************
        comment_call = ((ImageView) findViewById(R.id.comment_call));
        comment_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:18814371558");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });
        comment_back = ((ImageView) findViewById(R.id.comment_back));
        comment_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mhandler.sendEmptyMessageDelayed(0, 3000);

    }
}
