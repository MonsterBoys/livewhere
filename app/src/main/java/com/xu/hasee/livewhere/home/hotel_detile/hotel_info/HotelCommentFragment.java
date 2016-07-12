package com.xu.hasee.livewhere.home.hotel_detile.hotel_info;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.xu.hasee.livewhere.JsonUtis;
import com.xu.hasee.livewhere.NetUtils;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelCommentFragment extends Fragment implements View.OnClickListener {


    private RadioButton btn1, btn2, btn3, btn4, btn5;
    private ExpandableListView lv;
    private RelativeLayout rl_layout;
    private String hotelid;
    private int hotelidint;

    public HotelCommentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hotel_comment, null);
        btn1 = ((RadioButton) view.findViewById(R.id.btn1));
        btn2 = ((RadioButton) view.findViewById(R.id.btn2));
        btn3 = ((RadioButton) view.findViewById(R.id.btn3));
        btn4 = ((RadioButton) view.findViewById(R.id.btn4));
        btn5 = ((RadioButton) view.findViewById(R.id.btn5));
        lv = (ExpandableListView) view.findViewById(R.id.lvv);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);

        Bundle extras = getArguments();
        String hotelid = extras.getString("hotelid");
        //Log.d("xyc", "onCreateView: "+hotelid);
        initBtn();
        return view;
    }

    private void initBtn() {
        btn1.setChecked(true);
        MyTask myTask = new MyTask();
        myTask.execute(UrlPath.all_comments);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                MyTask myTask1 = new MyTask();
                myTask1.execute(UrlPath.all_comments);
                break;
            case R.id.btn2:
                MyTask myTask2 = new MyTask();
                myTask2.execute(UrlPath.haopings);
                break;
            case R.id.btn3:
                MyTask myTask3 = new MyTask();
                myTask3.execute(UrlPath.zhongpings);
                break;
            case R.id.btn4:
                MyTask myTask4 = new MyTask();
                myTask4.execute(UrlPath.chaping);
                break;
            case R.id.btn5:
                MyTask myTask5 = new MyTask();
                myTask5.execute(UrlPath.youtu);
                break;
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
                Toast.makeText(getActivity(), "NetError", Toast.LENGTH_SHORT).show();
            } else {
                List<MyEntity_comments> myEntity_commentses = JsonUtis.PaseJsonComments(s);

               // Log.d("xyc", "onPostExecute: myEntity_commentses.get(0).getTotal()" + myEntity_commentses.get(0).getTotal());
                btn1.setText(myEntity_commentses.get(0).getTotal());
                btn2.setText(myEntity_commentses.get(0).getHaopings());
                btn3.setText(myEntity_commentses.get(0).getMidcnts());
                btn4.setText(myEntity_commentses.get(0).getBadcnts());
                btn5.setText(myEntity_commentses.get(0).getPiccnts());

                List<MyEntity_content> content = myEntity_commentses.get(0).getContent();
                MyAdapter_comments adapter_comments = new MyAdapter_comments(myEntity_commentses, getActivity());

                lv.setAdapter(adapter_comments);

                for (int i = 0; i < adapter_comments.getGroupCount(); i++) {
                    lv.expandGroup(i);
                }
                lv.setGroupIndicator(null);
                lv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                        return true;
                    }
                });
            }
        }
    }
}
