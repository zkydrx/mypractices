package knowledgeable.review202101.aboutlock;

import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-02-01
 * Time: 01:13:37
 * Description:
 */
public class AboutLock
{
    private static Thread t1;
    private static Thread t2;

    /**
     * LockSupport 可控制哪个线程先执行，哪个线程后执行。不需要countDownLatch（门栓）控制线程的执行顺序.
     *
     * @param args
     */
    public static void main(String[] args)
    {
        t1 = new Thread(() -> {

            for (int i = 0; i < 100; i++)
            {
                if (i % 2 == 0)
                {
                    LockSupport.park();
                    System.out.println(i);
                    LockSupport.unpark(t2);
                }
            }
        }, "a");
        t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++)
            {
                if (i % 2 == 1)
                {
                    LockSupport.unpark(t1);
                    System.out.println(i);
                    LockSupport.park();
                }
            }
        }, "threadName");

        t1.start();
        t2.start();

    }
}
