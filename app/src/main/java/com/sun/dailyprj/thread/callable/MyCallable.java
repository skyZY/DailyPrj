package com.sun.dailyprj.thread.callable;

import java.util.concurrent.Callable;

/*
 * =====================================================================================
 * Summary:
 *
 * File: MyCallable.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/24 18:11
 * =====================================================================================
 */
public class MyCallable implements Callable<Object>{

    private int flag = 0;

    public MyCallable(int flag) {

        this.flag = flag;

    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Object call() throws Exception {
        if (this.flag == 0) {
            return "flag = 0";
        }
        if (this.flag == 1) {
            try {
                while (true) {
                    System.out.println("looping.");
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
            return "false";
        } else {
            throw new Exception("Bad flag value!");
        }
    }
}
