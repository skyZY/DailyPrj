package com.sun.dailyprj.androidx.data_binding;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sun.dailyprj.R;
import com.sun.dailyprj.databinding.ActivityDatabindingCustomBinding;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

/*
 * =====================================================================================
 * Summary:
 *
 * File: DataBindingActivity2.java
 * Author: Yanpeng.Sun
 * Create: 2019/5/10 11:15
 * =====================================================================================
 */
public class DataBindingActivity2 extends AppCompatActivity{
    private ActivityDatabindingCustomBinding mDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_databinding_custom);

        mDataBinding.setDba(this);
        mDataBinding.setBol(true);

        mDataBinding.btnStartBaiduMap.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i1 = new Intent();

                i1.setData(Uri.parse("baidumap://map/navi?query=故宫&src=andr.baidu.openAPIdemo"));

                startActivity(i1);
            }
        });
    }

    public void onClickGetData(View view) {
        Log.i("syp", "button clicked view:" + view);
    }

    public void changeUi(View view, boolean bol) {
        Log.i("syp", "button clicked view:" + view + " ; bol:" + bol);
        //通过设置bol为flase，设置button1不可点击
        mDataBinding.setBol(!mDataBinding.getBol());
//        mDataBinding.dbaBtn1.setVisibility(View.GONE);
    }

}
