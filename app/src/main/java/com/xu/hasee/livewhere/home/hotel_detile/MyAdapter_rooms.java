package com.xu.hasee.livewhere.home.hotel_detile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xu.hasee.livewhere.R;

import java.util.List;

/**
 * Created by hasee on 2016/5/19.
 */
public class MyAdapter_rooms extends BaseAdapter {
    private Context context;
    private List<String> list;
    private LayoutInflater inflater;

    public MyAdapter_rooms(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
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
        ViewHolder holder;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.rooms_item,null);
            holder=new ViewHolder();
            holder.textview= ((TextView) convertView.findViewById(R.id.rooms_item_tv));
            convertView.setTag(holder);
        }else {
           holder= ((ViewHolder) convertView.getTag());
        }
        holder.textview.setText(list.get(position));
        return convertView;
    }
    class ViewHolder{
        TextView textview;
    }
}
