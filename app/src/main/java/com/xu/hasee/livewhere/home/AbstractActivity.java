package com.xu.hasee.livewhere.home;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.xu.hasee.livewhere.MainActivity;
import com.xu.hasee.livewhere.NetUtils;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.UrlPath;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AbstractActivity extends AppCompatActivity {

    private EditText abstract_edt;
    private ImageView abstract_back;
    private String cityid;
    private List<MyEntity_hotelname> list;
    private String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abstract);
        abstract_edt = ((EditText) findViewById(R.id.abstract_edt));
        abstract_back = ((ImageView) findViewById(R.id.abstract_back));

        abstract_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbstractActivity.this.finish();
            }
        });
        initData();
        Intent intent = getIntent();
        cityid = intent.getStringExtra("cityid");
        flag = intent.getStringExtra("flag");
    }

    public void initData() {
        abstract_edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String url = String.format(UrlPath.abstract_holtel_name, cityid, s.toString());
                MyTaskForHoltel myTaskForHoltel = new MyTaskForHoltel();
                myTaskForHoltel.execute(url);
            }
        });
    }

    class MyTaskForHoltel extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            return NetUtils.getData(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                list = new ArrayList<>();
                JSONObject obj = new JSONObject(s);
                String msg = obj.getString("msg");
                JSONObject result = obj.getJSONObject("result");
                JSONArray hotel = result.getJSONArray("hotel");
                for (int i = 0; i < hotel.length(); i++) {
                    JSONObject data = hotel.getJSONObject(i);
                    String hotelname = data.getString("hotelname");
                    // Log.d("xyc", "onPostExecute: "+hotelname);
                    String hotelid = data.getString("hotelid");
                    list.add(new MyEntity_hotelname(hotelname, hotelid));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            View view = LayoutInflater.from(AbstractActivity.this).inflate(R.layout.abstract_popup, null);
            final ListView listview = ((ListView) view.findViewById(R.id.listview));
            MyAdapter_abstract adapter = new MyAdapter_abstract(AbstractActivity.this, list);
            listview.setAdapter(adapter);
            final PopupWindow pw = new PopupWindow(view, abstract_edt.getWidth(), ActionBar.LayoutParams.MATCH_PARENT);
            // pw.setOutsideTouchable(true);
            pw.setBackgroundDrawable(new BitmapDrawable());
            pw.setFocusable(true);
            pw.showAsDropDown(abstract_edt);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent();
                    intent.putExtra("hotel_name", list.get(position).getHotelname());
                    intent.putExtra("hotelid", list.get(position).getHotelid());
                    setResult(0, intent);
                    if (flag != null) {
                         Intent intent2=new Intent(AbstractActivity.this,SearchHotelActivity.class);
                        intent2.putExtra("hotelid", list.get(position).getHotelid());
                        intent2.putExtra("hotel_name", list.get(position).getHotelname());
                        startActivity(intent2);
                       AbstractActivity.this.finish();
                    } else {
                        AbstractActivity.this.finish();
                    }

                    pw.dismiss();
                }
            });

        }
    }


}
