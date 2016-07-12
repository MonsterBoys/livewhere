package com.xu.hasee.livewhere.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xu.hasee.livewhere.R;

import java.util.List;

/**
 * Created by hasee on 2016/5/12.
 */
public class MyAdapter_abstract extends BaseAdapter{
    private Context context;
    private List<MyEntity_hotelname> list;
    private LayoutInflater inflater;

    public MyAdapter_abstract(Context context, List<MyEntity_hotelname> list) {
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
   ViewHolder holder;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.popup_list_item,null);
            holder=new ViewHolder();
            holder.holtel_name= ((TextView) convertView.findViewById(R.id.holtel_name));
            convertView.setTag(holder);
        }else {
           holder= ((ViewHolder) convertView.getTag());
        }
         MyEntity_hotelname myEntity_hotelname=list.get(position);
          holder.holtel_name.setText(myEntity_hotelname.getHotelname());
        return convertView;
    }
    class ViewHolder{
        TextView holtel_name;
    }
}
