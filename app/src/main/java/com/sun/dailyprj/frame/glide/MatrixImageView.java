package com.sun.dailyprj.frame.glide;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

/*
 * =====================================================================================
 * Summary:
 *
 * File: MatrixImageView.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/30 16:23
 * =====================================================================================
 */
public class MatrixImageView extends ImageView{

    private OnMatrixClickListener mOnMatrixListener;
    /**
     * false 没放大  默认就是原始大小
     * true  放大了
     */
    public Matrix matrix = new Matrix();
    public Bitmap mBitmap;
    public float scaleWidth;
    public float scaleHeight;
    private float mScreenWidth;
    private float mScreenHeight;
    private Activity mActivity;
    private float X;
    private float Y;

    private boolean isAmplification = false;

    public MatrixImageView(Context context) {
        this(context, null);
    }

    public MatrixImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MatrixImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mBitmap = ((BitmapDrawable) this.getDrawable()).getBitmap();
        X = this.getX();
        Y = this.getY();
        Log.i("syp","mBitmap:" + mBitmap + " ;X:" + X + "; Y=" + Y);
    }

    public void setOnMatrixClickListener(OnMatrixClickListener listener) {
        this.mOnMatrixListener = listener;
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
        DisplayMetrics dm = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        mScreenHeight = dm.heightPixels;
        mScreenWidth = dm.widthPixels;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(mScreenWidth == 0 || mScreenHeight == 0){
            throw new RuntimeException("need call setActivity(Activity activity) to init screenWidth and screenHeight ");
        }


        scaleWidth = (float) mScreenWidth / mBitmap.getWidth();
        scaleHeight = (float) mScreenHeight / mBitmap.getHeight();

        Log.i("syp", "mScreenWidth:" + mScreenWidth + ";mScreenHeight:" + mScreenHeight + " ; bitmap.width:" + mBitmap.getWidth()
                + ";bitmap.height=" + mBitmap.getHeight());
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //super.onLayout(changed, left, top, right, bottom);
        /*Log.i("syp","onLayout() isAmplification:" + isAmplification);
        if(isAmplification) super.onLayout(true, 0, 0, (int) mScreenWidth,(int) mScreenHeight);
        else{
            super.onLayout(true,(int)X,(int)Y,(int)(X + scaleWidth) ,(int)(Y + scaleHeight));
        }*/
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        Log.i("syp","layout() isAmplification:" + isAmplification);
        if(isAmplification) super.layout(0, 0, (int) mScreenWidth,(int) mScreenHeight);
        else super.layout(l, t, r, b);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()) {

            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_DOWN:
                //此处有增加，当屏幕被点击后，将参数传入。
                Log.i("syp", "isAmplification:" + isAmplification);
                if(!isAmplification) {
                    //去放大
                    zoomIn();
                    isAmplification = true;
                } else {
                    //缩小
                    reduction();
                    isAmplification = false;
                }

                if(mOnMatrixListener != null) {
                    mOnMatrixListener.onMatrixClick(this, isAmplification);
                }
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                invalidate();
                return true;
        }
        return super.onTouchEvent(event);
    }

    private void zoomIn() {
        Log.i("syp", "matrix:" + matrix);
        matrix.set(this.getImageMatrix());
        matrix.postScale(scaleWidth, scaleHeight);
        Log.i("syp", "scaleWidth:" + scaleWidth + "; scaleHeight:" + scaleHeight);
        Bitmap newbitmap = Bitmap.createBitmap(mBitmap, 0, 0, mBitmap.getWidth(), mBitmap.getHeight(), matrix, true);
        this.setImageBitmap(newbitmap);
//        this.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        translateAnimation(this);
        isAmplification = true;

    }

    private void reduction() {
        /*缩小*/
        matrix.set(this.getImageMatrix());
        matrix.postScale(1.0f, 1.0f);
        Bitmap newbitmap = Bitmap.createBitmap(mBitmap, 0, 0, mBitmap.getWidth(), mBitmap.getHeight(), matrix, true);
        this.setImageBitmap(newbitmap);
        isAmplification = false;
    }

    /*private void translateAnimation(View view){
        final Animation animation = new TranslateAnimation(0, width, 0, -view.getY());
        animation.setDuration(50);

        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.clearAnimation();
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                lp.setMargins(0, 0, width, height);
                view.setLayoutParams(lp);
            }
        });
        this.setAnimation(animation);
    }
*/
    interface OnMatrixClickListener{
        void onMatrixClick(View view, boolean isAmplification);
    }

}
