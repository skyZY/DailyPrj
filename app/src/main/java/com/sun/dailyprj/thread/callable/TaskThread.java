package com.sun.dailyprj.thread.callable;

import java.util.concurrent.Callable;

/*
 * =====================================================================================
 * Summary:
 *
 * File: TaskThread.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/24 17:39
 * =====================================================================================
 */
public class TaskThread implements Callable<Boolean>{

    private String t;
    public TaskThread(String temp){
        this.t= temp;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Boolean call() throws Exception {
        //for用于模拟超时
        Thread.sleep(2000);
        System.out.println(t+"成功！");

        if(Thread.interrupted())return false;

        Thread.sleep(3000);
       /* for(int i=0;i<99999;i++){
            if(i==99998){
                System.out.println(t+"成功！");
            }
            if (Thread.interrupted()){ //很重要
                return false;
            }
        }*/
        System.out.println("继续执行..........");
        return true;
    }
}
