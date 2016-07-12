package com.xu.hasee.livewhere;

import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hasee on 2016/5/11.
 */
public class NetUtils {
    public static String getData(String urlPath) {
        HttpURLConnection con = null;
        BufferedInputStream bis = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            URL url = new URL(urlPath);
            con = ((HttpURLConnection) url.openConnection());
            con.setConnectTimeout(5 * 1000);
            con.connect();
            if (con.getResponseCode() == 200) {
                bis = new BufferedInputStream(con.getInputStream());
                byte[] bytes = new byte[5 * 1000];
                int len = 0;
                while ((len = bis.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                    bos.flush();
                }
            }
        } catch (MalformedURLException e) {
            return "ERROR";
           // e.printStackTrace();

        } catch (IOException e) {
            return "ERROR";
            //e.printStackTrace();

        } finally {
            if (con != null) {
                con.disconnect();
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bos.toString();
    }

    public static String[] getTime() {
        String [] str=new String[2];
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String tm1= dateFormat.format(date);
        str[0]=tm1;
        date.setDate(date.getDate()+1);
        String tm2=dateFormat.format(date);
        str[1]=tm2;
        return str;
    }
}
