package com.sun.dailyprj.receiver;

import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/*
 * =====================================================================================
 * Summary:
 *
 * File: TestBroadcastReceiver.java
 * Author: Yanpeng.Sun
 * Create: 2019/5/10 18:07
 * =====================================================================================
 */
public class TestBroadcastReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String id = intent.getStringExtra("ID");
        Log.i("syp", "id:" + id);
    }
}
