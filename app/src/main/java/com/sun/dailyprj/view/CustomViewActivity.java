package com.sun.dailyprj.view;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.sun.dailyprj.R;
import com.sun.dailyprj.view.canvas.BesselActivity;
import com.sun.dailyprj.view.canvas.CanvasActivity;

/*
 * =====================================================================================
 * Summary:
 *
 * File: CustomViewActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/10 16:47
 * =====================================================================================
 */
public class CustomViewActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view_main);

    }

    public void paintView(View view) {
        startActivity(new Intent(this ,CanvasActivity.class));

    }

    public void paintBessel(View view) {

        startActivity(new Intent(this,BesselActivity.class));
    }
}
