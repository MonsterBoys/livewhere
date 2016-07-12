package com.xu.hasee.livewhere.home.hotel_recommend;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xu.hasee.livewhere.R;

import java.util.List;
import java.util.Random;

/**
 * Created by wangsong on 2016/5/4.
 */
public class Information_adapters extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<String> list;
    private int[] colors;
    private Random random;

    public Information_adapters(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        random = new Random();
        colors = new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_view_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).username.setText(list.get(position));
        //给CardView设置背景颜色
        ((MyViewHolder) holder).cardView.setCardBackgroundColor(colors[random.nextInt(4)]);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView username;
        private CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.username);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
}
