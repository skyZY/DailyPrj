package com.sun.dailyprj.frame.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.sun.dailyprj.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;

/*
 * =====================================================================================
 * Summary:
 *
 * File: GlideActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/30 15:35
 * =====================================================================================
 */
public class GlideActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView img_glide;
    private Context mContext;
    private MatrixImageView img_matrixImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        mContext = this;
        img_glide = findViewById(R.id.img_glide);
        img_glide.setOnClickListener(this);

        Glide.with(mContext).load("http://k.zol-img.com.cn/sjbbs/7692/a7691515_s.jpg").placeholder(R.mipmap.mingzhu).into(img_glide);
        img_matrixImage = findViewById(R.id.img_matrixImage);
        img_matrixImage.setActivity(this);
        img_matrixImage.setOnMatrixClickListener(new MatrixImageView.OnMatrixClickListener(){
            @Override
            public void onMatrixClick(View view,boolean isAmplification) {
                Toast.makeText(mContext, "监听事件", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.img_glide:

                Glide.with(mContext).load("http://k.zol-img.com.cn/sjbbs/7692/a7691515_s.jpg")
                        .into(new SimpleTarget<Drawable>(){
                            @Override
                            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                                Bitmap bitmap = drawable2Bitmap(resource);
                                saveImage(bitmap, "dog.jpg");
                            }
                        });
                break;
        }
    }


    /**
     * 保存图片的方法 保存到sdcard
     *
     * @throws Exception
     */
    private void saveImage(Bitmap bitmap, String imageName) {
        String filePath = Environment.getExternalStorageDirectory() + "/carota/";
        FileOutputStream fos = null;
        File file = new File(filePath, imageName);
        try{
            fos = new FileOutputStream(file);
            if(null != fos) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
                fos.flush();
                fos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Bitmap drawable2Bitmap(Drawable drawable) {
        if(drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        } else if(drawable instanceof NinePatchDrawable) {
            Bitmap bitmap = Bitmap
                    .createBitmap(
                            drawable.getIntrinsicWidth(),
                            drawable.getIntrinsicHeight(),
                            drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                                    : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return bitmap;
        } else {
            return null;
        }
    }
}
