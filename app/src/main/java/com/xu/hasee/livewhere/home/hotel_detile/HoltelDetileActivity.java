package com.xu.hasee.livewhere.home.hotel_detile;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xu.hasee.livewhere.Bean.Collect;
import com.xu.hasee.livewhere.JsonUtis;
import com.xu.hasee.livewhere.NetUtils;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;
import com.xu.hasee.livewhere.home.hotel_detile.hotel_info.HotelInfoActivity;
import com.xu.hasee.livewhere.home.hotel_detile.hotel_order.HotelOrderActivity;
import com.xu.hasee.livewhere.myinfo.LoginActivity;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.DeleteListener;
import cn.bmob.v3.listener.SaveListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;


public class HoltelDetileActivity extends AppCompatActivity implements View.OnClickListener {

    private List<MyEntity_list_item> list;
    private ListView listview;
    private TextView detile_item_hotel_name;
    private TextView detile_comment_scores;
    private TextView detile_comment_count;
    private TextView xingji;
    private TextView open_time;
    private ImageView detile_right;
    private TextView detile_location;
    private ImageView detile_back;
    private ImageView detile_call;
    private ImageView detile_share;
    private RadioButton hotel_collecte;
    private ViewPager viewPager;
    private List<Bitmap> bitmap_list;
    private String[] strs;
    private MyEntity_hotel myEntity_hotel;
    private RelativeLayout rl_layout;
    private String ids;
    private String address;
    private String hotelname;
    private String objectId;
    private int flag = 1;
    private String jiangjin;
    private String totalprice;
    private String price;
    private String pic153;
    private String esdname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holtel_detile);
        Bmob.initialize(this, "0f03f96433b9be913fcd8337ea01dc18");
        initID();
        Intent intent = getIntent();
        ids = intent.getStringExtra("ids");
        price = intent.getStringExtra("price");
        pic153 = intent.getStringExtra("pic153");
        esdname = intent.getStringExtra("esdname");
        String tm1 = NetUtils.getTime()[0];
        String tm2 = NetUtils.getTime()[1];
        MyTask mytask = new MyTask();
        mytask.execute(String.format(UrlPath.hotel_detile_list_path, tm2, ids, tm1));
        Mytask2 mytask2 = new Mytask2();
        mytask2.execute(String.format(UrlPath.hotel_detile_center, ids));
        listview.setFocusable(false);

    }

    private void initID() {
        listview = ((ListView) findViewById(R.id.detile_listview));
        detile_item_hotel_name = ((TextView) findViewById(R.id.detile_item_hotel_name));
        detile_comment_scores = ((TextView) findViewById(R.id.detile_comment_scores));
        detile_comment_count = ((TextView) findViewById(R.id.detile_comment_count));
        xingji = ((TextView) findViewById(R.id.xingji));
        open_time = ((TextView) findViewById(R.id.open_time));
        detile_location = ((TextView) findViewById(R.id.detile_location));
        detile_right = ((ImageView) findViewById(R.id.detile_right));
        detile_back = ((ImageView) findViewById(R.id.detile_back));
        detile_call = ((ImageView) findViewById(R.id.detile_call));
        detile_share = ((ImageView) findViewById(R.id.detile_share));
        hotel_collecte = ((RadioButton) findViewById(R.id.hotel_collecte));
        rl_layout = ((RelativeLayout) findViewById(R.id.rl_layout));
        viewPager = ((ViewPager) findViewById(R.id.vp));
        rl_layout.setOnClickListener(this);
        detile_right.setOnClickListener(this);
        detile_call.setOnClickListener(this);
        detile_back.setOnClickListener(this);
        detile_share.setOnClickListener(this);
        hotel_collecte.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.detile_back:
                this.finish();
                break;
            case R.id.detile_call:
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "10086"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            case R.id.detile_share:
                showShare();
                break;
            case R.id.hotel_collecte:
                CollectionMethod();
                break;
            case R.id.rl_layout:
                Intent intent2=new Intent(HoltelDetileActivity.this, HotelInfoActivity.class);
                intent2.putExtra("hotelid",ids);
                startActivity(intent2);
                break;

        }
    }

    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        String url="http://www.zhuna.cn/hotel-%s.html";
        String format = String.format(url, ids);
     // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
       oks.setTitle("分享时刻准备着！");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl(format);
        // text是分享文本，所有平台都需要这个字段
        oks.setText("520住哪儿？");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
       //oks.setImagePath("");
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        oks.setImageUrl("http://img5.imgtn.bdimg.com/it/u=136175546,378142833&fm=15&gp=0.jpg");
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(format);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("这个不错哦！");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(format);

