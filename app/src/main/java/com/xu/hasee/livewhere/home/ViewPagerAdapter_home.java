package com.xu.hasee.livewhere.home;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xu.hasee.livewhere.R;

import java.util.List;

/**
 * Created by hasee on 2016/5/11.
 */
public class ViewPagerAdapter_home extends PagerAdapter {
    private Context context;
    private List<Integer> list;

    public ViewPagerAdapter_home(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
        Log.d("xyc", "ViewPagerAdapter_home: " + list.size());
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(list.get(position%list.size()));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
      //  Log.d("xyc", "destroyItem: " + position);
        container.removeView((View) object);
    }
}
