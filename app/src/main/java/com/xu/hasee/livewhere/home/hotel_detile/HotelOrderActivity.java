package com.xu.hasee.livewhere.home.hotel_detile;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.xu.hasee.livewhere.R;

import java.util.ArrayList;
import java.util.List;

public class HotelOrderActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView back;
    private RelativeLayout rl_room_type;
    private RelativeLayout rl_come;
    private RelativeLayout rl_live;
    private TextView hotel_name;
    private TextView today;
    private TextView tomarror;
    private TextView rooms_type;
    private TextView room_count;
    private TextView come_time;
    private EditText select_person;
    private EditText phone_number;
    private String hotelname_str;
    private String room_type_str;
    private PopupWindow pw;
    private RelativeLayout rl_oeder_layout;
    private TextView roomsmoney;
    private TextView submit_order;
    private String totalprice;
    private String jiangjin;
    private String address;
    private String room_count_str;
    private String come_time_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_order);
        initID();
        Intent intent = getIntent();
        hotelname_str = intent.getStringExtra("hotelname");
        room_type_str = intent.getStringExtra("room_type");
        totalprice = intent.getStringExtra("totalprice");
        jiangjin = intent.getStringExtra("jiangjin");
        address = intent.getStringExtra("address");
        setData();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HotelOrderActivity.this.finish();
            }
        });
        come_time_text = come_time.getText().toString();
        room_count_str = room_count.getText().toString();
    }

    private void setData() {
        hotel_name.setText(hotelname_str);
        rooms_type.setText(room_type_str);
        roomsmoney.setText("¥" + totalprice + " " + "返" + " " + "¥" + jiangjin);

    }

    private void initID() {
        rl_room_type = ((RelativeLayout) findViewById(R.id.rl_room_type));
        rl_come = ((RelativeLayout) findViewById(R.id.rl_come));
        rl_live = ((RelativeLayout) findViewById(R.id.rl_live));
        //  RelativeLayout rl_phone= ((RelativeLayout) findViewById(R.id.rl_phone));
        back = ((ImageView) findViewById(R.id.back));
        hotel_name = ((TextView) findViewById(R.id.order_hotel_name));
        today = ((TextView) findViewById(R.id.today));
        tomarror = ((TextView) findViewById(R.id.tomarror));
        rooms_type = ((TextView) findViewById(R.id.rooms_type));
        room_count = ((TextView) findViewById(R.id.room_count));
        come_time = ((TextView) findViewById(R.id.come_time));
        select_person = ((EditText) findViewById(R.id.select_person));
        phone_number = ((EditText) findViewById(R.id.phone_number));
        rl_oeder_layout = ((RelativeLayout) findViewById(R.id.rl_oeder_layout));
        roomsmoney = ((TextView) findViewById(R.id.rooms_money));
        submit_order = ((TextView) findViewById(R.id.submit_order));
        rl_room_type.setOnClickListener(this);
        rl_come.setOnClickListener(this);
        submit_order.setOnClickListener(this);
        rl_live.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_room_type:
                popupWindMethod();
                break;
            case R.id.rl_come:
                popupcomeTime();
                break;
            case R.id.rl_live:
                break;
            case R.id.phone_number:
                break;
            case R.id.submit_order://进入订单详情页面
                String select_person_str = select_person.getEditableText().toString();
                Log.d("xyc", "onClick: "+select_person_str);
                String phone_number_str = phone_number.getEditableText().toString();
                if(phone_number_str.length()!=11){
                    Toast.makeText(HotelOrderActivity.this,"请填写正确的手机号！",Toast.LENGTH_SHORT).show();
                }else
                {
                    if ((!select_person_str.equals("")) &&(! phone_number_str.equals(""))) {
                        Intent intent = new Intent(HotelOrderActivity.this, OrderDetileActivity.class);
                        intent.putExtra("address", address);
                        intent.putExtra("hotelname", hotelname_str);
                        intent.putExtra("room_type", room_type_str);
                        intent.putExtra("totalprice", totalprice);
                        intent.putExtra("jiangjin", jiangjin);
                        intent.putExtra("room_count", room_count_str);
                        intent.putExtra("come_time_text", come_time_text);
                        intent.putExtra("select_person", select_person_str);
                        intent.putExtra("phone_number_str", phone_number_str);
                        startActivity(intent);
                    }else
                    {
                        Toast.makeText(HotelOrderActivity.this,"请填写完整信息！",Toast.LENGTH_SHORT).show();
                    }
                }


                break;

        }


    }

    private void popupcomeTime() {
        final List<String> list = new ArrayList<>();
        String[] strs = {"15：00之前", "次日06:00之前"};
        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i]);
        }
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.rooms_counts_layout, null);
        final ListView listview = ((ListView) view.findViewById(R.id.listview));
        MyAdapter_rooms adapter = new MyAdapter_rooms(this, list);
        listview.setAdapter(adapter);
        pw = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                500);
        pw.setBackgroundDrawable(new BitmapDrawable());
        pw.setOutsideTouchable(true);
        // 设置popWindow的显示和消失动画
        pw.setAnimationStyle(R.style.mypopwindow_anim_style);
        pw.setFocusable(true);
        // 在底部显示
        pw.showAtLocation(rl_oeder_layout,
                Gravity.BOTTOM, 0, 0);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                come_time_text = list.get(position);
                come_time.setText(come_time_text);
                pw.dismiss();
            }
        });
    }

    private void popupWindMethod() {
        // 利用layoutInflater获得View
        final List<String> list = new ArrayList<>();
        String[] strs = {"1间", "2间", "3间", "4间", "5间", "6间"};
        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i]);
        }
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.rooms_counts_layout, null);
        final ListView listview = ((ListView) view.findViewById(R.id.listview));
        MyAdapter_rooms adapter = new MyAdapter_rooms(this, list);
        listview.setAdapter(adapter);
        pw = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                800);
        pw.setBackgroundDrawable(new BitmapDrawable());
        pw.setOutsideTouchable(true);
        // 设置popWindow的显示和消失动画
        pw.setAnimationStyle(R.style.mypopwindow_anim_style);
        pw.setFocusable(true);
        // 在底部显示
        pw.showAtLocation(rl_oeder_layout,
                Gravity.BOTTOM, 0, 0);
        // pw.showAsDropDown(phone_number);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                room_count_str = list.get(position);
                room_count.setText(room_count_str);
                pw.dismiss();
            }
        });
    }
}
