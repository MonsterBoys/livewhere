package com.xu.hasee.livewhere.home.hotel_detile.hotel_info;

import android.content.Context;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xu.hasee.livewhere.R;

import java.util.List;

/**
 * Created by hasee on 2016/5/17.
 */
public class MyAdapter_traffics extends BaseAdapter {
    private Context context;
    private List<MyEntity_traffic> list;
    private LayoutInflater inflater;

    public MyAdapter_traffics(Context context, List<MyEntity_traffic> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holdler;
        if (convertView == null) {
            convertView=inflater.inflate(R.layout.traffics_item_layout,null);
            holdler=new ViewHolder();
            holdler.traffic_name= ((TextView) convertView.findViewById(R.id.traffic_name));
            holdler.traffic_distance= ((TextView) convertView.findViewById(R.id.traffic_distance));
            holdler.time_minute= ((TextView) convertView.findViewById(R.id.time_minute));
            holdler.dayPrice_yuan= ((TextView) convertView.findViewById(R.id.dayPrice_yuan));
            convertView.setTag(holdler);
        }else {
          holdler= ((ViewHolder) convertView.getTag());
        }
        MyEntity_traffic myEntity_traffic=list.get(position);
          holdler.traffic_name.setText(myEntity_traffic.getTraffic_name());
         holdler.traffic_distance.setText(myEntity_traffic.getDistance_km()+"公里");
         holdler.time_minute.setText("搭乘出租车约"+myEntity_traffic.getTime_minute()+"分钟可到达，");
         holdler.dayPrice_yuan.setText("费用约为"+myEntity_traffic.getDayPrice_yuan()+"元");
        return convertView;
    }

    class ViewHolder {
        TextView traffic_name;
        TextView traffic_distance;
        TextView time_minute;
        TextView dayPrice_yuan;
    }
}
