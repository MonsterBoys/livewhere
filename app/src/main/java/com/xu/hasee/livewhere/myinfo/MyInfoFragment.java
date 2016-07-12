package com.xu.hasee.livewhere.myinfo;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xu.hasee.livewhere.R;

import cn.bmob.v3.BmobUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyInfoFragment extends Fragment {


    private View view;
    private ImageView header_photo;
    private TextView login_register;
    private  Handler mhandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            BmobUser bmobUser = BmobUser.getCurrentUser(getActivity());
            if(bmobUser != null){
                // 允许用户使用应用
                //String objectId = (String) BmobUser.getObjectByKey(getActivity(), "objectId");
                //通过objectId来实现数据库的增删查改
                header_photo.setImageResource(R.drawable.zhuna_img);
                String username = (String) BmobUser.getObjectByKey(getActivity(), "username");
                username = username.substring(0,3)+"****"+username.substring(7,11);
                login_register.setText(username);
            }else{
                //缓存用户对象为空时， 可打开用户注册界面…
                header_photo.setImageResource(R.drawable.zhuna_imgoff);
                login_register.setText("登录/注册");
            }
        }
    };
    public MyInfoFragment() {
        // Required empty public constructor
    }
    public void loginstate(){
        mhandler.sendEmptyMessage(0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_info,null);
        initView();


        return view;
    }

    private void initView() {



        header_photo = ((ImageView) view.findViewById(R.id.header_photo));
        header_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser bmobUser = BmobUser.getCurrentUser(getActivity());
                if(bmobUser != null){
                    // 允许用户使用应用
                    Intent  PersonInintent = new Intent(getActivity(), PersonInfoActivity.class);
                    startActivityForResult(PersonInintent,1);
                }else{
                    //缓存用户对象为空时， 可打开用户注册界面…
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        /****************登录注册****************/
        login_register = (TextView) view.findViewById(R.id.infoFrag_login_register);

        login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BmobUser bmobUser = BmobUser.getCurrentUser(getActivity());
                if(bmobUser != null){
                    // 允许用户使用应用

                }else{
                    //缓存用户对象为空时， 可打开用户注册界面…
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivityForResult(intent,1);
                }



            }
        });

        /****************全部订单****************/
        TextView all_order = (TextView) view.findViewById(R.id.all_order);
        all_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OrderActivity.class);
                startActivity(intent);
            }
        });

        /****************个人账户****************/

        TextView personal_count = (TextView) view.findViewById(R.id.personal_count);
        personal_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(getActivity(),MoreActivity.class);
                startActivity(intent);*/
            }
        });
        /****************我的收藏****************/

        TextView my_collections = (TextView) view.findViewById(R.id.my_collections);
        my_collections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MyCollectListintent = new Intent(getActivity(),MyCollectListActivity.class);
                startActivity(MyCollectListintent);
            }
        });
          /****************我的点评****************/

        TextView my_comment = (TextView) view.findViewById(R.id.my_comment);
        my_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Commentintent = new Intent(getActivity(),CommentActivity.class);
                startActivity(Commentintent);
            }
        });
          /****************我的传图****************/

        TextView my_pic = (TextView) view.findViewById(R.id.my_pic);
        my_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(getActivity(),MoreActivity.class);
                startActivity(intent);*/
            }
        });
          /****************常驻酒店****************/

        TextView my_holtel = (TextView) view.findViewById(R.id.my_holtel);
        my_holtel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MyHotelintent = new Intent(getActivity(),MyHotelActivity.class);
                startActivity(MyHotelintent);
            }
        });
             /****************常用信用卡****************/

        TextView my_card = (TextView) view.findViewById(R.id.my_card);
        my_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MyBandCardintent = new Intent(getActivity(),MyBandCardActivity.class);
                startActivity(MyBandCardintent);
            }
        });
             /****************更多****************/

        TextView more = (TextView) view.findViewById(R.id.more);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MoreActivity.class);
                startActivity(intent);
            }
        });


        BmobUser bmobUser = BmobUser.getCurrentUser(getActivity());
        if(bmobUser != null){
            // 允许用户使用应用

            header_photo.setImageResource(R.drawable.zhuna_img);
            String username = (String) BmobUser.getObjectByKey(getActivity(), "username");
            username = username.substring(0,3)+"****"+username.substring(7,11);
            login_register.setText(username);


        }else{
            //缓存用户对象为空时， 可打开用户注册界面…

        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode==1){

            BmobUser bmobUser = BmobUser.getCurrentUser(getActivity());
            if(bmobUser != null){
                // 允许用户使用应用
                //String objectId = (String) BmobUser.getObjectByKey(getActivity(), "objectId");
                //通过objectId来实现数据库的增删查改
                header_photo.setImageResource(R.drawable.zhuna_img);
                String username = (String) BmobUser.getObjectByKey(getActivity(), "username");
                username = username.substring(0,3)+"****"+username.substring(7,11);
                login_register.setText(username);



            }else{
                //缓存用户对象为空时， 可打开用户注册界面…
                header_photo.setImageResource(R.drawable.zhuna_imgoff);
                login_register.setText("登录/注册");
            }
        }



        super.onActivityResult(requestCode, resultCode, data);
    }
}
