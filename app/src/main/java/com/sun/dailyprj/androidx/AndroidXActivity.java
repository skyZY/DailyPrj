package com.sun.dailyprj.androidx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sun.dailyprj.R;
import com.sun.dailyprj.androidx.appcompat.DrawerLayoutActivity;
import com.sun.dailyprj.androidx.percent.PercentFrameLayoutActivity;
import com.sun.dailyprj.androidx.percent.PercentLayoutActivity;

import androidx.appcompat.app.AppCompatActivity;

/*
 * =====================================================================================
 * Summary:
 *
 * File: AndroidXActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/5/9 10:02
 * =====================================================================================
 */
public class AndroidXActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androidx);
    }

    public void DrawableLayout(View view) {

        startActivity(new Intent(this, DrawerLayoutActivity.class));
    }

    public void percentLayout(View view) {
        startActivity(new Intent(this, PercentLayoutActivity.class));
    }

    public void percentFrameLayout(View view) {
        startActivity(new Intent(this, PercentFrameLayoutActivity.class));
    }
}
