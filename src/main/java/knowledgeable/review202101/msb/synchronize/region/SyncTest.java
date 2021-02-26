package knowledgeable.review202101.msb.synchronize.region;


import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-02-24
 * Time: 16:08:40
 * Description:
 * 验证synchronized的作用域。
 * 修饰代码块：大括号括起来的代码，作用于调用的对象。
 * 修饰方法：整个方法，作用于调用的对象。
 * 修饰静态方法：整个静态方法，作用于所有对象。
 * 修饰类：括号括起来的部分，作用于所有对象。
 */
public class SyncTest
{

    public void test0(int j)
    {
        /**
         * 修饰代码块：大括号括起来的代码，作用于调用的对象
         */
        synchronized (this)
        {
            for (int i = 0; i < 20; i++)
            {
                System.out.println("test:" + j);
            }
        }
    }


    /**
     * 说明：
     * 在本测试中开了两个线程调用同一个对象中的synchronized代码块，输出为先打印第一个线程的输出，再打印第二个线程的输出。
     */
    @Test
    public void testOne()
    {
        SyncTest syncTest1 = new SyncTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> syncTest1.test0(1));
        executorService.execute(() -> syncTest1.test0(2));
    }

    /**
     * 说明：
     * 在本测试中开了两个线程调用两个对象中的synchronized代码块，输出为交替打印输出。
     * <p>
     * 结论：synchronized修饰代码块作用域为在一个对象中。
     */
    @Test
    public void testTwo()
    {
        SyncTest syncTest1 = new SyncTest();
        SyncTest syncTest2 = new SyncTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> syncTest1.test0(1));
        executorService.execute(() -> syncTest2.test0(2));
    }


    /**
     * 修饰方法：整个方法，作用于调用的对象
     *
     * @param j
     */
    public synchronized void test1(int j)
    {
        for (int i = 0; i < 20; i++)
        {
            System.out.println("test:" + j);
        }
    }


    /**
     * 说明：
     * 在本测试中开了两个线程调用同一个对象中的synchronized修饰的方法，
     * 输出为先打印第一个线程的输出，再打印第二个线程的输出。
     */
    @Test
    public void testThree()
    {
        SyncTest syncTest1 = new SyncTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> syncTest1.test1(1));
        executorService.execute(() -> syncTest1.test1(2));
    }


    /**
     * 说明：
     * 在本测试中开了两个线程调用不同实列的synchronized修饰的方法，输出为第一个线程，第二个线程交替执行。
     * 注意:父类中定义了synchronized修饰的方法，由子类继承时，需要在子类显示指定synchronized修饰。
     * synchronized不属于方法声明的一部分，不能被继承。
     * 结论：对比可以得出，synchronized修饰的方法作用域为在一个对象中。
     */
    @Test
    public void testFour()
    {
        SyncTest syncTest1 = new SyncTest();
        SyncTest syncTest2 = new SyncTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> syncTest1.test1(1));
        executorService.execute(() -> syncTest2.test1(2));
    }


    /**
     * 修饰静态方法：整个静态方法，作用于所有对象
     *
     * @param j
     */
    public static synchronized void print(int j)
    {
        for (int i = 0; i < 20; i++)
        {
            System.out.println("test:" + j);
        }
    }

    /**
     * 在本测试中，无论是一个实例对象，还是两个实例对象，两个线程顺序执行，可以得出synchronized修饰的静态方法作用域为所有对象。
     *
     * @param args
     */
    public static void main(String[] args)
    {
        SyncTest syncTest1 = new SyncTest();
        // SyncTest syncTest2 = new SyncTest();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> syncTest1.print(1));
        executorService.execute(() -> syncTest1.print(2));
        // executorService.execute(() -> syncTest2.print(2));
    }


    /**
     * 修饰类：括号括起来的部分，作用于所有对象
     *
     * @param j
     */
    public void test2(int j)
    {
        synchronized (SyncTest.class)
        {
            for (int i = 0; i < 20; i++)
            {
                System.out.println("test:" + j);
            }
        }
    }


    /**
     * 说明：
     * 在本测试中开了两个线程调用同一个对象中的synchronized代码块，输出为先打印第一个线程的输出，再打印第二个线程的输出。
     */
    @Test
    public void testFive()
    {
        SyncTest syncTest1 = new SyncTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> syncTest1.test2(1));
        executorService.execute(() -> syncTest1.test2(2));
    }

    /**
     * 说明：
     * 在本测试中开了两个线程调用同一个对象中的synchronized代码块，输出为先打印第一个线程的输出，再打印第二个线程的输出。
     * 结论：对比可以得出，synchronized修饰类的作用域是作用域所有对象
     */
    @Test
    public void testSix()
    {
        SyncTest syncTest1 = new SyncTest();
        SyncTest syncTest2 = new SyncTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> syncTest1.test2(1));
        executorService.execute(() -> syncTest2.test2(2));
    }

}
