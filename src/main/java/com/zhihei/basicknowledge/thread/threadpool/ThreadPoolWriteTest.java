package com.zhihei.basicknowledge.thread.threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-12-08
 * Time: 09:48:43
 * Description:
 * 手写板的线程池
 */
public class ThreadPoolWriteTest
{
    /**
     * 线程拒绝策略：AbortPolicy 抛异常
     */
    @Test
    public void testThreadPoolAbortPolicy() throws InterruptedException
    {

        System.out.println("#######################线程拒绝策略：AbortPolicy 抛异常##########################");


        ExecutorService executorService = new ThreadPoolExecutor(2,
                                                                 5,
                                                                 1L,
                                                                 TimeUnit.SECONDS,
                                                                 new ArrayBlockingQueue<>(3),
                                                                 Executors.defaultThreadFactory(),
                                                                 new ThreadPoolExecutor.AbortPolicy());
        try
        {
            for (int i = 1; i <= 9; i++)
            {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理线程");
                });
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            executorService.shutdown();
        }

        System.out.println("#######################线程拒绝策略：AbortPolicy 抛异常##########################");


    }


    /**
     * 线程拒绝策略：DiscardOldestPolicy 丢弃最旧的任务策略
     */
    @Test
    public void testThreadPoolDiscardOldestPolicy() throws InterruptedException
    {

        System.out.println("#######################线程拒绝策略：DiscardOldestPolicy 丢弃最旧的任务策略##########################");


        ExecutorService executorService = new ThreadPoolExecutor(2,
                                                                 5,
                                                                 1L,
                                                                 TimeUnit.SECONDS,
                                                                 new ArrayBlockingQueue<>(3),
                                                                 Executors.defaultThreadFactory(),
                                                                 new ThreadPoolExecutor.DiscardOldestPolicy());
        try
        {
            for (int i = 1; i <= 9; i++)
            {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理线程");
                });
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            executorService.shutdown();
        }

        System.out.println("#######################线程拒绝策略：DiscardOldestPolicy 丢弃最旧的任务策略##########################");



    }

    /**
     * 线程拒绝策略：DiscardPolicy丢弃策略
     */
    @Test
    public void testThreadPoolDiscardPolicy() throws InterruptedException
    {

        System.out.println("#######################线程拒绝策略：DiscardPolicy丢弃策略##########################");


        ExecutorService executorService = new ThreadPoolExecutor(2,
                                                                 5,
                                                                 1L,
                                                                 TimeUnit.SECONDS,
                                                                 new ArrayBlockingQueue<>(3),
                                                                 Executors.defaultThreadFactory(),
                                                                 new ThreadPoolExecutor.DiscardPolicy());
        try
        {
            for (int i = 1; i <= 9; i++)
            {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理线程");
                });
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            executorService.shutdown();
        }

        System.out.println("#######################线程拒绝策略：DiscardPolicy丢弃策略##########################");

    }

    /**
     * 线程拒绝策略： CallerRunsPolicy交给调用者
     */
    @Test
    public void testThreadPoolCallerRunsPolicy() throws InterruptedException
    {

        System.out.println("#######################线程拒绝策略： CallerRunsPolicy交给调用者##########################");


        ExecutorService executorService = new ThreadPoolExecutor(2,
                                                                 5,
                                                                 1L,
                                                                 TimeUnit.SECONDS,
                                                                 new ArrayBlockingQueue<>(3),
                                                                 Executors.defaultThreadFactory(),
                                                                 new ThreadPoolExecutor.CallerRunsPolicy());
        try
        {
            for (int i = 1; i <= 9; i++)
            {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理线程");
                });
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            executorService.shutdown();
        }

        System.out.println("#######################线程拒绝策略： CallerRunsPolicy交给调用者##########################");


    }
}
