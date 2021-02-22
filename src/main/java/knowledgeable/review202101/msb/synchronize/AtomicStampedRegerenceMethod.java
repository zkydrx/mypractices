package knowledgeable.review202101.msb.synchronize;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-02-01
 * Time: 00:04:50
 * Description:
 * AtomicStampedRegerence 可以解决cas的aba问题。
 * 这里写一个小例子来做一下示范
 * 实验证明，AtomicStampedRegerence可避免ABA的问题，而AtomicInteger无法避免ABA问题
 */
public class AtomicStampedRegerenceMethod
{
    public static void main(String[] args)
    {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(0, 1000);


        new Thread(() -> {
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            atomicInteger.compareAndSet(0, 100);
            System.out.println(System.currentTimeMillis() + "此时线程a睡眠1秒后atomicInteger的值：" + atomicInteger);
            if (atomicInteger.get() == 100)
            {
                System.out.println("成功将atomicInteger的值从0-->100");
            }
        }, "a").start();
        new Thread(() -> {
            try
            {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            atomicInteger.compareAndSet(100, 0);
            System.out.println(System.currentTimeMillis() + "此时线程e睡眠5秒后atomicInteger的值：" + atomicInteger);
            if (atomicInteger.get() == 0)
            {
                System.out.println("成功将atomicInteger的值从100-->0，至此说明成功完成了ABA的模拟。");
            }

        }, "e").start();
        new Thread(() -> {
            try
            {
                TimeUnit.SECONDS.sleep(15);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            atomicInteger.incrementAndGet();
            System.out.println("线程b睡眠了15秒以后,atomicInteger的值变成了：" + atomicInteger);
        }, "b").start();


        /**
         * 线程c与线程d同时休眠1秒钟，同时唤醒此时，atomicStampedReference的版本号只有一个，就会出现
         * 三次compareAndSet有不一致的情况，因此就能验证AtomicStampedReference能避免ABA的问题。
         */
        new Thread(() -> {
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            boolean b1 = atomicStampedReference.compareAndSet(1, 0, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            boolean b2 = atomicStampedReference.compareAndSet(0, 1, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);

            System.out.println("b1===" + b1 + "\t" + "b2===" + b2 + "此时的版本号：" + atomicStampedReference.getStamp());
        }, "c").start();

        new Thread(() -> {
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            boolean b = atomicStampedReference.compareAndSet(0, 1, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println("b===" + b + " 此时的版本号：" + atomicStampedReference.getStamp());
        }, "d").start();

    }


}
