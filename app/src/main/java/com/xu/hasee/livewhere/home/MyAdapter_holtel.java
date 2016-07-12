package com.xu.hasee.livewhere.home;

import android.content.Context;
import android.util.Log;
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
 * Created by hasee on 2016/5/12.
 */
public class MyAdapter_holtel extends BaseAdapter {
    private Context context;
    private List<MyEntity_hotelInfo> list;
    private LayoutInflater inflater;

    public MyAdapter_holtel(Context context, List<MyEntity_hotelInfo> list) {
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
       ViewHolder holder;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.fragment_item,null);
            holder=new ViewHolder();
            holder.hotel_pic= ((ImageView) convertView.findViewById(R.id.hotel_pic));
            holder.hotel_name= ((TextView) convertView.findViewById(R.id.hotel_name));
            holder.comment_scores= ((TextView) convertView.findViewById(R.id.comment_scores));
            holder.comment_counts= ((TextView) convertView.findViewById(R.id.comment_counts));
            holder.hotel_type= ((TextView) convertView.findViewById(R.id.hotel_type));
            holder.esdname= ((TextView) convertView.findViewById(R.id.esdname));
            holder.price= ((TextView) convertView.findViewById(R.id.price));
            convertView.setTag(holder);
        }else
        {
           holder= (ViewHolder) convertView.getTag();
        }
        MyEntity_hotelInfo MyEntity=list.get(position);
        holder.hotel_name.setText(MyEntity.getHotelname());
        holder.comment_scores.setText(MyEntity.getComment_scores());
        holder.comment_counts.setText(MyEntity.getComment_count());
        holder.hotel_type.setText(MyEntity.getXingji());
        holder.esdname.setText(MyEntity.getEsdname());
        holder.price.setText(MyEntity.getMin_jiage());
        Picasso.with(context).load(MyEntity.getPic153()).into(holder.hotel_pic);
        return convertView;
    }
    class ViewHolder{
        ImageView hotel_pic;
        TextView hotel_name;
        TextView comment_scores;
        TextView comment_counts;
        TextView hotel_type;
        TextView esdname;
        TextView price;
    }
}
