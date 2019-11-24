package com.zhihei.ThreadPool.executors;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-10-27
 * Time: 10:36:02
 * Description:
 */
public class ThreadPoolExecutorTests
{

    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++)
        {
            int index = i;
            executorService.submit(() -> System.out.println("i:" + index + " executorService"));
        }
        executorService.shutdown();
    }


    @Test
    public void testThreadPoolExecutor1()
    {
        ExecutorService executorService = new ThreadPoolExecutor(2,
                                                                 2,
                                                                 0L,
                                                                 TimeUnit.MILLISECONDS,
                                                                 new LinkedBlockingQueue<>(10),
                                                                 Executors.defaultThreadFactory(),
                                                                 new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++)
        {
            int index = i;
            executorService.submit(() -> System.out.println("i:" + index + " executorService"));
        }
        executorService.shutdown();
    }

    @Test
    public void testThreadPoolExecutor2()
    {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,
                                                         2,
                                                         0L,
                                                         TimeUnit.MILLISECONDS,
                                                         new LinkedBlockingQueue<>(10),
                                                         Executors.defaultThreadFactory(),
                                                         new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++)
        {
            int index = i;
            pool.submit(() -> System.out.println("i:" + index + " executorService"));
        }
        pool.shutdown();
    }


    /**
     * 自定义ThreadFactory
     * 自定义线程拒绝策略
     */
    @Test
    public void testThreadPoolexecutor3()
    {

        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10), new ThreadFactory()
        { //自定义ThreadFactory
            @Override
            public Thread newThread(Runnable r)
            {
                Thread thread = new Thread(r);
                thread.setName(r.getClass().getName());
                return thread;
            }
        }, new ThreadPoolExecutor.AbortPolicy()); //自定义线程拒绝策略

        for (int i = 0; i < 10; i++)
        {
            int index = i;
            executorService.submit(() -> System.out.println("i:" + index));
        }

        executorService.shutdown();
    }


    private static void divTask(int a, int b)
    {
        double result = a / b;
        System.out.println(result);
    }

    /**
     * submit的坑
     * <p>
     * 运行结果如下：
     * 100.0
     * 25.0
     * 33.0
     * 50.0
     * <p>
     * 可以看出运行结果为4个，因该是有5个的，但是当i=0的时候，100/0是会报错的，但是日志信息中没有任何信息，
     * 是为什么那？如果使用了submit(Runnable task) 就会出现这种情况，任何的错误信息都出现不了！
     * 这是因为使用submit(Runnable task) 的时候，错误的堆栈信息跑出来的时候会被内部捕获到，
     * 所以打印不出来具体的信息让我们查看，解决的方法有如下两种：
     * 1、使用execute（）代替submit（）；参考testThreadPoolExecutor5()
     * 2、使用Future 参考testThreadPoolExecutor6()
     */
    @Test
    public void testThreadPoolExecutor4()
    {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 5; i++)
        {
            int index = i;
            executorService.submit(() -> divTask(100, index));
        }
        executorService.shutdown();
    }
    /**
     *
     * execute和submit的区别
     *
     * （1）execute()方法用于提交不需要返回值的任务，所以无法判断任务是否被线程池执行成功。
     * 通过以下代码可知execute()方法输入的任务是一个Runnable类的实例。
     *
     * （2）submit()方法用于提交需要返回值的任务。线程池会返回一个future类型的对象，
     * 通过这个future对象可以判断任务是否执行成功，并且可以通过future的get()方法来获取返回值
     * ，get()方法会阻塞当前线程直到任务完成，而使用get（long timeout，TimeUnit unit）方法
     * 则会阻塞当前线程一段时间后立即返回，这时候有可能任务没有执行完。
     *
     *
     * 使用execute()方法
     * 将会捕获异常信息，并打印出异常的堆栈信息
     */
    @Test
    public void testThreadPoolExecutor5()
    {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 5; i++)
        {
            int index = i;
            executorService.execute(() -> divTask(100, index));
        }
        executorService.shutdown();
    }

    /**
     * 如果出现异常，将会打印出异常信息
     * 使用 future
     */
    @Test
    public void testThreadPoolExecutor6()
    {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 5; i++)
        {
            int index = i;
            Future future = executorService.submit(() -> divTask(200, index));
            try
            {
                future.get();
            }
            catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
