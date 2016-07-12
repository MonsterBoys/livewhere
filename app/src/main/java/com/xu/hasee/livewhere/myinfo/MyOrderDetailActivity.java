package com.xu.hasee.livewhere.myinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.xu.hasee.livewhere.R;

public class MyOrderDetailActivity extends AppCompatActivity {
    private TextView detile_hotel_name;
    private TextView fanxian;
    private TextView dizhi;
    private TextView dingdanid;
    private TextView yudingriqi;
    private TextView jine;
    private TextView yudingfangxing;
    private TextView ruzhushijian;
    private TextView ruzhuren;
    private TextView lianxifangshi;
    private ImageView order_detile_back;
    private  TextView dingdanzhuangtai;
    private  TextView zhifufangshi;
    private String name;
    private String cashback;
    private String adress;
    private String orderid;
    private String orderstate;
    private String bookdate;
    private String bookmoney;
    private String paytype;
    private String housetype;
    private String checkintime;
    private String checkinperson;
    private String telephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order_detail);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        cashback = intent.getStringExtra("cashback");
        adress = intent.getStringExtra("adress");
        orderid = intent.getStringExtra("orderid");
        orderstate = intent.getStringExtra("orderstate");
        bookdate = intent.getStringExtra("bookdate");
        bookmoney = intent.getStringExtra("bookmoney");
        paytype = intent.getStringExtra("paytype");
        housetype = intent.getStringExtra("housetype");
        checkintime = intent.getStringExtra("checkintime");
        checkinperson = intent.getStringExtra("checkinperson");
        telephone = intent.getStringExtra("telephone");
        initview();
        initdata();
    }

    private void initdata() {

        detile_hotel_name.setText(name);
        fanxian.setText("可返现:" + cashback + "元");
        dizhi.setText("地址:  " + adress);
        dingdanzhuangtai.setText(orderstate);
        jine.setText(bookmoney);


        yudingriqi.setText(bookdate);

        dingdanid.setText(orderid);

        zhifufangshi.setText(paytype);
        yudingfangxing.setText(housetype);
        ruzhushijian.setText(checkintime);
        ruzhuren.setText(checkinperson);
        lianxifangshi.setText(telephone);
    }

    private void initview() {
        detile_hotel_name = ((TextView) findViewById(R.id.detile_hotel_name));
        fanxian = ((TextView) findViewById(R.id.fanxian));
        dizhi = ((TextView) findViewById(R.id.dizhi));
        dingdanid = ((TextView) findViewById(R.id.dingdanid));
        yudingriqi = ((TextView) findViewById(R.id.yudingriqi));
        jine = ((TextView) findViewById(R.id.jine));
        yudingfangxing = ((TextView) findViewById(R.id.yudingfangxing));
        ruzhushijian = ((TextView) findViewById(R.id.ruzhushijian));
        ruzhuren = ((TextView) findViewById(R.id.ruzhuren));
        lianxifangshi = ((TextView) findViewById(R.id.lianxifangshi));
        dingdanzhuangtai = ((TextView) findViewById(R.id.dingdanzhuangtai));
        zhifufangshi = ((TextView) findViewById(R.id.zhifufangshi));
    }
}
