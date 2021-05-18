package com.zhihei.ThreadPool.rejection;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-09
 * Time: 16:19:02
 * Description:
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 在没有分析线程池原理之前先来分析下为什么有任务拒绝的情况发生。
 * <p>
 * 这里先假设一个前提：线程池有一个任务队列，用于缓存所有待处理的任务，正在处理的任务将从任务队列中移除。因此在任务队列长度有限的情况下就会出现新任务的拒绝处理问题，需要有一种策略来处理应该加入任务队列却因为队列已满无法加入的情况。另外在线程池关闭的时候也需要对任务加入队列操作进行额外的协调处理。
 * <p>
 * RejectedExecutionHandler提供了四种方式来处理任务拒绝策略
 * <p>
 * 1、直接丢弃（DiscardPolicy）
 * <p>
 * 2、丢弃队列中最老的任务(DiscardOldestPolicy)。
 * <p>
 * 3、抛异常(AbortPolicy)
 * <p>
 * 4、将任务分给调用线程来执行(CallerRunsPolicy)。
 * <p>
 * 这四种策略是独立无关的，是对任务拒绝处理的四中表现形式。最简单的方式就是直接丢弃任务。
 * 但是却有两种方式，到底是该丢弃哪一个任务，比如可以丢弃当前将要加入队列的任务本身（DiscardPolicy）
 * 或者丢弃任务队列中最旧任务（DiscardOldestPolicy）。丢弃最旧任务也不是简单的丢弃最旧的任务，
 * 而是有一些额外的处理。除了丢弃任务还可以直接抛出一个异常（RejectedExecutionException），
 * 这是比较简单的方式。抛出异常的方式（AbortPolicy）尽管实现方式
 * 比较简单，但是由于抛出一个RuntimeException，因此会中断调用者的处理过程。除了抛出异常以外还可以
 * 不进入线程池执行，在这种方式（CallerRunsPolicy）中任务将有调用者线程去执行。
 */
