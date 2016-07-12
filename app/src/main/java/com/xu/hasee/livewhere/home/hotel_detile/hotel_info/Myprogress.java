package com.xu.hasee.livewhere.home.hotel_detile.hotel_info;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.xu.hasee.livewhere.R;

/**
 * Created by hasee on 2016/5/15.
 */
public class Myprogress extends View {

    private Paint paint;
    private RectF rectF;
    private int padding = 20;
    private int stoke = 7;
    public Myprogress(Context context) {
        this(context,null);
    }

    public Myprogress(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public Myprogress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(getResources().getColor(R.color.mycolorgreen));
        paint.setStrokeWidth(stoke);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (float) (getWidth() / 2 - Math.ceil(stoke / 2.0)), paint);
    }
}
