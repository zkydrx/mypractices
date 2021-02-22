package knowledgeable.review202101.msb.synchronize;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-01-30
 * Time: 10:18:31
 * Description:
 * atomicInteger保证原子性，线程可见性，以及禁止指令重排序
 */
public class AtomicIntegerMethod
{
    private static AtomicInteger automicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException
    {
        Thread[] threads = new Thread[100];
        CountDownLatch countDownLatch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++)
        {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 10000; i1++)
                {
                    automicInteger.incrementAndGet();
                }
                countDownLatch.countDown();
            }, "threadName");
        }
        Arrays.stream(threads).forEach(Thread::start);
        countDownLatch.await();
        System.out.println(automicInteger);
    }
}
