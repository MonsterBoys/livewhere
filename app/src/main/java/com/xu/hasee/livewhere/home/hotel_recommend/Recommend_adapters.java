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
 * Created by Administrator on 2016/5/11 0011.
 */
public class Recommend_adapters extends BaseAdapter {
    private List<Recommend_entitys> list;
    private Context context;
    private LayoutInflater inflater;

    public Recommend_adapters(List<Recommend_entitys> list, Context context) {
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
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.recommend_listview_item, null);
            holder = new ViewHolder();
            holder.iv_recommend_listview = ((ImageView) convertView.findViewById(R.id.iv_recommend_listview));
            holder.tv_recomment1 = ((TextView) convertView.findViewById(R.id.tv_recomment1));
            holder.tv_recomment2 = ((TextView) convertView.findViewById(R.id.tv_recomment2));
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Recommend_entitys recommend_entitys = list.get(position);
        Picasso.with(context).load(recommend_entitys.getIv_recommend_listview()).into(holder.iv_recommend_listview);
        holder.tv_recomment1.setText(recommend_entitys.getTv_recomment1());
        holder.tv_recomment2.setText(recommend_entitys.getTv_recomment2());
        return convertView;
    }

    class ViewHolder {
        ImageView iv_recommend_listview;
        TextView tv_recomment1;
        TextView tv_recomment2;
    }
}
