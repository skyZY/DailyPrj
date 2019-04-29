package com.sun.dailyprj.view.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/*
 * =====================================================================================
 * Summary:
 *
 * File: CustomView.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/10 16:47
 * =====================================================================================
 */
public class CustomView extends View{

    private Paint paint;
    private Path path;
    private Path path1;

    /**
     * Simple constructor to use when creating a view from code.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     */
    public CustomView(Context context) {
        this(context,null);
    }


    public CustomView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }


    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(60,60,20,paint);

        RectF rect = new RectF(100, 100, 300, 400);
//
        canvas.drawRoundRect(rect,50,50,paint);

        canvas.drawOval(new RectF(400, 400, 700, 700), paint);

        canvas.drawArc(new RectF(100, 300, 400, 500), 0, 90, false, paint);

        canvas.drawArc(new RectF(100, 600, 400, 800), 0, -90, true, paint);


        canvas.drawLine(100, 100, 100, 1300, paint);
        paint.setStrokeWidth(50);
        canvas.drawLine(400, 100, 400, 1900, paint);

        float[] pts = {120, 100, 200, 200, 300, 300, 500, 500};
        paint.setStrokeWidth(5);
        canvas.drawLines(pts, paint);
        paint.setStrokeWidth(2);
        paint.setTextSize(100);
        canvas.drawPosText("巴扎黑", new float[]{100, 100, 100, 200, 100, 300}, paint);

        paint.setStrokeWidth(5);
        paint.setTextSize(40);
        canvas.drawPath(path, paint);
        canvas.drawPath(path1, paint);
        //把文字绘制在要显示的路径上，默认不偏移
        canvas.drawTextOnPath("搞笑我们是认真的！！！", path, -100, 0, paint);
        //把文字绘制在要显示的路径上，路径起始点偏移150，中心垂直点偏移 50
        canvas.drawTextOnPath("搞笑我们是认真的！！！", path1, 150, 50, paint);


        canvas.drawLine(100,1000,1000,100,paint);
        canvas.drawText("gaoxiaowomenshirenzhende....",200,100,paint);

    }

    private void init() {
        //初始化画笔
        paint = new Paint();
        //设置抗锯齿
        paint.setAntiAlias(true);
        //设置画笔宽度
        paint.setStrokeWidth(5);
        //设置画笔颜色
        paint.setColor(Color.RED);
        //设置画笔样式
        paint.setStyle(Paint.Style.STROKE);

        path = new Path();
        //设置路径，以圆作为我们文本显示的路线
        path.addCircle(300, 300, 200, Path.Direction.CW);  //路径的绘制方式 CW 表示正序绘制，CCW表示倒序绘制

        path1 = new Path();
        path1.addCircle(800, 300, 200, Path.Direction.CW);



    }




}
