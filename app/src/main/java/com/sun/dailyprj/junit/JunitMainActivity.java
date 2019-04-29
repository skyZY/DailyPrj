package com.sun.dailyprj.junit;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.sun.dailyprj.R;
import com.sun.dailyprj.junit.calculator.CalculatorActivity;
import com.sun.dailyprj.junit.operate.SayHelloActivity;

/*
 * =====================================================================================
 * Summary:
 *
 * File: JunitMainActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/3/13 10:06
 * =====================================================================================
 */
public class JunitMainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junit_main);
    }

    public void sayHello(View view) {
        startActivity(new Intent(this,SayHelloActivity.class));

    }

    public void calculator(View view) {
        startActivity(new Intent(this,CalculatorActivity.class));
    }
}
