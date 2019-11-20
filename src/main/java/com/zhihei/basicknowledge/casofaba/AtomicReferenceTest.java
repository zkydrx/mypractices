package com.zhihei.basicknowledge.casofaba;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-20
 * Time: 11:58:41
 * Description:
 * 原子引用可以是自定义的类也进行原子的操作。
 */
@Data
@ToString
@AllArgsConstructor
class User
{
    String name;
    int age;
}

public class AtomicReferenceTest
{

    @Test
    public void testAtomicReference()
    {
        AtomicReference<User> atomicReference = new AtomicReference<>();
        User user1 = new User("zky", 18);
        User user2 = new User("drx", 8);
        User user3 = new User("wg", 20);
        atomicReference.set(user1);
        System.out.println(atomicReference.compareAndSet(user1, user2) + "\t user current:" + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(user2, user3) + "\t user current:" + atomicReference.get().toString());
    }

    /**
     * 解决aba问题
     * 通过AtomicStampedReference引用类来解决
     */
    @Test
    public void testAtomicAba()
    {
        AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "a").start();

        new Thread(() -> {
            try
            {
                TimeUnit.SECONDS.sleep(2);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2020) + "\tcurrent data:" + atomicReference.get());
        }, "b").start();
        try
        {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 第1次版本号:" + atomicStampedReference.getStamp());
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 99, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t 第2次版本号:" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(99, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t 第3次版本号:" + atomicStampedReference.getStamp());
        }, "c").start();
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();

            System.out.println(Thread.currentThread().getName() + "\t 第1次版本号:" + stamp);
            try
            {
                TimeUnit.SECONDS.sleep(3);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + atomicStampedReference.compareAndSet(100,
                                                                                                              9999,
                                                                                                              stamp,
                                                                                                              stamp + 1) + "\t 当前最新版本号:" + atomicStampedReference.getStamp() +
                                       "\t当前的数据值：" + atomicStampedReference
                    .getReference());

        }, "d").start();
    }
}
