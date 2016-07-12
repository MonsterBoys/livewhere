package com.xu.hasee.livewhere.home.hotel_detile;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.xu.hasee.livewhere.R;
import com.xu.hasee.livewhere.home.hotel_detile.hotel_photo.HotelPhotoActivity;

import java.io.IOException;

/**
 * Created by hasee on 2016/5/14.
 */
public class Detile_Viewpager extends PagerAdapter {
    private String[] list;
    private Context context;
    private String hotelid;

    public Detile_Viewpager(String[] list, Context context, String hotelid) {
        this.list = list;
        this.context = context;
        this.hotelid = hotelid;
    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        final ImageView imageView = new ImageView(context);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.hotel_detail_no_image);
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Bitmap bitmap = ((Bitmap) msg.obj);
                imageView.setImageBitmap(bitmap);

            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Bitmap bitmap = Picasso.with(context).load(list[position]).get();
                    Message message = handler.obtainMessage();
                    message.obj = bitmap;
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context, "sddas", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, HotelPhotoActivity.class);
                intent.putExtra("hotelid",hotelid);
                context.startActivity(intent);
            }
        });
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(((View) object));
    }
}
