package com.xu.hasee.livewhere.myinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;

import com.xu.hasee.livewhere.R;

public class ZhunawebActivity extends AppCompatActivity {

    private WebView zhunaweb_webview;
    private ImageView zhunaweb_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhunaweb);
        zhunaweb_back = ((ImageView) findViewById(R.id.zhunaweb_back));
        zhunaweb_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        zhunaweb_webview = ((WebView) findViewById(R.id.zhunaweb_webview));
        zhunaweb_webview.getSettings().setJavaScriptEnabled(true);
        zhunaweb_webview.loadUrl("http://m.zhuna.cn/");
        zhunaweb_webview.setWebChromeClient(new WebChromeClient());
    }
}
