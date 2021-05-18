package knowledgeable.review201803.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-20
 * Time: 09:17:09
 * Description:
 * multithreading
 */
public class Multithreading extends Thread
{
    private int x;

    public void run()
    {
        System.out.println("extends Thread.");
    }
}

class MultithreadingOne implements Runnable
{
    private int y;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run()
    {
        System.out.println("Implement runnable.");
    }
}

class MultithreadingTwo implements Callable<Integer>
{

    private int sum;

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception
    {
        System.out.println("Callable 子线程开始计算");
        Thread.sleep(2000);
        for (int i = 0; i <= 100; i++)
        {
            sum += i;
        }
        System.out.println("Callable 子线程计算结束");
        return sum;
    }
}

class TestAll
{
    public static void main(String[] args) throws Exception
    {
        for (int i = 0; i < 10; i++)
        {
            Thread multithreading = new Multithreading();
            multithreading.start();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }


        MultithreadingOne multithreadingOne = new MultithreadingOne();

        for (int i = 0; i < 10; i++)
        {
            Thread thread = new Thread(multithreadingOne);

            thread.start();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        /**
         * 实现Callable接口的多线程测试如下;
         */
        /**
         * 1. 创建线程池
         */
        ExecutorService es = Executors.newSingleThreadExecutor();
        /**
         * 2. 创建callable任务
         */
        MultithreadingTwo multithreadingTwo = new MultithreadingTwo();

        /**
         * 3. 提交任务并执行结果
         */
        Future<Integer> future = es.submit(multithreadingTwo);

        /**
         * 4. 关闭线程池
         */
        es.shutdown();

        Thread.sleep(3000);
        System.out.println("主线程开始执行其他任务");


        if (future.get() != null)
        {
            /**
             * 输出获取到的结果
             */
            System.out.println("future.get()--->" + future.get());
        }
        else
        {
            System.out.println("future.get()未获取到结果");
        }

        System.out.println("主线程执行完成");
    }
}