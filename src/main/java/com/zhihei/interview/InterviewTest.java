package com.zhihei.interview;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-23
 * Time: 11:58:15
 * Description:
 * 三个线程打印n个数
 */
public class InterviewTest implements Runnable
{
    /**
     * 当前即将打印的数字
     */
    private static int current = 0;
    /**
     * 当前线程编号
     */
    private int threadNo;

    /**
     * 线程数量
     */
    private int threadCount;

    /**
     * 打印的最大数量
     */
    private int max;

    public InterviewTest(int threadNo, int threadCount, int max)
    {
        this.threadNo = threadNo;
        this.threadCount = threadCount;
        this.max = max;
    }
    @Override
    public void run()
    {
        while (current<=max)
        {
            synchronized (InterviewTest.class)
            {

                try
                {
                    while (current % 3 != threadNo)
                    {
                        if (current > max)
                        {
                            break;
                        }
                        else
                        {
                            InterviewTest.class.wait();
                        }
                    }
                    System.out.println("thread-" + threadNo + ":" + current);
                    current++;
                    InterviewTest.class.notifyAll();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        int threadCount = 3;
        int max = 100;
        for (int i = 0; i < threadCount; i++)
        {
            new Thread(new InterviewTest(i, threadCount, max)).start();
        }
    }

}
