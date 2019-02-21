package KnowledgeableReview201901.java.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-02-21
 * Time: 20:15:46
 * Description:
 */
public class LockDemo2
{

    volatile int  i = 0;
    Lock lock = new ReentrantLock();
    public void add()
    {
        lock.lock();
       try
       {
           i++;
       }
       finally
       {
           lock.unlock();
       }


    }

    public static void main(String[] args)
    {
        LockDemo2 lockDemo = new LockDemo2();
        for (int i = 0; i < 2; i++)
        {

            new Thread(() -> {
                for (int j = 0; j < 10000; j++)
                {
                    lockDemo.add();
                }
            }).run();
        }
        System.out.println(lockDemo.i);
    }
}