public class ExecutorDemo
{

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args)
    {
        int corePoolSize = 1;
        int maximumPoolSize = 1;
        BlockingQueue queue = new ArrayBlockingQueue<Runnable>(1);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 0, TimeUnit.SECONDS, queue);
        /**
         * 1、直接丢弃（DiscardPolicy）
         *
         * 2019-11-09 16:28:48  main thread before sleep!!!
         * 2019-11-09 16:28:48  pool-1-thread-1 begin run task :0
         * 2019-11-09 16:28:49  pool-1-thread-1 finish run  task :0
         * 2019-11-09 16:28:49  pool-1-thread-1 begin run task :1
         * 2019-11-09 16:28:50  pool-1-thread-1 finish run  task :1
         * 2019-11-09 16:28:52  before shutdown()
         * 2019-11-09 16:28:52  after shutdown(),pool.isTerminated=false
         * 2019-11-09 16:28:52  now,pool.isTerminated=true
         *
         * 从结果可以看出，只有task0和task1两个任务被执行了。
         *
         * 为什么只有task0和task1两个任务被执行了呢？
         *
         * 过程是这样的：由于我们的任务队列的容量为1.当task0正在执行的时候，task1被提交到了队列中但是还没有执行，
         * 受队列容量的限制，submit提交的task2~task9就都被直接抛弃了。因此就只有task0和task1被执行了。
         *
         */
        // pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        /**
         * 2、丢弃队列中最老的任务(DiscardOldestPolicy)。
         * 2019-11-09 16:29:41  main thread before sleep!!!
         * 2019-11-09 16:29:41  pool-1-thread-1 begin run task :0
         * 2019-11-09 16:29:42  pool-1-thread-1 finish run  task :0
         * 2019-11-09 16:29:42  pool-1-thread-1 begin run task :9
         * 2019-11-09 16:29:43  pool-1-thread-1 finish run  task :9
         * 2019-11-09 16:29:45  before shutdown()
         * 2019-11-09 16:29:45  after shutdown(),pool.isTerminated=false
         * 2019-11-09 16:29:45  now,pool.isTerminated=true
         *
         * 从结果可以看出，只有task0和task9被执行了，由于线程依次递增依次是
         * 0,1,2,3,4,5,6,7,8,9
         * 首先线程0是正在执行过程中，其次本次才用的是丢弃队列中最老的任务，线程1,2,3,4,5,6,7,8都比9要老
         * 由于最大的线程数量是1所以队列中只能存在一个线程进行等待中状态
         */
        // pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        /**
         * 3、抛异常(AbortPolicy)
         * 结果如下：
         * Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@2d98a335 rejected from java.util.concurrent
         * .ThreadPoolExecutor@16b98e56[Running, pool size = 1, active threads = 1, queued tasks = 1, completed tasks = 0]
         * 	at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063)
         * 	at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830)
         * 	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379)
         * 	at java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:112)
         * 	at com.zhihei.ThreadPool.rejection.ExecutorDemo.main(ExecutorDemo.java:97)
         * 2019-11-09 16:34:09  pool-1-thread-1 begin run task :0
         * 2019-11-09 16:34:10  pool-1-thread-1 finish run  task :0
         * 2019-11-09 16:34:10  pool-1-thread-1 begin run task :1
         * 2019-11-09 16:34:11  pool-1-thread-1 finish run  task :1
         *
         * 达到最大线程池数量时抛异常，线程阻塞住。
         *
         */
        // pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        /**
         * 4、将任务分给调用线程来执行(CallerRunsPolicy)。
         * 结果是：
         * 2019-11-09 16:36:13  main begin run task :2
         * 2019-11-09 16:36:13  pool-1-thread-1 begin run task :0
         * 2019-11-09 16:36:14  main finish run  task :2
         * 2019-11-09 16:36:14  main begin run task :3
         * 2019-11-09 16:36:14  pool-1-thread-1 finish run  task :0
         * 2019-11-09 16:36:14  pool-1-thread-1 begin run task :1
         * 2019-11-09 16:36:15  main finish run  task :3
         * 2019-11-09 16:36:15  main begin run task :5
         * 2019-11-09 16:36:15  pool-1-thread-1 finish run  task :1
         * 2019-11-09 16:36:15  pool-1-thread-1 begin run task :4
         * 2019-11-09 16:36:16  main finish run  task :5
         * 2019-11-09 16:36:16  main begin run task :7
         * 2019-11-09 16:36:16  pool-1-thread-1 finish run  task :4
         * 2019-11-09 16:36:16  pool-1-thread-1 begin run task :6
         * 2019-11-09 16:36:17  main finish run  task :7
         * 2019-11-09 16:36:17  pool-1-thread-1 finish run  task :6
         * 2019-11-09 16:36:17  main begin run task :9
         * 2019-11-09 16:36:17  pool-1-thread-1 begin run task :8
         * 2019-11-09 16:36:18  pool-1-thread-1 finish run  task :8
         * 2019-11-09 16:36:18  main finish run  task :9
         * 2019-11-09 16:36:18  main thread before sleep!!!
         * 2019-11-09 16:36:22  before shutdown()
         * 2019-11-09 16:36:22  after shutdown(),pool.isTerminated=false
         * 2019-11-09 16:36:22  now,pool.isTerminated=true
         *
         * 10个线程全部执行完毕，只有0,1线程是有新建的线程执行的，其他多余的线程交给调用者，也就是
         * main线程继续完成任务。
         */
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++)
        {
            final int index = i;
            pool.submit(new Runnable()
            {

                @Override
                public void run()
                {
                    log(Thread.currentThread().getName() + " begin run task :" + index);
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    log(Thread.currentThread().getName() + " finish run  task :" + index);
                }

            });
        }

        log("main thread before sleep!!!");
        try
        {
            Thread.sleep(4000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        log("before shutdown()");

        pool.shutdown();

        log("after shutdown(),pool.isTerminated=" + pool.isTerminated());
        try
        {
            pool.awaitTermination(1000L, TimeUnit.SECONDS);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        log("now,pool.isTerminated=" + pool.isTerminated());
    }

    protected static void log(String string)
    {
        System.out.println(sdf.format(new Date()) + "  " + string);
    }

}