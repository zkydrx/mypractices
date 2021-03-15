package knowledgeable.review202101.msb.lock;

import scala.actors.threadpool.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-04
 * Time: 23:30:10
 * Description:
 */
public class LockTest
{
    public Lock lock = new Lock();
    // public ReInLock reInLock = new ReInLock();
    public ReentrantLock reInLock = new ReentrantLock();

    public void m1() throws InterruptedException
    {
        lock.lock();
        System.out.println("m1方法执行中");
        m2();
        lock.unlock();
    }

    public void m2() throws InterruptedException
    {
        lock.lock();
        System.out.println("m2方法执行中");
        lock.unlock();
    }


    public void m3() throws InterruptedException
    {
        reInLock.lock();
        System.out.println("m3,上锁以后，锁的次数：" + reInLock.getHoldCount());
        System.out.println("m3方法执行中");
        m4();
        reInLock.unlock();
        System.out.println("m3,解锁以后，锁的次数：" + reInLock.getHoldCount());
    }

    public void m4() throws InterruptedException
    {
        reInLock.lock();
        System.out.println("m4,上锁以后，锁的次数：" + reInLock.getHoldCount());

        System.out.println("m4方法执行中");
        reInLock.unlock();
        System.out.println("m4,解锁以后，锁的次数：" + reInLock.getHoldCount());

    }

    public static void main(String[] args) throws InterruptedException
    {
        LockTest test = new LockTest();
        // test.m1();
        test.m3();
    }


}

/**
 * 这种情况是不可重入锁。
 */
//锁就像门一样可以开，可以关
class Lock
{
    /**
     * 如果已经调用了这个锁，我们将这个锁的值改为true
     */
    private boolean flag;

    /**
     * 上锁
     *
     * @throws InterruptedException
     */
    public synchronized void lock() throws InterruptedException
    {
        while (flag)
        {
            /**
             * 这里表示我们调用锁了，让线程等待
             */
            wait();
        }
        flag = true;
    }

    /**
     * 解锁
     */
    public synchronized void unlock()
    {
        flag = false;
        notify();
    }

}


/**
 * 可重入锁
 * 1.必须保证同一个线程
 * 2.计数器用来记录你具体重入了多少次，当重入次数为零的时候真正释放锁
 */
class ReInLock
{
    /**
     * 如果已经调用了这个锁，我们将这个锁的值改为true
     */
    private boolean flag;
    private Thread thread;//当前线程

    public int getHoldCount()
    {
        return holdCount;
    }

    private int holdCount;//锁的次数

    /**
     * 上锁
     *
     * @throws InterruptedException
     */
    public synchronized void lock() throws InterruptedException
    {
        /**
         * 当前线程和你属性中的属性相比较。
         */
        Thread currentThread = Thread.currentThread();
        while (flag && thread != currentThread)
        {
            /**
             * 这里表示我们调用锁了，让线程等待
             */
            wait();
        }
        flag = true;
        thread = currentThread;
        holdCount++;
    }

    /**
     * 解锁
     * 重入锁：同一个线程，访问同一个对象不应该死锁（阻塞）
     */
    public synchronized void unlock()
    {

        if (Thread.currentThread() == thread)
        {
            holdCount--;
            if (holdCount == 0)
            {
                flag = false;
                notify();
            }
        }
    }

}
