package com.xu.hasee.livewhere.home.timehotel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.xu.hasee.livewhere.R;

import java.util.List;

/**
 * Created by Administrator on 2016/5/20 0020.
 */
public class TimeHotelInfoAdapters extends BaseAdapter {
    private Context context;
    private List<TimeHotelInfoEntitys> list;
    private LayoutInflater inflater;

    public TimeHotelInfoAdapters(Context context, List<TimeHotelInfoEntitys> list) {
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
            convertView = inflater.inflate(R.layout.timehotelinfo_gv_item, null);
            holder = new ViewHolder();
            holder.picsmall = (ImageView) convertView.findViewById(R.id.picsmall);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        TimeHotelInfoEntitys timeHotelInfoEntitys = list.get(position);
        Picasso.with(context).load(timeHotelInfoEntitys.getPicsmall()).into(holder.picsmall);

        return convertView;
    }

    class ViewHolder {
        private ImageView picsmall;

    }
}
