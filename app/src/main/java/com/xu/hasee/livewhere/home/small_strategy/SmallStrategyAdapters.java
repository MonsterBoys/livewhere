package com.xu.hasee.livewhere.home.small_strategy;

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
 * Created by Administrator on 2016/5/19 0019.
 */
public class SmallStrategyAdapters extends BaseAdapter {
    private Context context;
    private List<SmallStrategyEntitys> list;
    private LayoutInflater inflater;

    public SmallStrategyAdapters(Context context, List<SmallStrategyEntitys> list) {
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
            convertView = inflater.inflate(R.layout.smallstragtegy_gv_item, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.subname = (TextView) convertView.findViewById(R.id.subname);
            holder.pic = (ImageView) convertView.findViewById(R.id.pic);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        SmallStrategyEntitys smallStrategyEntitys = list.get(position);
        holder.name.setText(smallStrategyEntitys.getName());
        holder.subname.setText(smallStrategyEntitys.getSubname());
        Picasso.with(context).load(smallStrategyEntitys.getPic()).into(holder.pic);
        return convertView;
    }

    class ViewHolder {
        TextView name;
        TextView subname;
        ImageView pic;
    }
}
