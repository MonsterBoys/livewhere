package com.xu.hasee.livewhere;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xu.hasee.livewhere.home.HomeFragment;
import com.xu.hasee.livewhere.message.MessageFragment;
import com.xu.hasee.livewhere.myinfo.MyInfoFragment;
import com.xu.hasee.livewhere.phone.PhoneFragment;
import com.xu.hasee.livewhere.route.RouteFragment;

import java.util.List;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {

    private ImageView welcome_img;
    private TextView tv;
    private Handler mHandlr=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            welcome_img.setVisibility(View.GONE);
            rl_layout.setVisibility(View.VISIBLE);
        }
    };
    private RelativeLayout rl_layout;
    private FragmentManager manager;
    private List<Fragment> fragments;
    private RadioGroup rdg;
    private Fragment  currentFrgment;
    private MyInfoFragment myInfoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this,"0f03f96433b9be913fcd8337ea01dc18");
        //0f03f96433b9be913fcd8337ea01dc18
        welcome_img = ((ImageView) findViewById(R.id.welcome_img));
        rl_layout = ((RelativeLayout) findViewById(R.id.rl_layout));
        rdg = ((RadioGroup) findViewById(R.id.rdg));
        myInfoFragment = new MyInfoFragment();
        InitWelComePage();
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        currentFrgment=new HomeFragment();
        transaction.add(R.id.fg_ll,currentFrgment);
        transaction.commit();
        rdg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            private Fragment fragment = null;

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.home_btn:
                        fragment = new HomeFragment();
                        break;
                    case R.id.route:
                        fragment = new RouteFragment();
                        break;
                    case R.id.myinfo:
                        fragment = myInfoFragment;
                        break;
                    case R.id.message:
                        fragment = new MessageFragment();
                        break;
                    case R.id.phone:
                        fragment = new PhoneFragment();
                        break;
                }
                FragmentTransaction transaction = manager.beginTransaction();
                if(fragment.isAdded()){
                    transaction.hide(currentFrgment).show(fragment);
                    currentFrgment=fragment;
                }else
                {
                    transaction.hide(currentFrgment).add(R.id.fg_ll,fragment).show(fragment);
                    currentFrgment=fragment;
                }
                transaction.commit();
            }
        });
    }

    private void InitWelComePage() {
         new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                   mHandlr.sendEmptyMessage(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 1) {

            myInfoFragment.loginstate();

        }
    }

    private long timeMillis;
    //点击后退键时,确认是否要退出

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK&& event.getAction()==KeyEvent.ACTION_DOWN){
            if ((System.currentTimeMillis()-timeMillis)>2000){
                Toast.makeText(this,"确定要退出吗?",Toast.LENGTH_SHORT).show();
                timeMillis=System.currentTimeMillis();
            }else {
                finish();
                System.exit(0);
            }
            return  true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
