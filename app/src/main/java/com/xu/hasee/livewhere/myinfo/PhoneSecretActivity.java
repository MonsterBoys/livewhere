package com.xu.hasee.livewhere.myinfo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.myinfo.weight.RoundProgressBarWidthNumber;

public class PhoneSecretActivity extends AppCompatActivity {

    private RoundProgressBarWidthNumber Roundprogressbar;
    private static final int MSG_PROGRESS_UPDATE = 0x110;
    private int randomnum;
    private Handler mhandler = new Handler(){
        private int progress;

        @Override
        public void handleMessage(Message msg) {

            progress = Roundprogressbar.getProgress();
            Roundprogressbar.setProgress(++progress);
            if (progress >= 60) {
                progress=progress-60;
                Roundprogressbar.setProgress(progress);
                initdata();
                setnum();

            }
            mhandler.sendEmptyMessageDelayed(MSG_PROGRESS_UPDATE, 10);
        }
    };
    private ImageView number_one;
    private ImageView number_two;
    private ImageView number_three;
    private ImageView number_four;
    private ImageView number_five;
    private ImageView number_six;
    private int six;
    private int five;
    private int four;
    private int three;
    private int two;
    private int one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_secret);
        initdata();
        initView();

    }

    private void initdata() {
        randomnum = 100000 + (int) (Math.random() * (899999 + 1));
        six = randomnum%10;
        five = (randomnum/10)%10;
        four = (randomnum/100)%10;
        three = (randomnum/1000)%10;
        two = (randomnum/10000)%10;
        one = (randomnum/100000)%10;


    }

    private void initView() {
        ((ImageView) findViewById(R.id.secret_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Roundprogressbar = ((RoundProgressBarWidthNumber) findViewById(R.id.Roundprogressbar));
        mhandler.sendEmptyMessage(MSG_PROGRESS_UPDATE);


        number_one = ((ImageView) findViewById(R.id.number_one));
        number_two = ((ImageView) findViewById(R.id.number_two));
        number_three = ((ImageView) findViewById(R.id.number_three));
        number_four = ((ImageView) findViewById(R.id.number_four));
        number_five = ((ImageView) findViewById(R.id.number_five));
        number_six = ((ImageView) findViewById(R.id.number_six));
        setnum();




    }

    private void setnum() {
        number_one.setImageResource(selectnum(one));
        number_two.setImageResource(selectnum(two));
        number_three.setImageResource(selectnum(three));
        number_four.setImageResource(selectnum(four));
        number_five.setImageResource(selectnum(five));
        number_six.setImageResource(selectnum(six));
    }

    public int selectnum(int num){
        if (num==1){
            return R.drawable.otp_number_one;
        }
        if (num==2){
            return R.drawable.otp_number_two;
        }
        if (num==3){
            return R.drawable.otp_number_three;
        }
        if (num==4){
            return R.drawable.otp_number_four;
        }
        if (num==5){
            return R.drawable.otp_number_five;
        }
        if (num==6){
            return R.drawable.otp_number_six;
        }

        if (num==7){
            return R.drawable.otp_number_seven;
        }
        if (num==8){
            return R.drawable.otp_number_eight;
        }
        if (num==9){
            return R.drawable.otp_number_nine;
        }
        if (num==0){
            return R.drawable.otp_number_zero;
        }



        return R.drawable.otp_number_one;

    }
}
