package com.zhihei.basicknowledge.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-27
 * Time: 19:51:26
 * Description:
 * 实现多线程有三种办法：
 * 继承thread类
 * 实现runnable接口
 * 实现callable接口
 * 这里主要介绍实现callable接口的例子，
 * Java 5.0 在 java.util.concurrent 提供了一个新的创建执行线程的方式： 实现 Callable 接口。
 * Callable 接口类似于 Runnable，但是 Runnable 不会返回结果，并且无法抛出经过检查的异常，而 Callable 依赖 FutureTask 类获取返回结果。
 */
class myData implements Callable<Integer>
{

    @Override
    public Integer call() throws Exception
    {
        System.out.println(Thread.currentThread().getName() + "\t come in callable");
        TimeUnit.SECONDS.sleep(3);
        return 1;
    }
}

public class ThreadTest
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        /**
         * FutureTask(Callable<V> callable)
         */
        FutureTask<Integer> futureTask = new FutureTask<>(new myData());
        new Thread(futureTask, "A").start();
        /**
         * 获取callable线程的计算结果，没有计算完成就去获取，会使线程阻塞
         * 尽量等到最后在去获取结果。
         * 或者结合while(futureTask.isDone())来使用当任务处理完成以后我们再去获取相应的结果。
         */
        while (!futureTask.isDone())
        {

        }
        Integer integer = futureTask.get();
        System.out.println("线程获取到的结果是:" + integer);
        System.out.println("availableProcessors:" + Runtime.getRuntime().availableProcessors());
        System.out.println("maxMemory:" + Runtime.getRuntime().maxMemory());
        System.out.println("freeMemory:" + Runtime.getRuntime().freeMemory());
        System.out.println("totalMemory:" + Runtime.getRuntime().totalMemory());
    }

}
