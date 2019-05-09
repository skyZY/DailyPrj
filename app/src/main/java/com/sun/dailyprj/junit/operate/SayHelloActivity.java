package com.sun.dailyprj.junit.operate;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.sun.dailyprj.R;

import androidx.appcompat.app.AppCompatActivity;

/*
 * =====================================================================================
 * Summary:
 *
 * File: SayHelloActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/3/12 18:07
 * =====================================================================================
 */
public class SayHelloActivity extends AppCompatActivity{

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
