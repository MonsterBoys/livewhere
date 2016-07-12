package com.xu.hasee.livewhere.myinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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

public class RegisterActivity extends AppCompatActivity {

    private EditText register_mobilenum;
    private EditText register_password;
    private ImageView register_back;
    private EditText register_comfirm_password;
    private Toast toast;
    private LayoutInflater inflater;
    private View view;
    private String tips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button register_btn = (Button) findViewById(R.id.register_btn);
        register_mobilenum = ((EditText) findViewById(R.id.register_mobilenum));
        register_password = ((EditText) findViewById(R.id.register_password));
        register_comfirm_password = ((EditText) findViewById(R.id.register_comfirm_password));

        register_btn.setOnClickListener(new View.OnClickListener() {
            private String pwd;
            private String confirmpwd;
            private String mobilenum;

            @Override
            public void onClick(View v) {
                mobilenum = register_mobilenum.getText().toString().trim();
                pwd = register_password.getText().toString().trim();
                confirmpwd = register_comfirm_password.getText().toString().trim();
                if (check(mobilenum,pwd,confirmpwd)) {
                    User user = new User();
                    user.setMobilePhoneNumber(mobilenum);
                    user.setUsername(mobilenum);
                    user.setPassword(pwd);
                    user.setSex("女");
                    user.signUp(RegisterActivity.this, new SaveListener() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG)
                                    .show();

                            RegisterActivity.this.finish();
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            Toast.makeText(RegisterActivity.this, "注册失败：" + s,
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

        register_back = ((ImageView) findViewById(R.id.register_back));
        register_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public boolean check(String username, String password, String confirmpassword) {
        if ("".equals(username)) {
            tips = "手机号不能为空";
            Toastset(tips);
            return false;
        }
        if (username.length() < 11) {
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
        if (!(password.equals(confirmpassword))) {
            tips = "两次密码输入不一致";
            Toastset(tips);
            return false;
        }
        if (!isMobileNO(username)){
            tips = "请输入正确的手机号码";
            Toastset(tips);
            return  false;
        }


        return true;
    }

    private void Toastset(String str) {
        toast = Toast.makeText(RegisterActivity.this, "", Toast.LENGTH_SHORT);
        inflater = getLayoutInflater();
        view = inflater.inflate(R.layout.toast_ll,null);
        ((TextView) view.findViewById(R.id.toast_tv)).setText(str);
        toast.setView(view);
        toast.show();
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles))
            return false;
        else
            return mobiles.matches(telRegex);
    }
}
