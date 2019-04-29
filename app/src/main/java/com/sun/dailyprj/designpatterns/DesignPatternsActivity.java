package com.sun.dailyprj.designpatterns;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.sun.dailyprj.R;
import com.sun.dailyprj.designpatterns.ambassador.Client;
import com.sun.dailyprj.designpatterns.factory.ComputerFactory;
import com.sun.dailyprj.designpatterns.factory.MacSoftware;
import com.sun.dailyprj.designpatterns.factory.WindowsSoftware;

import java.util.LinkedList;

/*
 * =====================================================================================
 * Summary:
 *
 * File: DesignPatternsActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/3/14 14:07
 * =====================================================================================
 */
public class DesignPatternsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patterns_main);


    }

    public void factory(View view) {
        ComputerFactory computerFactory = new ComputerFactory();
        WindowsSoftware windowsSoftware = computerFactory.getComputer(WindowsSoftware.class);
        windowsSoftware.installNetCardDriver("Windows NetCardDriver");
        windowsSoftware.installSystem("WIndows os");
        LinkedList<String> inputWindows = windowsSoftware.installInputMethod(windowsSoftware,computerFactory);

        System.out.println("Windows install InputMethod:" + inputWindows.size());
        MacSoftware macSoftware = computerFactory.getComputer(MacSoftware.class);
        LinkedList<String> inputMac = macSoftware.installInputMethod(macSoftware,computerFactory);
        System.out.println("Mac install InputMethod:" + inputMac.size());
    }

    public void ambassador(View view) {

        new Thread(new Runnable(){
            @Override
            public void run() {
                Client host1 = new Client();
                host1.useService(12);
//                Client host2 = new Client();
//                host2.useService(2303);
            }
        }).start();

    }
}
