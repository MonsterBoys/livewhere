package com.xu.hasee.livewhere.home.timehotel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xu.hasee.livewhere.R;

import java.util.List;

/**
 * Created by Administrator on 2016/5/20 0020.
 */
public class TimeHotelAdapters extends BaseAdapter {
    private Context context;
    private List<TimeHotelEntitys> list;
    private LayoutInflater inflater;

    public TimeHotelAdapters(Context context, List<TimeHotelEntitys> list) {
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
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.timehotel_lv_item, null);
            holder = new ViewHolder();
            holder.pic153 = (ImageView) convertView.findViewById(R.id.pic153);
            holder.hotelname = (TextView) convertView.findViewById(R.id.hotelname);
            holder.comment_scores = (TextView) convertView.findViewById(R.id.comment_scores);
            holder.comment_count = (TextView) convertView.findViewById(R.id.comment_count);
            holder.xingji = (TextView) convertView.findViewById(R.id.xingji);
            holder.price = (TextView) convertView.findViewById(R.id.price);
            holder.unit = (TextView) convertView.findViewById(R.id.unit);
            holder.address= ((TextView) convertView.findViewById(R.id.address));
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        TimeHotelEntitys timeHotelEntitys = list.get(position);
        Picasso.with(context).load(timeHotelEntitys.getPic153()).into(holder.pic153);
        holder.hotelname.setText(timeHotelEntitys.getHotelname());
        holder.comment_scores.setText(timeHotelEntitys.getComment_scores());
        holder.comment_count.setText(timeHotelEntitys.getComment_count() + "");
        holder.xingji.setText(timeHotelEntitys.getXingji());
        holder.price.setText(timeHotelEntitys.getPrice());
        holder.unit.setText(timeHotelEntitys.getUnit());
        holder.address.setText(timeHotelEntitys.getEsdname());
        return convertView;
    }

    class ViewHolder {
        private ImageView pic153;
        private TextView hotelname,address, comment_scores, comment_count, xingji, price, unit;

    }

}
