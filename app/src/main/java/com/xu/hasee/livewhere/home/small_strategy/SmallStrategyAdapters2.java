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
public class SmallStrategyAdapters2 extends BaseAdapter {
    private Context context;
    private List<SmallStrategyEntitys2> list;
    private LayoutInflater inflater;

    public SmallStrategyAdapters2(Context context, List<SmallStrategyEntitys2> list) {
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
            convertView = inflater.inflate(R.layout.smallstragtegy_lv_item, null);
            holder = new ViewHolder();
            holder.pic0 = (ImageView) convertView.findViewById(R.id.pic0);
            holder.title0 = (TextView) convertView.findViewById(R.id.title0);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        SmallStrategyEntitys2 smallStrategyEntitys2 = list.get(position);
        holder.title0.setText(smallStrategyEntitys2.getTitle());
        Picasso.with(context).load(smallStrategyEntitys2.getPic()).into(holder.pic0);
        return convertView;
    }

    class ViewHolder {
        TextView title0;
        ImageView pic0;
    }
}
