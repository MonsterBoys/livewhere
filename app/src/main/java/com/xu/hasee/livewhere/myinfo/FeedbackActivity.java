package com.xu.hasee.livewhere.myinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xu.hasee.livewhere.Bean.Feedback;
import com.xu.hasee.livewhere.R;

import cn.bmob.v3.listener.SaveListener;

public class FeedbackActivity extends AppCompatActivity {
    private int randomcodenum;
    private EditText phonenum_et;
    private Button feedback_sub;
    private EditText feedback_content;
    private EditText feedback_code;

    private Toast toast;
    private LayoutInflater inflater;
    private View view;
    private String tips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        intiview();


    }

    private void intiview() {

        ((ImageView) findViewById(R.id.feedback_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //min+(int)(Math.random()*(max-min+1));
        randomcodenum = 1000 + (int) (Math.random() * (8999 + 1));
        ((TextView) findViewById(R.id.feedback_codenum_tv)).setText("" + randomcodenum);


        feedback_content = ((EditText) findViewById(R.id.feedback_content));
        phonenum_et = ((EditText) findViewById(R.id.feedback_phonenum));
        feedback_code = ((EditText) findViewById(R.id.feedback_code));
        feedback_sub = ((Button) findViewById(R.id.feedback_sub));
        feedback_sub.setOnClickListener(new View.OnClickListener() {
            private String contacts;
            private String content;

            @Override
            public void onClick(View v) {
                content = feedback_content.getText().toString().trim();
                contacts = phonenum_et.getText().toString().trim();
                if (check(content, contacts, feedback_code.getText().toString().trim())) {
                    Toastset("正在上传...请稍后");
                    Feedback feedback = new Feedback();
                    feedback.setContent(content);
                    feedback.setContacts(contacts);
                    feedback.save(FeedbackActivity.this, new SaveListener() {

                        @Override
                        public void onSuccess() {
                            //发送推送信息
                            Toastset("反馈信息已保存到服务器！");
                            finish();
                        }

                        @Override
                        public void onFailure(int code, String arg0) {
                            // TODO Auto-generated method stub
                            Toastset("保存反馈信息失败！"+arg0);

                        }
                    });
                }
            }
        });
    }

    private boolean check(String content, String phonenum, String codenum) {
        if ("".equals(phonenum)){
            Toastset("请输入手机号！");
            return  false;
        }
        if (phonenum.length()<11){
            Toastset("请输入正确的手机号码！");
            return false;
        }
        if (codenum.length()<4){
            Toastset("验证码输入有误");
            return false;
        }
        if (codenum.equals(randomcodenum)){
            Toastset("验证码输入有误");
            return false;
        }


        return true;
    }

    private void Toastset(String str) {
        toast = Toast.makeText(FeedbackActivity.this, "", Toast.LENGTH_SHORT);
        inflater = getLayoutInflater();
        view = inflater.inflate(R.layout.toast_ll, null);
        ((TextView) view.findViewById(R.id.toast_tv)).setText(str);
        toast.setView(view);
        toast.show();
    }
}
