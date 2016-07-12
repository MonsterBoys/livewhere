package com.xu.hasee.livewhere.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xu.hasee.livewhere.Bean.Collect;
import com.xu.hasee.livewhere.R;


import java.util.List;

/**
 * Created by hasee on 2016/5/20.
 */
public class MyAdapter_collection extends BaseAdapter {
    private List<Collect> list;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter_collection(List<Collect> list, Context context) {
        this.list = list;
        this.context = context;
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.collection_list_item, null);
            holder = new ViewHolder();
            holder.item_hotelname = ((TextView) convertView.findViewById(R.id.item_hotelname));
            holder.item_image = ((ImageView) convertView.findViewById(R.id.item_image));
            holder.item_comment_scores = ((TextView) convertView.findViewById(R.id.item_comment_scores));
            holder.item_xingji = ((TextView) convertView.findViewById(R.id.item_xingji));
            holder.item_address = ((TextView) convertView.findViewById(R.id.item_address));
            holder.item_price = ((TextView) convertView.findViewById(R.id.item_price));
            convertView.setTag(holder);
        } else {
            holder = ((ViewHolder) convertView.getTag());
        }
        Collect collect=list.get(position);
        holder.item_hotelname.setText(collect.getHotelname());
        holder.item_address.setText(collect.getAddress());
        holder.item_comment_scores.setText(collect.getScores()+"分");
        holder.item_price.setText(collect.getPrice());
        holder.item_xingji.setText(collect.getXingji());
        String pic153 = collect.getPic153();
        Picasso.with(context).load(pic153).into(holder.item_image);
        return convertView;
    }

    class ViewHolder {
        ImageView item_image;
        TextView item_hotelname;
        TextView item_comment_scores;
        TextView item_xingji;
        TextView item_address;
        TextView item_price;
    }
}
