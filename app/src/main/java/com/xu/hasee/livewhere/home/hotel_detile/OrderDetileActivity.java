package com.xu.hasee.livewhere.home.hotel_detile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xu.hasee.livewhere.NetUtils;
import com.xu.hasee.livewhere.R;

public class OrderDetileActivity extends AppCompatActivity {

    private String hotelname_str;
    private String room_type_str;
    private String totalprice;
    private String jiangjin;
    private String address;
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
    private TextView cancle_order;
    private TextView ok_order;
    private String room_count;
    private String come_time_text;
    private String select_person;
    private String phone_number_str;
    private ImageView order_detile_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detile);
        Intent intent = getIntent();
        hotelname_str = intent.getStringExtra("hotelname");
        room_type_str = intent.getStringExtra("room_type");
        totalprice = intent.getStringExtra("totalprice");
        jiangjin = intent.getStringExtra("jiangjin");
        address = intent.getStringExtra("address");
        room_count = intent.getStringExtra("room_count");
        come_time_text = intent.getStringExtra("come_time_text");
        select_person = intent.getStringExtra("select_person");
        phone_number_str = intent.getStringExtra("phone_number_str");
        initID();
        setDatas();
        cancle_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderDetileActivity.this.finish();
                Toast.makeText(OrderDetileActivity.this, "订单已取消！", Toast.LENGTH_SHORT).show();
            }
        });
        ok_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        order_detile_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderDetileActivity.this.finish();
            }
        });
    }

    private void setDatas() {
        detile_hotel_name.setText(hotelname_str);
        fanxian.setText("可返现:" + jiangjin + "元");
        dizhi.setText("地址:  " + address);
        jine.setText("¥" + totalprice);
        yudingfangxing.setText("预订房型:" + room_type_str + "  " + "");
        ruzhushijian.setText("入住时间:" + come_time_text + " " + room_count + "晚");
        String[] time = NetUtils.getTime();
        yudingriqi.setText("预订日期:" + time[0]);
        //  int x=0+(int)(Math.random()*9);//
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 9; i++) {
            int x = 0 + (int) (Math.random() * 9);
            sb.append(x);
        }
        dingdanid.setText("订单ID:" + sb.toString());
        ruzhuren.setText("入住人:" + select_person);
        lianxifangshi.setText("联系方式:" + phone_number_str);
    }

    private void initID() {
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
        cancle_order = ((TextView) findViewById(R.id.cancle_order));
        ok_order = ((TextView) findViewById(R.id.ok_order));
        order_detile_back = ((ImageView) findViewById(R.id.order_detile_back));
    }
}
