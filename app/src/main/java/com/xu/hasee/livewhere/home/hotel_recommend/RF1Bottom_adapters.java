package com.xu.hasee.livewhere.home.hotel_recommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xu.hasee.livewhere.R;

import java.util.List;

/**
 * Created by Administrator on 2016/5/19 0019.
 */
public class RF1Bottom_adapters extends BaseAdapter {
    private Context context;
    private List<RF1Bottoms_entitys> list;
    private LayoutInflater inflater;

    public RF1Bottom_adapters(Context context, List<RF1Bottoms_entitys> list) {
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
            convertView = inflater.inflate(R.layout.fragment_recommend1_listview_item, null);
            holder = new ViewHolder();
            holder.cbd_name = (TextView) convertView.findViewById(R.id.cbd_name);
            holder.choosehere = (TextView) convertView.findViewById(R.id.choosehere);
            holder.descption2 = (TextView) convertView.findViewById(R.id.descption2);
            holder.picture11 = (ImageView) convertView.findViewById(R.id.picture11);
//            holder.label = (TextView) convertView.findViewById(R.id.label);
//            holder.descption1 = (TextView) convertView.findViewById(R.id.descption1);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        RF1Bottoms_entitys rf1Bottoms_entitys = list.get(position);
        holder.cbd_name.setText(rf1Bottoms_entitys.getCbd_name());
        holder.choosehere.setText(rf1Bottoms_entitys.getChoosehere() + "");
        holder.descption2.setText(rf1Bottoms_entitys.getDescption());
       // Picasso.with(context).load(rf1Bottoms_entitys.getPicture()).into(holder.picture11);
        return convertView;
    }

    class ViewHolder {
        TextView cbd_name;
        TextView choosehere;
        TextView descption2;
        ImageView picture11;
    }
}
