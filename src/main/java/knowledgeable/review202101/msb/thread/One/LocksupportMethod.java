package knowledgeable.review202101.msb.thread.One;

import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-01-29
 * Time: 17:31:45
 * Description:
 * 线程A打印数字，线程B打印字母，两个线程交替打印。1A2B3C4D...
 */
public class LocksupportMethod
{
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args)
    {
        char[] num = {'1', '2', '3', '4', '5', '6', '7', '8'};
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};


        t1 = new Thread(() -> {
            for (char c : num)
            {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");
        t2 = new Thread(() -> {
            for (char c : chars)
            {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
