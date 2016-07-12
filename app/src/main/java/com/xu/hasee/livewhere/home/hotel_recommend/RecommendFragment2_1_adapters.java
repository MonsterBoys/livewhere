package com.xu.hasee.livewhere.home.hotel_recommend;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xu.hasee.livewhere.R;

import java.util.List;

/**
 * Created by Administrator on 2016/5/18 0018.
 */
public class RecommendFragment2_1_adapters extends RecyclerView.Adapter {
    private Context context;
    private List<RecommendFragment2_1_entitys> list;
    private LayoutInflater inflater;

    public RecommendFragment2_1_adapters(Context context, List<RecommendFragment2_1_entitys> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recommendfragment2_1_rv_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecommendFragment2_1_entitys recommendFragment2_1_entitys = list.get(position);
        ((MyViewHolder) holder).hotel_section_type_name.setText(recommendFragment2_1_entitys.getHotel_section_type_name());
        ((MyViewHolder) holder).txt.setText(recommendFragment2_1_entitys.getL().get(position).getTxt());
        Picasso.with(context).load(recommendFragment2_1_entitys.getL().get(position).getPics()).into(((MyViewHolder) holder).pics);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView hotel_section_type_name, txt;
        private ImageView pics;

        public MyViewHolder(View itemView) {
            super(itemView);
            hotel_section_type_name = ((TextView) itemView.findViewById(R.id.hotel_section_type_name));
            txt = (TextView) itemView.findViewById(R.id.txt);
            pics = ((ImageView) itemView.findViewById(R.id.pics));
        }
    }
}