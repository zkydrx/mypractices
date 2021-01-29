package knowledgeable.review202101.msb.thread.One;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-01-29
 * Time: 18:15:46
 * Description:
 */
public class lockConditionMethod
{
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args)
    {

        char[] num = {'1', '2', '3', '4', '5', '6', '7', '8'};
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();


        new Thread(() -> {
            lock.lock();
            try
            {
                for (char c : num)
                {
                    System.out.print(c);
                    countDownLatch.countDown();
                    condition2.signal();
                    condition1.await();
                }
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

        }, "t1").start();

        new Thread(() -> {
            lock.lock();
            try
            {
                countDownLatch.await();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            try
            {
                for (char c : chars)
                {
                    System.out.print(c);
                    condition1.signal();
                    condition2.await();
                }
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

        }, "t2").start();

    }


}
