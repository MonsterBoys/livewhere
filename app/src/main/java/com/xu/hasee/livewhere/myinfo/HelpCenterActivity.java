package com.xu.hasee.livewhere.myinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;

import com.xu.hasee.livewhere.R;

public class HelpCenterActivity extends AppCompatActivity {

    private WebView help_webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);

        ((ImageView) findViewById(R.id.help_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        help_webview = ((WebView) findViewById(R.id.help_webview));
        help_webview.getSettings().setJavaScriptEnabled(true);
        help_webview.loadUrl("http://m.zhuna.cn/helper/index.php");
        help_webview.setWebChromeClient(new WebChromeClient());
    }
}
