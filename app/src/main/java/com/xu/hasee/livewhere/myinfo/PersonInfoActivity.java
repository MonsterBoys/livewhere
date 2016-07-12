package com.xu.hasee.livewhere.myinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xu.hasee.livewhere.R;

import cn.bmob.v3.BmobUser;

public class PersonInfoActivity extends AppCompatActivity {

    private Button outlogin;
    private TextView person_info_zhanghao;
    private TextView person_info_name;
    private TextView person_info_nickname;
    private TextView person_info_sex;
    private TextView person_info_birthday;
    private TextView person_info_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        initview();
        initdata();
    }


    private void initview() {
        outlogin = ((Button) findViewById(R.id.outlogin));
        outlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser.logOut(getApplicationContext());
                PersonInfoActivity.this.setResult(1);
                PersonInfoActivity.this.finish();
            }
        });
        ImageView person_info_back = (ImageView) findViewById(R.id.person_info_back);
        person_info_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        person_info_zhanghao = ((TextView) findViewById(R.id.person_info_zhanghao));
        person_info_name = ((TextView) findViewById(R.id.person_info_name));
        person_info_nickname = ((TextView) findViewById(R.id.person_info_nickname));
        person_info_sex =  ((TextView) findViewById(R.id.person_info_sex));
        person_info_birthday = ((TextView) findViewById(R.id.person_info_birthday));
        person_info_email = ((TextView) findViewById(R.id.person_info_email));
        ImageView person_info_fix = (ImageView) findViewById(R.id.person_info_fix);
        person_info_fix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent EditPersonInfointent = new Intent(PersonInfoActivity.this, EditPersonInfoActivity.class);
                startActivity(EditPersonInfointent);
            }
        });


    }
    private void initdata() {
        String username = (String) BmobUser.getObjectByKey(getApplicationContext(), "username");
        person_info_zhanghao.setText(subStirng(username));

        String name = (String) BmobUser.getObjectByKey(getApplicationContext(), "name");
        if (name==null){
            person_info_name.setText(subStirng(username));
        }else{
            person_info_name.setText(name);
        }

        String nickname = (String) BmobUser.getObjectByKey(getApplicationContext(), "nickname");
        if (nickname==null){
            person_info_nickname.setText(subStirng(username));

        }else{
            person_info_nickname.setText(nickname);

        }
        person_info_sex.setText((String) BmobUser.getObjectByKey(getApplicationContext(), "sex"));
        person_info_birthday.setText((String) BmobUser.getObjectByKey(getApplicationContext(), "birthday"));
        person_info_email.setText((String) BmobUser.getObjectByKey(getApplicationContext(), "email"));
    }
    private String subStirng(String str){
        str =str.substring(0,3)+"****"+str.substring(7,str.length());
        return  str;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode==2){
            person_info_name.setText(data.getStringExtra("name"));
            person_info_nickname.setText(data.getStringExtra("nickname"));
            person_info_sex.setText(data.getStringExtra("sex"));
            person_info_birthday.setText(data.getStringExtra("birthday"));
            person_info_email.setText(data.getStringExtra("email"));
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}
