package com.sun.dailyprj.thread.callable;


import java.util.concurrent.Callable;

/*
 * =====================================================================================
 * Summary:
 *
 * File: TaskThread2.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/24 17:54
 * =====================================================================================
 */
public class TaskThread2 implements Callable<Object>{
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Object call() throws Exception {
        String result = "空结果";
        try {
            System.out.println("任务开始....");
            //修改sleep 的值测试超时
            Thread.sleep(7000);
            result = "正确结果";
            System.out.println("任务结束....");
        } catch (Exception e) {
            System.out.println("Task is interrupted!");
        }
        return result;
    }
}
