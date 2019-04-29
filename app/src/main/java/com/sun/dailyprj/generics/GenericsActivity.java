package com.sun.dailyprj.generics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sun.dailyprj.R;

import androidx.appcompat.app.AppCompatActivity;

/*
 * =====================================================================================
 * Summary:
 *
 * File: GenericsActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/26 9:18
 * =====================================================================================
 */
public class GenericsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generics);

    }

    public void startCase(View view) {
        startActivity(new Intent(this,GenericAdapterActivity.class));
    }
}
