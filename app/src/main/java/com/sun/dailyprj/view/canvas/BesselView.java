package com.sun.dailyprj.view.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/*
 * =====================================================================================
 * Summary:
 *
 * File: BesselView.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/24 10:45
 * =====================================================================================
 */
public class BesselView extends View{
    private Paint paint;
    private Path path;

    public BesselView(Context context) {
        this(context,null);
    }


    public BesselView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BesselView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(100);//sp
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        path = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.moveTo(100,200);
        path.lineTo(200,200);
        path.lineTo(300,400);
        path.lineTo(0,400);
        path.close();
        canvas.drawPath(path,paint);

    }
}

