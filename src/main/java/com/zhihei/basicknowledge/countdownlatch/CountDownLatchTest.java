package com.zhihei.basicknowledge.countdownlatch;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-22
 * Time: 21:29:27
 * Description:
 */
public class CountDownLatchTest
{
    /**
     * 倒计时
     */
    @Test
    public void testCountDownLatch()
    {
        int count = 6;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 1; i <= count; i++)
        {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 下电梯");
                countDownLatch.countDown();
            }, CountryEnums.getCountry(i).getName()).start();
        }
        try
        {
            countDownLatch.await();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t 管理员把电梯停掉");
    }
}
