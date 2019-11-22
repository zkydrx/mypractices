package com.zhihei.basicknowledge.semaphore;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-22
 * Time: 22:56:18
 * Description:
 * 信号灯，可以复用
 * 类似于抢车位，秒杀等
 * 也可以用作锁，就是我只有一个资源可供消费时就是线程安全锁。
 */
public class SemaphoreTest
{
    @Test
    public void testSemaphore()
    {

        int count = 5;
        Semaphore semaphore = new Semaphore(count);
        for (int i = 1; i <= 15; i++)
        {
            new Thread(()->{
                try
                {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢到座位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t坐了3秒钟后离开");
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }

        try
        {
            TimeUnit.SECONDS.sleep(60);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
