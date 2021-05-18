package com.zhihei.basicknowledge.lock;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-21
 * Time: 20:16:18
 * Description:
 * synchronized ,ReentrantLock 是非公平锁，可重入锁，独占锁
 * ReentrantReadWriteLock 是读写锁，读共享，写独占
 */
public class LockTest
{

    /**
     * 可重入锁，也叫做递归锁，指的是同一线程 外层函数获得锁之后 ，内层递归函数仍然有获取该锁的代码，但不受影响。
     * 同一个线程外层函数获取锁之后，内层函数仍然能够获取该锁的代码
     * 在同一个线程外层方法获取锁的时候，再进入内层方法会自动获取锁
     * 也就是说线程可以进入任何一个他已经拥有锁所同步着的代码块
     * <p>
     * t1	 invoke work()
     * t1	 invoke eat()
     * t2	 invoke work()
     * t2	 invoke eat()
     * 证明synchronized是可重入锁。
     */
    @Test
    public void testSynchroinzed()
    {
        try
        {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        User user = new User();
        new Thread(() -> {
            user.work();
        }, "t1").start();
        new Thread(() -> {
            user.work();
        }, "t2").start();
    }

    /**
     * t3	 invoke look()
     * t3	 invoke listen()
     * t4	 invoke look()
     * t4	 invoke listen()
     * 证明了ReentrantLock也是可重入锁
     */
    @Test
    public void testReentrantLock()
    {

        try
        {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        User user = new User();

        new Thread(user, "t3").start();
        new Thread(user, "t4").start();

        new Thread(() -> user.run(), "t5").start();
        new Thread(() -> user.run(), "t6").start();

        new Thread(() -> new User().run(), "t7").start();


    }


    /**
     * 手写一个自旋锁
     * 自旋锁的好处：循环比较直到成功为止，没有类似于wait的阻塞
     * 通过cas完成自旋锁，A线程先进来调用myLock自己持有锁5秒钟，B线程进来发现当前线程持有锁，所以只能自旋等待
     * 直到A释放锁B随后抢到
     */
    @Test
    public void testSpinLock()
    {
        LockTest lockTest = new LockTest();
        new Thread(() -> {
            lockTest.mylock();
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            lockTest.unlock();
        }, "A").start();
        try
        {
            Thread.sleep(200);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        new Thread(() -> {
            lockTest.mylock();
            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            lockTest.unlock();
        }, "B").start();
        try
        {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 原子引用类
     */
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    /**
     * 加锁
     */
    public void mylock()
    {
        while (!atomicReference.compareAndSet(null, Thread.currentThread()))
        {
            System.out.println(Thread.currentThread().getName() + "\t invoked mylock()");
        }
    }

    /**
     * 释放锁
     */
    public void unlock()
    {
        atomicReference.compareAndSet(Thread.currentThread(), null);
        System.out.println(Thread.currentThread().getName() + "\t invoked unlock()");
    }


    /**
     * 读写锁：ReentrantReadWriteLock
     * 多个线程同时读取一个资源是没有任何问题的，为了满足高并发，读取线程可同时进行
     * 如果有一个线程想去写资源的话，就不应该有其他线程对该资源进行读或者写
     * 总结如下：
     * 读-读可共存
     * 读-写不可共存
     * 写-写不可共存
     * 写操作：原子性加独占，整个过程必须是一个完整的过程，中间不允许被打断，和加塞
     */
    @Test
    public void testReadWriteLock()
    {

        myCache myCache = new myCache();
        for (int j = 1; j <= 10; j++)
        {
            int tempInt = j;
            new Thread(() -> {
                myCache.set(tempInt + "", tempInt);
            }, String.valueOf(tempInt)).start();
        }

        for (int j = 1; j <= 10; j++)
        {
            int tempInt = j;
            new Thread(() -> {
                myCache.get(tempInt + "");
            }, String.valueOf(tempInt)).start();
        }

        try
        {
            TimeUnit.SECONDS.sleep(10);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

}

class User implements Runnable
{
    /**
     * 线程操纵资源类
     */
    public synchronized void work()
    {
        System.out.println(Thread.currentThread().getName() + "\t invoke work()");
        eat();
    }

    /**
     * 线程操纵资源类
     */
    public synchronized void eat()
    {
        System.out.println(Thread.currentThread().getName() + "\t invoke eat()");
    }

    Lock lock = new ReentrantLock();

    @Override
    public void run()
    {
        look();
    }

    public void look()
    {
        /**
         * 可允许多次加锁，但是解锁也必须与加锁配对，否者造成死锁
         */
        lock.lock();
        lock.lock();
        try
        {
            System.out.println(Thread.currentThread().getName() + "\t invoke look()");
            listen();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
            lock.unlock();
        }
    }

    public void listen()
    {
        lock.lock();
        try
        {
            System.out.println(Thread.currentThread().getName() + "\t invoke listen()");
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

/**
 * 缓存资源类
 */
class myCache
{
    private volatile Map<String, Object> map = new HashMap<>();
    /**
     * 由于ReentrantLock是独占锁性能不好，缓存这块我们要用读写锁
     */
    // private Lock lock = new ReentrantLock();
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void set(String key, Object value)
    {
        // lock.lock();
        reentrantReadWriteLock.writeLock().lock();
        try
        {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
            try
            {
                TimeUnit.MILLISECONDS.sleep(300);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // lock.unlock();
            reentrantReadWriteLock.writeLock().unlock();
        }

    }

    public void get(String key)
    {
        // lock.lock();
        reentrantReadWriteLock.readLock().lock();
        try
        {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取...");
            try
            {
                TimeUnit.MILLISECONDS.sleep(300);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成:" + result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // lock.unlock();
            reentrantReadWriteLock.readLock().unlock();
        }

    }

    /**
     * 清空缓存
     */
    public void clear()
    {
        map.clear();
    }

}

