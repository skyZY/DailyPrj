package com.sun.dailyprj.androidx.data_binding;

import android.os.Bundle;

import com.sun.dailyprj.R;
import com.sun.dailyprj.androidx.data_binding.bean.DataBindingUser;
import com.sun.dailyprj.databinding.ActivityDataBindingBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

/*
 * =====================================================================================
 * Summary:
 *
 * File: DataBindingActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/5/9 14:04
 * =====================================================================================
 */
public class DataBindingActivity extends AppCompatActivity{
    private ActivityDataBindingBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        DataBindingUser user = new DataBindingUser();
        user.setName("Zhang san");
        user.setSex("male");
        mBinding.setUser(user);


    }
}