// 启动分享GUI
        oks.show(this);
    }


    private void CollectionMethod() {
        String username = null;
        BmobUser bmobUser = BmobUser.getCurrentUser(this);
        if (bmobUser != null) {
            // 允许用户使用应用
            username = (String) BmobUser.getObjectByKey(this, "username");
            // Log.d("xyc", "CollectionMethod: "+username);
            //通过objectId来实现数据库的增删查改
            final Collect collect = new Collect();
            collect.setUsername(username);
            collect.setHotelid(ids);
            collect.setHotelname(hotelname);
            collect.setAddress(esdname);
            collect.setPrice(price);
            collect.setPic153(pic153);
            collect.setScores(detile_comment_scores.getText().toString());
            collect.setXingji(xingji.getText().toString());
            collect.save(getApplicationContext(), new SaveListener() {
                @Override
                public void onSuccess() {
                    objectId = collect.getObjectId();
                    // Log.d("xyc", "onSuccess: " + objectId);
                    hotel_collecte.setText("已收藏");
                   // Toast.makeText(HoltelDetileActivity.this, "收藏成功！", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(int i, String s) {
                    // Log.d("xyc", "onFailure: " + s);
                    if (objectId == null) {
                        if(flag==1){
                          //  Toast.makeText(HoltelDetileActivity.this, "收藏成功！", Toast.LENGTH_SHORT).show();
                            hotel_collecte.setText("已收藏");
                            hotel_collecte.setChecked(true);
                           flag=0;
                        }else{
                            //Toast.makeText(HoltelDetileActivity.this, "取消收藏！", Toast.LENGTH_SHORT).show();
                            hotel_collecte.setChecked(false);
                            hotel_collecte.setText("收藏");
                            flag=1;
                        }
                    } else {
                        collect.setObjectId(objectId);
                        collect.delete(HoltelDetileActivity.this, new DeleteListener() {
                            @Override
                            public void onSuccess() {
                                // TODO Auto-generated method stub
                                hotel_collecte.setText("收藏");
                                //Toast.makeText(HoltelDetileActivity.this, "取消收藏！", Toast.LENGTH_SHORT).show();
                                hotel_collecte.setChecked(false);
                            }

                            @Override
                            public void onFailure(int code, String msg) {
                                // TODO Auto-generated method stub
                                //  Log.d("xyc", "onFailure: " + msg);
                            }
                        });
                    }
                }
            });

        } else {
            //缓存用户对象为空时， 可打开用户注册界面…
            Intent intent = new Intent(HoltelDetileActivity.this, LoginActivity.class);
            startActivity(intent);
        }

    }

    class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            return NetUtils.getData(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            if (s.equals("ERROR")) {
                Toast.makeText(HoltelDetileActivity.this, "网络连接超时！", Toast.LENGTH_SHORT).show();
            } else {
                list = JsonUtis.PaseJsonListview(s);
                MyAdapter_detile_listview adapter = new MyAdapter_detile_listview(HoltelDetileActivity.this, HoltelDetileActivity.this.list);
                int count = adapter.getCount();
                int totalheight = 0;
                for (int i = 0; i < count; i++) {
                    View view = adapter.getView(i, null, listview);
                    view.measure(0, 0);
                    int measuredHeight = view.getMeasuredHeight();
                    totalheight += measuredHeight;
                }
                ViewGroup.LayoutParams layoutParams = listview.getLayoutParams();
                int dividerHeight = listview.getDividerHeight();
                layoutParams.height = totalheight + dividerHeight;
                listview.setLayoutParams(layoutParams);
                listview.requestLayout();
                listview.setAdapter(adapter);

                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        BmobUser bmobUser = BmobUser.getCurrentUser(getApplicationContext());
                        if (bmobUser != null) {
                            String room_type = list.get(position).getTitle();
                            // String room_type=list.get(position).getBed();
                            totalprice = list.get(position).getTotalprice();
                            jiangjin = list.get(position).getJiangjin();
                            Intent intent = new Intent(HoltelDetileActivity.this, HotelOrderActivity.class);
                            intent.putExtra("address", address);
                            intent.putExtra("hotelname", hotelname);
                            intent.putExtra("room_type", room_type);
                            //  intent.putExtra("room_type",room_type);
                            intent.putExtra("totalprice", totalprice);
                            intent.putExtra("jiangjin", jiangjin);
                            startActivity(intent);
                            // Toast.makeText(HoltelDetileActivity.this,list.get(position).getTitle().toString(),Toast.LENGTH_SHORT).show();
                        }else {
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        }

                    }
                });
            }
        }
    }

    class Mytask2 extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            return NetUtils.getData(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            if (s.equals("ERROR")) {
                Toast.makeText(HoltelDetileActivity.this, "网络连接超时！", Toast.LENGTH_SHORT).show();
            } else {
                List<MyEntity_hotel> listhotel = JsonUtis.PasejsonHoltel(s);
                myEntity_hotel = listhotel.get(0);
                hotelname = myEntity_hotel.getHotelname();
                detile_item_hotel_name.setText(hotelname);
                detile_comment_scores.setText(myEntity_hotel.getComment_scores());
                detile_comment_count.setText(myEntity_hotel.getComment_count());
                xingji.setText(myEntity_hotel.getXingji());
                open_time.setText(myEntity_hotel.getZhuangxiu());
                address = myEntity_hotel.getAddress();
                detile_location.setText(address);
                strs = myEntity_hotel.getPictures();
                Detile_Viewpager adapter = new Detile_Viewpager(strs, HoltelDetileActivity.this, ids);
                viewPager.setOffscreenPageLimit(2);
                viewPager.setAdapter(adapter);

            }
        }
    }
}
