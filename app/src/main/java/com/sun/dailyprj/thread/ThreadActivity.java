package com.sun.dailyprj.thread;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sun.dailyprj.R;
import com.sun.dailyprj.thread.callable.CallAbleActivity;

/*
 * =====================================================================================
 * Summary:
 *
 * File: ThreadActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/24 17:04
 * =====================================================================================
 */
public class ThreadActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

    }

    public void startCallable(View view) {
        startActivity(new Intent(this, CallAbleActivity.class));
    }
}
