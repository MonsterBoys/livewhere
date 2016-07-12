package com.xu.hasee.livewhere.myinfo.weight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xu.hasee.livewhere.Bean.Order;
import com.xu.hasee.livewhere.R;

import java.util.List;

/**
 * Created by Administrator on 2016/5/21 0021.
 */
public class MyOrderAdapter extends BaseAdapter {
    private List<Order> list;
    private Context context;
    private LayoutInflater inflater;

    public MyOrderAdapter(List<Order> list, Context context) {
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.order_items, null);
            holder = new ViewHolder();
            holder.item_hotelname = ((TextView) convertView.findViewById(R.id.item_hotelname));
            holder.item_comment_scores = ((TextView) convertView.findViewById(R.id.item_comment_scores));
            holder.item_xingji = ((TextView) convertView.findViewById(R.id.item_xingji));
            holder.item_address = ((TextView) convertView.findViewById(R.id.item_address));
            holder.item_price = ((TextView) convertView.findViewById(R.id.item_price));
            convertView.setTag(holder);
        } else {
            holder = ((ViewHolder) convertView.getTag());
        }
        Order order = list.get(position);
        holder.item_hotelname.setText(order.getName());
        holder.item_address.setText(order.getAdress());
        holder.item_comment_scores.setText(order.getOrderId());
        holder.item_price.setText(order.getBookmoney());
        holder.item_xingji.setText(order.getHousetype());

        return convertView;
    }

    class ViewHolder {
        TextView item_hotelname;
        TextView item_comment_scores;
        TextView item_xingji;
        TextView item_address;
        TextView item_price;
    }
}