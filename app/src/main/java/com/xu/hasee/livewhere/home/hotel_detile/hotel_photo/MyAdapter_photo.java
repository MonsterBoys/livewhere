package com.xu.hasee.livewhere.home.hotel_detile.hotel_photo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.xu.hasee.livewhere.R;

import java.util.List;

/**
 * Created by hasee on 2016/5/18.
 */
public class MyAdapter_photo extends RecyclerView.Adapter {
    private Context context;
    private List<MyEntity_photo> list;
    private LayoutInflater inflater;

    public MyAdapter_photo(Context context, List<MyEntity_photo> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.recyclerview_item,null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
      MyEntity_photo myEntity=list.get(position);
        MyViewHolder holder1 = (MyViewHolder) holder;
        Picasso.with(context).load(myEntity.getPicsmall()).into(holder1.imageview_photo);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageview_photo;

        public MyViewHolder(View itemView) {
            super(itemView);
           imageview_photo=  ((ImageView) itemView.findViewById(R.id.imageview_photo));
        }

    }
}
