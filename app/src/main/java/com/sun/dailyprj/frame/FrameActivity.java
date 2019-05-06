package com.sun.dailyprj.frame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sun.dailyprj.R;
import com.sun.dailyprj.frame.glide.GlideActivity;

import androidx.appcompat.app.AppCompatActivity;

/*
 * =====================================================================================
 * Summary:
 *
 * File: FrameActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/30 15:31
 * =====================================================================================
 */
public class FrameActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);


    }

    public void startGlide(View view) {
        startActivity(new Intent(this, GlideActivity.class));
    }
}
