package com.xu.hasee.livewhere.myinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xu.hasee.livewhere.Bean.AppRecommend;
import com.xu.hasee.livewhere.R;

import java.util.List;

/**
 * Created by Administrator on 2016/5/19 0019.
 */
public class AppAdapter extends BaseAdapter{
    private List<AppRecommend.ResultBean> list;
    private Context context;
    private LayoutInflater inflater;
    public AppAdapter(List<AppRecommend.ResultBean> list, Context context) {
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
        if (convertView==null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.app_lv_items,null);
            holder.app_lv_iv = (ImageView) convertView.findViewById(R.id.app_lv_iv);
            holder.app_lv_name = (TextView) convertView.findViewById(R.id.app_lv_name);
            holder.app_lv_description = (TextView) convertView.findViewById(R.id.app_lv_description);
            holder.app_download = (Button) convertView.findViewById(R.id.app_download);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        AppRecommend.ResultBean resultBean = list.get(position);
        Picasso.with(context).load(resultBean.getApp_icon()).into(holder.app_lv_iv);
        holder.app_lv_name.setText(resultBean.getApp_name());
        holder.app_lv_description.setText(resultBean.getApp_desc());
        holder.app_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }

    class ViewHolder{
        ImageView app_lv_iv;
        TextView app_lv_name,app_lv_description;
        Button app_download;
    }
}
