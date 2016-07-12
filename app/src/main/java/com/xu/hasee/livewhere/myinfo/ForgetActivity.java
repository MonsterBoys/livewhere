package com.xu.hasee.livewhere.myinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xu.hasee.livewhere.R;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.UpdateListener;

public class ForgetActivity extends AppCompatActivity {

    private EditText forget_mobilenum;
    private EditText forget_password;
    private EditText forget_new_pwd;
    private Button forget_btn;
    private Toast toast;
    private LayoutInflater inflater;
    private View view;
    private String tips;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        forget_mobilenum = ((EditText) findViewById(R.id.forget_mobilenum));
        forget_password = ((EditText) findViewById(R.id.forget_password));
        forget_new_pwd = ((EditText) findViewById(R.id.forget_new_pwd));
        forget_btn = ((Button) findViewById(R.id.forget_btn));

        forget_btn.setOnClickListener(new View.OnClickListener() {
            private String new_pwd;
            private String pwd;
            private String mobilenum;

            @Override
            public void onClick(View v) {
                mobilenum = forget_mobilenum.getText().toString().trim();
                pwd = forget_password.getText().toString().trim();
                new_pwd = forget_new_pwd.getText().toString().trim();
                if (check(mobilenum, pwd)) {

                    BmobUser.updateCurrentUserPassword(getApplicationContext(), pwd, new_pwd, new UpdateListener() {

                        @Override
                        public void onSuccess() {
                            // TODO Auto-generated method stub
                            Toastset("密码修改成功，可以用新密码进行登录啦");

                            Log.i("smile", "密码修改成功，可以用新密码进行登录啦");
                            finish();
                        }

                        @Override
                        public void onFailure(int code, String msg) {
                            // TODO Auto-generated method stub
                            Log.i("smile", "密码修改失败：" + msg + "(" + code + ")");
                            Toastset("重置失败,请查看手机号码/密码是否正确");

                        }
                    });
                }

            }
        });
        ImageView forget_back = (ImageView) findViewById(R.id.forget_back);
        forget_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


    public boolean check(String phonenum, String password) {
        if ("".equals(phonenum)) {
            tips = "手机号不能为空";
            Toastset(tips);
            return false;
        }
        if (phonenum.length() < 11) {
            tips = "你输入的手机号长度不正确";
            Toastset(tips);
            return false;

        }
        if ("".equals(password)) {
            tips = "密码不能为空";
            Toastset(tips);
            return false;
        }
        if (password.length() < 6 && password.length() > 16) {
            tips = "密码长度在6-16个字符之间";
            Toastset(tips);
            return false;
        }


        return true;
    }

    private void Toastset(String str) {
        toast = Toast.makeText(ForgetActivity.this, "", Toast.LENGTH_SHORT);
        inflater = getLayoutInflater();
        view = inflater.inflate(R.layout.toast_ll, null);
        ((TextView) view.findViewById(R.id.toast_tv)).setText(str);
        toast.setView(view);
        toast.show();
    }
}
