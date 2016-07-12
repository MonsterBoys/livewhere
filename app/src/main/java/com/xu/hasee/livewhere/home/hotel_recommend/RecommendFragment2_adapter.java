package com.xu.hasee.livewhere.home.hotel_recommend;

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
 * Created by Administrator on 2016/5/18 0018.
 */
public class RecommendFragment2_adapter extends BaseAdapter {
    private Context context;
    private List<HaoRecommend_entitys> list;
    private LayoutInflater inflater;

    public RecommendFragment2_adapter(Context context, List<HaoRecommend_entitys> list) {
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
        if(convertView == null){
            convertView = inflater.inflate(R.layout.goodrecommend_listview_item,null);
            holder = new ViewHolder();
            holder.hotelname = (TextView) convertView.findViewById(R.id.hotelname);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.pic = (ImageView) convertView.findViewById(R.id.pic);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        HaoRecommend_entitys haoRecommend_entitys = list.get(position);
        holder.hotelname.setText(haoRecommend_entitys.getHotelname());
        holder.title.setText(haoRecommend_entitys.getTitle());
        Picasso.with(context).load(haoRecommend_entitys.getPic()).into(holder.pic);
        return convertView;
    }

    class ViewHolder{
        TextView hotelname,title;
        ImageView pic;

    }

}
