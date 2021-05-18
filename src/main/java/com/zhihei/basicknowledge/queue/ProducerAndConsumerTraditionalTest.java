package com.zhihei.basicknowledge.queue;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-26
 * Time: 01:11:18
 * Description:
 * 一个初始值为零的变量，两个线程对其交替操作，1个加1，1个减1，来10次
 * 1.线程，操作,资源类
 * 2.判读,干活，通知
 * 3.防止虚假唤醒机制
 * 来自于jdk8文档说明
 * As in the one argument version, interrupts and spurious wakeups are possible, and this method should always be used in a loop:
 * <p>
 * synchronized (obj) {
 * while (<condition does not hold>)
 * obj.wait();
 * ... // Perform action appropriate to condition
 * }
 */
class DataClass //资源类
{
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increament()
    {
        lock.lock();
        try
        {
            /**
             * if判断会出现虚假唤醒，前提是大于两个线程的操作
             * 如果只有两个线程用操作共享资源，用if无妨，如果大于两个线程
             * 则要使用while来判断，否则会出现虚假唤醒。
             * 数据出现了负值。6个线程操作资源类，出现了错误。
             * 但是两个线程操作时用if判断是完全正确的。
             * example:
             * A	 current number: 1
             * B	 current number: 0
             * A	 current number: 1
             * B	 current number: 0
             * A	 current number: 1
             * C	 current number: 2
             * B	 current number: 1
             * B	 current number: 0
             * D	 current number: -1
             * D	 current number: -2
             * D	 current number: -3
             * D	 current number: -4
             * D	 current number: -5
             * A	 current number: -4
             * C	 current number: -3
             * B	 current number: -4
             * A	 current number: -3
             * C	 current number: -2
             * E	 current number: -1
             * C	 current number: 0
             * C	 current number: 1
             * E	 current number: 2
             * F	 current number: 1
             * E	 current number: 2
             * F	 current number: 1
             * E	 current number: 2
             * F	 current number: 1
             * E	 current number: 2
             * F	 current number: 1
             * F	 current number: 0
             */
            // if (number == 0)
            while (number != 0)
            {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t current number: " + number);
            condition.signalAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
        }
    }


    public void decreament()
    {
        lock.lock();
        try
        {
            /**
             * if判断会出现虚假唤醒，前提是大于两个线程的操作
             * 如果只有两个线程用操作共享资源，用if无妨，如果大于两个线程
             * 则要使用while来判断，否则会出现虚假唤醒。
             * 数据出现了负值。6个线程操作资源类，出现了错误。
             * 但是两个线程操作时用if判断是完全正确的。
             * example:
             * A	 current number: 1
             * B	 current number: 0
             * A	 current number: 1
             * B	 current number: 0
             * A	 current number: 1
             * C	 current number: 2
             * B	 current number: 1
             * B	 current number: 0
             * D	 current number: -1
             * D	 current number: -2
             * D	 current number: -3
             * D	 current number: -4
             * D	 current number: -5
             * A	 current number: -4
             * C	 current number: -3
             * B	 current number: -4
             * A	 current number: -3
             * C	 current number: -2
             * E	 current number: -1
             * C	 current number: 0
             * C	 current number: 1
             * E	 current number: 2
             * F	 current number: 1
             * E	 current number: 2
             * F	 current number: 1
             * E	 current number: 2
             * F	 current number: 1
             * E	 current number: 2
             * F	 current number: 1
             * F	 current number: 0
             */
            // if (number == 0)
            while (number == 0)
            {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t current number: " + number);
            condition.signalAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
        }
    }

}

class DataSource
{
    private int number = 1;//1--A,2--B,3--C
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void printNumber5()
    {
        lock.lock();
        try
        {

            while (number != 1)
            {
                try
                {
                    condition1.await();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 5; i++)
            {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 2;
            condition2.signal();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
        }

    }

    public void printNumber10()
    {
        lock.lock();
        try
        {

            while (number != 2)
            {
                try
                {
                    condition2.await();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 10; i++)
            {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 3;
            condition3.signal();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
        }

    }


    public void printNumber15()
    {
        lock.lock();
        try
        {

            while (number != 3)
            {
                try
                {
                    condition3.await();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 15; i++)
            {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 1;
            condition1.signal();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
        }

    }

}

public class ProducerAndConsumerTraditionalTest
{
    @Test
    public void testProducerAndConsumer() throws InterruptedException
    {
        DataClass dataClass = new DataClass();
        new Thread(() -> {
            for (int i = 0; i < 5; i++)
            {
                dataClass.increament();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++)
            {
                dataClass.decreament();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++)
            {
                dataClass.increament();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++)
            {
                dataClass.decreament();
            }
        }, "D").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++)
            {
                dataClass.increament();
            }
        }, "E").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++)
            {
                dataClass.decreament();
            }
        }, "F").start();

        TimeUnit.SECONDS.sleep(5);
    }


    /**
     * 题目：
     * 多线程按顺序调用，实现A,B,C三个线程自动启动，要求如下：
     * A打印五次，B打印10次，C打印15次，循环10次。
     * <p>
     * 多线程操作资源类
     * 1.判断，
     * 2.工作
     * 3.唤醒注意虚假唤醒。（大于两个线程无法使用if进行唤醒，要使用while）
     */
    @Test
    public void testLockAwaitSingal() throws InterruptedException
    {
        DataSource dataSource = new DataSource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++)
            {
                dataSource.printNumber5();
            }
        }, "a").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++)
            {
                dataSource.printNumber10();
            }
        }, "b").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++)
            {
                dataSource.printNumber15();
            }
        }, "c").start();
        TimeUnit.SECONDS.sleep(10);
    }

}
