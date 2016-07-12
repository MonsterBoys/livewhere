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
 * Created by Administrator on 2016/5/19 0019.
 */
public class Fragment2_1Bottom_adapters extends BaseAdapter {
    private Context context;
    private List<Fragment2_1Bottom_entitys> list;
    private LayoutInflater inflater;

    public Fragment2_1Bottom_adapters(Context context, List<Fragment2_1Bottom_entitys> list) {
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
            convertView = inflater.inflate(R.layout.hotelintroduce_list_item, null);
            holder = new ViewHolder();
            holder.hotel_section_type_name = (TextView) convertView.findViewById(R.id.hotel_section_type_name);
            holder.pics = (ImageView) convertView.findViewById(R.id.pics);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Fragment2_1Bottom_entitys fragment2_1Bottom_entitys = list.get(position);
        holder.hotel_section_type_name.setText(fragment2_1Bottom_entitys.getHotel_section_type_name());
        Picasso.with(context).load(fragment2_1Bottom_entitys.getPics()).into(holder.pics);
        return convertView;
    }

    class ViewHolder {
        TextView hotel_section_type_name;
        ImageView pics;
    }
}
