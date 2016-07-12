package com.xu.hasee.livewhere.home.near_hotel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.home.near_hotel.entity.NearItem;

import java.util.List;

/**
 * Created by Administrator on 2016/5/19.
 */
public class NearHotelAdapter extends BaseAdapter {

    private Context context;
    private List<NearItem>list;
    private LayoutInflater inflater;

    public NearHotelAdapter(Context context, List<NearItem> list) {
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
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.nearhotel_item,null);
            viewHolder=new ViewHolder();
            viewHolder.picture= ((ImageView) convertView.findViewById(R.id.hotel_pic));
            viewHolder.hotelname= ((TextView) convertView.findViewById(R.id.hotel_name));
            viewHolder.type_xingji= ((TextView) convertView.findViewById(R.id.hotel_type));
            viewHolder.esdname= ((TextView) convertView.findViewById(R.id.esdname));
            viewHolder.comment_count= ((TextView) convertView.findViewById(R.id.comment_counts));
            viewHolder.comment_scores= ((TextView) convertView.findViewById(R.id.comment_scores));
            viewHolder.price_min_jiage= ((TextView) convertView.findViewById(R.id.price));
            viewHolder.juli= ((TextView) convertView.findViewById(R.id.juli));

            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        NearItem item=list.get(position);
        Picasso.with(context).load(item.getPic153()).into(viewHolder.picture);
        viewHolder.hotelname.setText(item.getHotelname());
        viewHolder.type_xingji.setText(item.getXingji());
        viewHolder.esdname.setText(item.getEsdname());
        viewHolder.comment_count.setText(item.getComment_count());
        viewHolder.comment_scores.setText(item.getComment_scores());
        viewHolder.price_min_jiage.setText(item.getMin_jiage());
        double d = Double.parseDouble(item.getJuli());
        viewHolder.juli.setText(String.valueOf(d*1000));

        return convertView;
    }

    class ViewHolder{
        private ImageView picture;
        private TextView hotelname,type_xingji,esdname,comment_count,
                comment_scores,price_min_jiage,juli;
    }

}
