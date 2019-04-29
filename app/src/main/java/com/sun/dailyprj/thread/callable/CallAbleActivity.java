package com.sun.dailyprj.thread.callable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sun.dailyprj.R;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*
 * =====================================================================================
 * Summary:
 *
 * File: CallAbleActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/24 17:02
 * =====================================================================================
 */
public class CallAbleActivity extends Activity implements View.OnClickListener{
    private TextView mTxtIntro;
    private ExecutorService mExecutor = Executors.newSingleThreadExecutor();

    private final static String sMessage = "1. Callable与Runable区别\n" +
            "\n" +
            "Java从发布的第一个版本开始就可以很方便地编写多线程的应用程序，并在设计中引入异步处理。Thread类、Runnable接口和Java内存管理模型使得多线程编程简单直接。\n" +
            "\n" +
            "但Thread类和Runnable接口都不允许声明检查型异常，也不能定义返回值。没有返回值这点稍微有点麻烦。不能声明抛出检查型异常则更麻烦一些。\n" +
            "\n" +
            "public void run()方法契约意味着你必须捕获并处理检查型异常。即使你小心地保存了异常信息（在捕获异常时）以便稍后检查，但也不能保证这个类（Runnable对象）的所有使用者都读取异常信息。\n" +
            "\n" +
            "你也可以修改Runnable实现的getter，让它们都能抛出任务执行中的异常。但这种方法除了繁琐也不是十分安全可靠，你不能强迫使用者调用这些方法，程序员很可能会调用join()方法等待线程结束然后就不管了。\n" +
            "\n" +
            "但是现在不用担心了，以上的问题终于在1.5中解决了。Callable接口和Future接口的引入以及他们对线程池的支持优雅地解决了这两个问题。\n" +
            "\n" +
            "不管用哪种方式创建线程，其本质都是Callable接口与Runable接口。两者都是可被其它线程执行的任务！！区别是：" +
            "\n" + "1）Callable规定的方法是call()，而Runnable规定的方法是run()。\n" +
            "\n" +
            "（2）Callable的任务执行后可返回值，而Runnable的任务是不能返回值的。\n" +
            "\n" +
            "（3）call()方法可抛出异常，而run()方法是不能抛出异常的。\n" +
            "\n" +
            "（4）运行Callable任务可拿到一个Future对象。\n" +
            "2.Future\n" +
            "\n" +
            "如上所说，Callable任务返回Future对象。即：Callable和Future一个产生结果，一个拿到结果。\n" +
            "\n" +
            "Future 表示异步计算的结果。Future接口中有如下方法：\n" +
            "\n" +
            "    boolean cancel(boolean mayInterruptIfRunning)\n" +
            "取消任务的执行。参数指定是否立即中断任务执行，或者等等任务结束\n" +
            "\n" +
            "    boolean isCancelled() \n" +
            "任务是否已经取消，任务正常完成前将其取消，则返回 true\n" +
            "\n" +
            "    boolean isDone()\n" +
            "任务是否已经完成。需要注意的是如果任务正常终止、异常或取消，都将返回true\n" +
            "\n" +
            "    V get()\n" +
            "等待任务执行结束，然后获得V类型的结果。InterruptedException 线程被中断异常， ExecutionException任务执行异常，如果任务被取消，还会抛出CancellationException\n" +
            "\n" +
            "    V get(long timeout, TimeUnit unit) \n" +
            "同上面的get功能一样，多了设置超时时间。参数timeout指定超时时间，uint指定时间的单位，在枚举类TimeUnit中有相关的定义。如果计算超时，将抛出TimeoutException\n" +
            "\n" +
            "\n" +
            "Future接口提供方法来检测任务是否被执行完，等待任务执行完获得结果。也可以设置任务执行的超时时间，这个设置超时的方法就是实现Java程序执行超时的关键。\n" +
            "\n" +
            "所以，如果需要设定代码执行的最长时间，即超时，可以用Java线程池ExecutorService类配合Future接口来实现。\n" +
            "\n" +
            "三个简单的小例子，体会一下：";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callable);

        initView();

    }

    private void initView() {
        findViewById(R.id.btn_ca1).setOnClickListener(this);
        findViewById(R.id.btn_ca2).setOnClickListener(this);
        findViewById(R.id.btn_ca3).setOnClickListener(this);
        mTxtIntro = findViewById(R.id.txt_callable_intro);
        mTxtIntro.setText(sMessage);
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_ca1:
                doTest1();
                break;

            case R.id.btn_ca2:
                doTest2();
                break;
            case R.id.btn_ca3:
                try{
                    doTest3();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void doTest3() throws ExecutionException, InterruptedException {
        MyCallable task1 = new MyCallable(0);
        MyCallable task2 = new MyCallable(1);
        MyCallable task3 = new MyCallable(2);
        Future<Object> future1 = mExecutor.submit(task1);
        // 获得第一个任务的结果，如果调用get方法，当前线程会等待任务执行完毕后才往下执行
        System.out.println("task1: " + future1.get());
        Future<Object> future2 = mExecutor.submit(task2);
        Thread.sleep(9000);
        System.out.println("task2: cancel= " + future2.cancel(true));
        // 获取第三个任务的输出，因为执行第三个任务会引起异常
        // 所以下面的语句将引起异常的抛出
        Future<?> future3 = mExecutor.submit(task3);
        System.out.println("task3: " + future3.get());

    }

    private void doTest2() {
        TaskThread2 taskThread2 = new TaskThread2();
        System.out.println("提交任务...begin");
        Future<Object> taskFuture = mExecutor.submit(taskThread2);
        System.out.println("提交任务...end");
        try{
            String result = (String) taskFuture.get(6,TimeUnit.SECONDS);
            System.out.println(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("超时 取消任务");
            taskFuture.cancel(true);
            System.out.println("超时 取消任务OK");
        } finally {
            mExecutor.shutdown();
        }

    }

    private void doTest1() {
        int timeout = 12;
        Boolean result;
        Future<Boolean> future = mExecutor.submit(new TaskThread("发送请求"));//将任务提交给线程池
        try {
            result = future.get(timeout, TimeUnit.SECONDS);
            // result = future.get(timeout, TimeUnit.MILLISECONDS); //1
            System.out.println("发送请求任务的返回结果： "+result);  //2
        } catch (InterruptedException e) {
            System.out.println("线程中断出错。");
            future.cancel(true);// 中断执行此任务的线程
        } catch (ExecutionException e) {
            System.out.println("线程服务出错。");
            future.cancel(true);
        } catch (TimeoutException e) {// 超时异常
            System.out.println("超时。");
            future.cancel(true);
        }finally{
            System.out.println("线程服务关闭。");
            mExecutor.shutdown();
        }

    }
}
