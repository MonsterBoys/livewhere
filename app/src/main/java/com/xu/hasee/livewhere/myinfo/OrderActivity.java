package com.xu.hasee.livewhere.myinfo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xu.hasee.livewhere.Bean.Order;
import com.xu.hasee.livewhere.ConnectionUtil;
import com.xu.hasee.livewhere.LoadinganimationUtils;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.home.hotel_detile.HoltelDetileActivity;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;

public class OrderActivity extends AppCompatActivity {

    private ImageView order_call;
    private ImageView order_back;
    private List<Order> list;
    private ImageView Loading_Animation_iv;
    private TextView Loading_Animation_tv;
    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {


            if (ConnectionUtil.isConn(getApplicationContext())) {
                //有网络
                loadinganimationUtils.dismiss();
                order_error_iv.setImageResource(R.drawable.load_error);
                Loading_Animation_tv.setText("没有找到你的订单信息!");

            } else {
                //没网络
                loadinganimationUtils.dismiss();

                order_error_iv.setImageResource(R.drawable.load_error);
                Loading_Animation_tv.setText("当前网络无法连接,请检查网络设置!");
            }


        }
    };
    private ImageView order_error_iv;
    private LoadinganimationUtils loadinganimationUtils;
    private ListView order_lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        //************************初始化加载动画图片的对象******************************
        Loading_Animation_iv = (ImageView) findViewById(R.id.Loading_Animation_iv);
        order_error_iv = (ImageView) findViewById(R.id.order_error_iv);
        Loading_Animation_tv = (TextView) findViewById(R.id.Loading_Animation_tv);


        loadinganimationUtils = new LoadinganimationUtils(this, "正在努力加载中...", R.drawable.loading_animation);
        loadinganimationUtils.show();
        //******************************************************************************
        order_call = ((ImageView) findViewById(R.id.order_call));
        order_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:18814371558");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });
        order_back = ((ImageView) findViewById(R.id.order_back));
        order_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        order_lv = ((ListView) findViewById(R.id.order_lv));
        getDataFromBmob();
        order_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String orderid = list.get(position).getOrderId();
                Intent intent=new Intent(OrderActivity.this, HoltelDetileActivity.class);
                intent.putExtra("name",list.get(position).getName());
                intent.putExtra("cashback",list.get(position).getCashback());
                intent.putExtra("adress",list.get(position).getAdress());
                intent.putExtra("orderid",orderid);
                intent.putExtra("orderstate",list.get(position).getOrderstate());
                intent.putExtra("bookdate",list.get(position).getBookdate());
                intent.putExtra("bookmoney",list.get(position).getBookmoney());
                intent.putExtra("paytype",list.get(position).getPaytype());
                intent.putExtra("housetype",list.get(position).getHousetype());
                intent.putExtra("checkintime",list.get(position).getCheckintime());
                intent.putExtra("checkinperson",list.get(position).getCheckinperson());
                intent.putExtra("telephone",list.get(position).getTelephone());
                startActivity(intent);
            }
        });

    }

    private void getDataFromBmob() {
        String username = null;
        BmobUser bmobUser = BmobUser.getCurrentUser(this);
        if (bmobUser != null) {
            username = (String) BmobUser.getObjectByKey(this, "username");
            BmobQuery<Order> query = new BmobQuery<Order>();
            query.addWhereEqualTo("username", username);
            query.setLimit(50);
            query.findObjects(this, new FindListener<Order>() {
                @Override
                public void onSuccess(List<Order> object) {
                    // TODO Auto-generated method stub
                    list=object;
                    MyOrderAdapter myOrderAdapter = new MyOrderAdapter(object, OrderActivity.this);
                    order_lv.setAdapter(myOrderAdapter);
                    loadinganimationUtils.dismiss();


                }

                @Override
                public void onError(int code, String msg) {
                    // TODO Auto-generated method stub

                    mhandler.sendEmptyMessage(0);
                }
            });
        } else {
            Intent intent = new Intent(OrderActivity.this, LoginActivity.class);
            startActivity(intent);

        }


    }
}
