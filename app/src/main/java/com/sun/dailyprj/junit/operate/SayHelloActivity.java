package com.sun.dailyprj.junit.operate;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.sun.dailyprj.R;

/*
 * =====================================================================================
 * Summary:
 *
 * File: SayHelloActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/3/12 18:07
 * =====================================================================================
 */
public class SayHelloActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayhello);
    }

    public void sayHello(View view) {

        TextView textView = (TextView) findViewById(R.id.txt_sayhello);
        EditText editText = (EditText) findViewById(R.id.et_sayhello);
        textView.setText("Hello, " + editText.getText().toString() + "!");
    }
}
