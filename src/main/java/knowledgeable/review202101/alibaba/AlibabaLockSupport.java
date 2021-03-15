package knowledgeable.review202101.alibaba;

import java.util.concurrent.locks.LockSupport;


public class AlibabaLockSupport
{
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args)
    {
        t1 = new Thread(() -> {
            for (int i = 1; i <= 100; i++)
            {
                if (i % 2 == 1)
                {
                    System.out.println(Thread.currentThread().getName() + "::::" + i);
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        }, "t1");
        t2 = new Thread(() -> {
            for (int i = 1; i <= 100; i++)
            {
                if (i % 2 == 0)
                {
                    LockSupport.park();
                    System.out.println(Thread.currentThread().getName() + "::::" + i);
                    LockSupport.unpark(t1);
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
