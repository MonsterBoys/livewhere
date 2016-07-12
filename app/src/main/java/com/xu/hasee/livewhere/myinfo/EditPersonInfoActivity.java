package com.xu.hasee.livewhere.myinfo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xu.hasee.livewhere.Bean.User;
import com.xu.hasee.livewhere.R;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.UpdateListener;

public class EditPersonInfoActivity extends AppCompatActivity {

    private int myear;
    private int month;
    private int day;
    private EditText edit_person_info_name;
    private EditText edit_person_info_nickname;
    private EditText edit_person_info_email;
    private TextView edit_person_info_sex;
    private TextView edit_person_info_birthday;
    private PopupWindow pw;
    private String sex;
    private RelativeLayout edit_person_info_rl;
    private Toast toast;
    private LayoutInflater inflater;
    private View view;


    private Handler mhandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    edit_person_info_sex.setText("男");
                    break;
                case 1:
                    edit_person_info_sex.setText("女");

                    break;
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_person_info);
        initview();
        initdata();
    }


    private void initview() {
        ImageView edit_person_info_back = (ImageView) findViewById(R.id.edit_person_info_back);
        edit_person_info_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Calendar mycalendar = Calendar.getInstance(Locale.CHINA);
        Date mydate = new Date(); //获取当前日期Date对象
        mycalendar.setTime(mydate);////为Calendar对象设置时间为当前日期

        myear = mycalendar.get(Calendar.YEAR);
        month = mycalendar.get(Calendar.MONTH);
        day = mycalendar.get(Calendar.DAY_OF_MONTH);
        RelativeLayout birthday_rl = (RelativeLayout) findViewById(R.id.birthday_rl);
        birthday_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 构造函数原型：
                 * public DatePickerDialog (Context context, DatePickerDialog.OnDateSetListener callBack,
                 * int year, int monthOfYear, int dayOfMonth)
                 * content组件运行Activity，
                 * DatePickerDialog.OnDateSetListener：选择日期事件
                 * year：当前组件上显示的年，monthOfYear：当前组件上显示的月，dayOfMonth：当前组件上显示的第几天
                 *
                 */
                //创建DatePickerDialog对象
                DatePickerDialog dpd = new DatePickerDialog(EditPersonInfoActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        //修改year、month、day的变量值，以便以后单击按钮时，DatePickerDialog上显示上一次修改后的值
                        myear = year;
                        month = monthOfYear;
                        day = dayOfMonth;

                        //更新日期
                        updateDate();
                    }

                    //当DatePickerDialog关闭时，更新日期显示
                    private void updateDate() {
                        //在TextView上显示日期
                        edit_person_info_birthday.setText(myear + "-" + (month + 1) + "-" + day);
                    }
                }, myear, month, day);
                dpd.show();//显示DatePickerDialog组件
            }
        });
        edit_person_info_name = (EditText) findViewById(R.id.edit_person_info_name);
        edit_person_info_nickname = (EditText) findViewById(R.id.edit_person_info_nickname);
        edit_person_info_email = (EditText) findViewById(R.id.edit_person_info_email);
        edit_person_info_sex = (TextView) findViewById(R.id.edit_person_info_sex);
        edit_person_info_birthday = (TextView) findViewById(R.id.edit_person_info_birthday);
        Button edit_success = (Button) findViewById(R.id.edit_success);
        edit_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                User newUser = new User();
                newUser.setName(edit_person_info_name.getText().toString().trim());
                newUser.setNickname(edit_person_info_nickname.getText().toString().trim());
                newUser.setSex(edit_person_info_sex.getText().toString().trim());
                newUser.setBirthday(edit_person_info_birthday.getText().toString().trim());
                newUser.setEmail(edit_person_info_email.getText().toString().trim());
                BmobUser bmobUser = BmobUser.getCurrentUser(getApplicationContext());
                newUser.update(getApplicationContext(),bmobUser.getObjectId(),new UpdateListener() {
                    @Override
                    public void onSuccess() {
                        // TODO Auto-generated method stub
                        Toastset("更新用户信息成功:");
                        //Toast.makeText(EditPersonInfoActivity.this, "更新用户信息成功:" , Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent();
                        intent.putExtra("name",edit_person_info_name.getText().toString().trim());
                        intent.putExtra("nickname",edit_person_info_nickname.getText().toString().trim());
                        intent.putExtra("sex",edit_person_info_sex.getText().toString().trim());
                        intent.putExtra("birthday",edit_person_info_birthday.getText().toString().trim());
                        intent.putExtra("email",edit_person_info_email.getText().toString().trim());
                        EditPersonInfoActivity.this.setResult(2, intent);
                        EditPersonInfoActivity.this.finish();
                    }
                    @Override
                    public void onFailure(int code, String msg) {
                        // TODO Auto-generated method stub
                        Toastset("更新用户信息失败:" + msg);
                        // Toast.makeText(EditPersonInfoActivity.this, "更新用户信息失败:" + msg, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        edit_person_info_rl = ((RelativeLayout) findViewById(R.id.edit_person_info_rl));
    }

    private void initdata() {
        String username = (String) BmobUser.getObjectByKey(getApplicationContext(), "username");
        String name = (String) BmobUser.getObjectByKey(getApplicationContext(), "name");
        if (name == null) {
            edit_person_info_name.setText(subStirng(username));
        } else {
            edit_person_info_name.setText(name);
        }

        String nickname = (String) BmobUser.getObjectByKey(getApplicationContext(), "nickname");
        if (nickname == null) {
            edit_person_info_nickname.setText(subStirng(username));

        } else {
            edit_person_info_nickname.setText(nickname);

        }
        sex = (String) BmobUser.getObjectByKey(getApplicationContext(), "sex");
        edit_person_info_sex.setText(sex);
        edit_person_info_birthday.setText((String) BmobUser.getObjectByKey(getApplicationContext(), "birthday"));
        edit_person_info_email.setText((String) BmobUser.getObjectByKey(getApplicationContext(), "email"));
        RelativeLayout sex_rl = (RelativeLayout) findViewById(R.id.sex_rl);
        sex_rl .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMenu();
            }
        });
    }

    private String subStirng(String str) {
        str = str.substring(0, 3) + "****" + str.substring(7, str.length());
        return str;
    }

    private void ShowMenu() {

        View view = LayoutInflater.from(EditPersonInfoActivity.this).inflate(R.layout.sex_selector_popupwindow, null);
        Button sex_nan = (Button) view.findViewById(R.id.sex_nan);
        Button sex_nv = (Button) view.findViewById(R.id.sex_nv);
        if (edit_person_info_sex.getText().toString().trim().equals("女")){
            sex_nv.setTextColor(Color.parseColor("#FFFFFF"));
            sex_nv.setBackgroundColor(Color.parseColor("#20D485"));
            sex_nan.setTextColor(Color.parseColor("#20D485"));
            sex_nan.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        if (edit_person_info_sex.getText().toString().trim().equals("男")){
            sex_nv.setTextColor(Color.parseColor("#20D485"));
            sex_nv.setBackgroundColor(Color.parseColor("#FFFFFF"));
            sex_nan.setTextColor(Color.parseColor("#FFFFFF"));
            sex_nan.setBackgroundColor(Color.parseColor("#20D485"));
        }



        pw = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, false);
        // 点击其他区域关闭Pw，必须给pw设置背景
        pw.setOutsideTouchable(true);
        pw.setBackgroundDrawable(new BitmapDrawable());
        // 设置让pw获得焦点
        pw.setFocusable(true);
        pw.setAnimationStyle(R.anim.push_bottom_in);
        sex_nan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mhandler.sendEmptyMessage(0);
                // 关闭Pw
                pw.dismiss();
            }
        });
        sex_nv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mhandler.sendEmptyMessage(1);
                // 关闭Pw
                pw.dismiss();
            }
        });

        if(pw.isShowing()) {
            // 隐藏窗口，如果设置了点击窗口外小时即不需要此方式隐藏
            pw.dismiss();
        } else {
            // 显示窗口
            pw.showAtLocation(edit_person_info_rl, Gravity.BOTTOM,0,0);

        }


    }
    private void Toastset(String str) {

        toast = Toast.makeText(EditPersonInfoActivity.this, "", Toast.LENGTH_SHORT);
        inflater = getLayoutInflater();
        view = inflater.inflate(R.layout.toast_ll, null);
        ((TextView) view.findViewById(R.id.toast_tv)).setText(str);
        toast.setView(view);
        toast.show();
    }


}
