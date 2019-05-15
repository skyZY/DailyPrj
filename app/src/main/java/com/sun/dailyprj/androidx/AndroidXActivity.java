package com.sun.dailyprj.androidx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sun.dailyprj.R;
import com.sun.dailyprj.androidx.appcompat.DrawerLayoutActivity;
import com.sun.dailyprj.androidx.data_binding.DataBindingActivity;
import com.sun.dailyprj.androidx.data_binding.DataBindingActivity2;
import com.sun.dailyprj.androidx.data_binding.cases.DataBindingActivityCase;
import com.sun.dailyprj.androidx.percent.PercentFrameLayoutActivity;
import com.sun.dailyprj.androidx.percent.PercentLayoutActivity;
import com.sun.dailyprj.androidx.recyclerview.RecyclerViewActivity;
import com.sun.dailyprj.androidx.room.RoomActivity;
import com.sun.dailyprj.androidx.viewmodel.ViewModelActivity;

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

    public void dataBindingClick(View view) {
        startActivity(new Intent(this, DataBindingActivity.class));
    }

    public void startRecyclerView(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    public void startDataBinding2(View view) {
        startActivity(new Intent(this, DataBindingActivity2.class));
    }

    public void startDataBindingCase(View view) {
        startActivity(new Intent(this, DataBindingActivityCase.class));
    }

    public void startRoom(View view) {
        startActivity(new Intent(this, RoomActivity.class));
    }

    public void startViewModel(View view) {
        startActivity(new Intent(this, ViewModelActivity.class));
    }
}
