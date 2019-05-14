package com.sun.dailyprj.receiver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sun.dailyprj.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
 * =====================================================================================
 * Summary:
 *
 * File: ReceiverActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/5/10 17:59
 * =====================================================================================
 */
public class ReceiverActivity extends AppCompatActivity{
    private final static String INTENT_ACTION = "com.android.action.Test.RECEIVER";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
    }

    public void startBroadcastReceiver(View view) {
        testReceiver(this, new TestBroadcastReceiver());

    }

    private void testReceiver(ReceiverActivity receiverActivity, BroadcastReceiver receiver) {
        Intent intent = new Intent(INTENT_ACTION);
        intent.putExtra("ID", "2233");
        receiver.onReceive(receiverActivity, intent);
    }


}
