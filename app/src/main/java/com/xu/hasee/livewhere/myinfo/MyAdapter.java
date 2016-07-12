package com.xu.hasee.livewhere.myinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xu.hasee.livewhere.R;

import java.util.List;

/**
 * Created by Administrator on 2016/5/18.
 */
public class MyAdapter extends BaseAdapter{
    private Context context;
    private List<String> list;
    private LayoutInflater inflater;
    public MyAdapter(Context context, List<String> list) {
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
        ViewHoler holder;
        if (convertView==null){
            holder = new ViewHoler();
            convertView = inflater.inflate(R.layout.info_listview_items,null);
            holder.lv_tv =((TextView) convertView.findViewById(R.id.lv_tv));
            convertView.setTag(holder);

        }else{
            holder = (ViewHoler) convertView.getTag();
        }

        holder.lv_tv.setText(list.get(position));
        return convertView;
    }


    class ViewHoler{
        TextView lv_tv;
    }
}
