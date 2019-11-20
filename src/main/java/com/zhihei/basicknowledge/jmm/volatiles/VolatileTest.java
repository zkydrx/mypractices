package com.zhihei.basicknowledge.jmm.volatiles;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-17
 * Time: 17:53:58
 * Description:
 */
class VolatileData
{
    int number = 0;
    volatile int number1 = 0;
    volatile int number2 = 0;

    public void add()
    {
        this.number = 100;
        this.number1 = 100;
    }

    /**
     * 虽然是加了volatile 但是依然不能保证原子性
     */
    public void addNumber1()
    {
        number1++;
    }

    /**
     * 保证了原子性
     */
    public synchronized void addNumber2()
    {
        number2++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * 通过原子类来保证原子性
     */
    public void addAtomicInteger()
    {
        atomicInteger.getAndIncrement();
    }
}

class ResortSeq
{
    int a = 0;
    boolean b = false;

    public void one()
    {
        a = 3;
        b = true;
    }

    public void two()
    {
        if (b)
        {
            a = a + 1;
            System.out.println("a == " + a);
        }
    }
}

public class VolatileTest
{
    /**
     * 1.验证Volatile的可见性
     * 1.1假如int number=0,number 没有volatile关键字修饰
     * 1.2添加了volatile可保证解决可见性问题
     */
    @Test
    public void testVolatile()
    {
        VolatileData volatileData = new VolatileData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in.");
            try
            {
                TimeUnit.SECONDS.sleep(3);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            volatileData.add();
            System.out.println(Thread.currentThread().getName() + "\t update the number finshed. number=" + volatileData.number);
            System.out.println(Thread.currentThread().getName() + "\t update the number finshed. number1=" + volatileData.number1);
        }, "A").start();

        while (volatileData.number1 == 0)
        {

        }
        System.out.println(Thread.currentThread().getName() + "\t，it is over. " + volatileData.number1);
    }

    /**
     * 2.验证volatile不保证原子性问题
     * 2.1原子性概念：不可分割，完整性，某个线程正在做某个业务时，中间不能加塞或者分割，
     * 要么同时成功要么同时失败。
     * 3.如何解决原子性问题
     * 3.1 使用synchronized 同步锁
     * 3.2 使用juc的atomicInteger原子类
     */
    @Test
    public void testAtomic()
    {
        VolatileData volatileData = new VolatileData();

        for (int i = 1; i <= 30; i++)
        {
            new Thread(() -> {

                for (int j = 0; j < 1000; j++)
                {
                    volatileData.addNumber1();
                    volatileData.addNumber2();
                    volatileData.addAtomicInteger();
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2)
        {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t finally the number1=" + volatileData.number1);
        System.out.println(Thread.currentThread().getName() + "\t finally the number2=" + volatileData.number2);
        System.out.println(Thread.currentThread().getName() + "\t finally the atomicInteger=" + volatileData.atomicInteger);
    }

    /**
     * 验证指令重排
     */
    @Test
    public void testResortSeq()
    {
        ResortSeq resortSeq = new ResortSeq();
        for (int i = 0; i < 30; i++)
        {
            new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++)
                {
                    resortSeq.one();
                    resortSeq.two();
                }
            }, String.valueOf(i)).start();
        }
    }

}
