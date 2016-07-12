package com.xu.hasee.livewhere;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2016/5/19.
 */
public class OkHttpUtils {
    private static OkHttpClient okHttpClient=new OkHttpClient();
    public static void getData(String path, Callback callback){
        Request request = new Request.Builder().url(path).build();
        Call call = okHttpClient.newCall(request);

        call.enqueue(callback);
    }
}
