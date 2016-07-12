package com.xu.hasee.livewhere.home.hotel_detile;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.xu.hasee.livewhere.R;

import java.util.List;

/**
 * Created by hasee on 2016/5/14.
 */
public class MyAdapter_detile_listview extends BaseAdapter {
    private Context context;
    private List<MyEntity_list_item> list;
    private LayoutInflater inflater;

    public MyAdapter_detile_listview(Context context, List<MyEntity_list_item> list) {
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
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.hoteltype_list_item, null);
            holder = new ViewHolder();
            holder.list_item_pic = ((ImageView) convertView.findViewById(R.id.list_item_pic));
            holder.room_type = ((TextView) convertView.findViewById(R.id.room_type));
            holder.plansname = ((TextView) convertView.findViewById(R.id.plansname));
            holder.bed = ((TextView) convertView.findViewById(R.id.bed));
            holder.area = ((TextView) convertView.findViewById(R.id.area));
            holder.totalprice = ((TextView) convertView.findViewById(R.id.totalprice));
            holder.jiangjin = ((TextView) convertView.findViewById(R.id.jiangjin));
            convertView.setTag(holder);
        } else {
            holder = ((ViewHolder) convertView.getTag());
        }
        MyEntity_list_item myEntity= list.get(position);

        holder.jiangjin.setText(myEntity.getJiangjin());
        holder.plansname.setText(myEntity.getPlanname());
        holder.area.setText(myEntity.getArea());
        holder.totalprice.setText(myEntity.getTotalprice());
        holder.bed.setText(myEntity.getBed());
        holder.room_type.setText(myEntity.getTitle());
        Picasso.with(context).load(myEntity.getSpic()).into(holder.list_item_pic);
        return convertView;
    }

    class ViewHolder {
        ImageView list_item_pic;
        TextView room_type;
        TextView plansname;
        TextView area;
        TextView bed;
        TextView totalprice;
        TextView jiangjin;
    }
}
