package com.xu.hasee.livewhere.myinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xu.hasee.livewhere.Bean.User;
import com.xu.hasee.livewhere.R;

import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity {

    private Button login_btn;
    private EditText login_mobilenum;
    private EditText login_password;
    private boolean islogin;
    private Toast toast;
    private LayoutInflater inflater;
    private View view;
    private String tips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_mobilenum = ((EditText) findViewById(R.id.login_mobilenum));
        login_password = ((EditText) findViewById(R.id.login_password));


        login_btn = ((Button) findViewById(R.id.login_btn));
        login_btn.setOnClickListener(new View.OnClickListener() {
            private String pwd;
            private String phonenum;

            @Override
            public void onClick(View v) {
                phonenum = login_mobilenum.getText().toString().trim();
                pwd = login_password.getText().toString().trim();
                if (check(phonenum, pwd)) {
                    User user = new User();
                    user.setUsername(phonenum);
                    user.setPassword(pwd);
                    user.login(LoginActivity.this, new SaveListener() {
                        @Override
                        public void onSuccess() {

                            Toastset("登陆成功");
                            islogin = true;

                            LoginActivity.this.setResult(1);
                            LoginActivity.this.finish();
                        }
                        @Override
                        public void onFailure(int i, String s) {
                            Toastset("登陆失败!请检查手机号码/密码");
                            islogin = false;
                        }
                    });
                }
            }
        });
        TextView login_new_register = (TextView) findViewById(R.id.login_new_register);
        login_new_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        ImageView login_back = (ImageView) findViewById(R.id.login_back);
        login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView login_fixedpwd = (TextView) findViewById(R.id.login_fixedpwd);
        login_fixedpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetActivity.class);
                startActivity(intent);
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
        toast = Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT);
        inflater = getLayoutInflater();
        view = inflater.inflate(R.layout.toast_ll, null);
        ((TextView) view.findViewById(R.id.toast_tv)).setText(str);
        toast.setView(view);
        toast.show();
    }
}
