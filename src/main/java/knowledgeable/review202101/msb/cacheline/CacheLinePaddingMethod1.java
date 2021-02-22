package knowledgeable.review202101.msb.cacheline;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-02-01
 * Time: 19:01:52
 * Description:
 * 该程序的宗旨是证明cache line 的概念，缓存行对齐。
 * 执行结果是：70ms左右
 * 说明：
 * 我们知道一个cache line 是64个字节，在这个程序中，T类继承了padding类，
 * 那么他就有了8个属性，这8个long类型的变量一共是64个字节，正好沾满了一个缓存行。
 * 这个时候每个cpu对T的值进行赋值的时候就是直接赋值，不用与另外的cpu进行数据同步了。
 * 是真正意义上的并行所以效率会高出很多。
 */
public class CacheLinePaddingMethod1
{
    private static class Padding
    {
        public volatile long p1, p2, p3, p4, p5, p6, p7;
    }

    private static class T extends Padding
    {
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static
    {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException
    {
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 10000000L; i++)
            {
                arr[0].x = i;
            }
        }, "threadName");

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 10000000L; i++)
            {
                arr[1].x = i;
            }
        }, "threadName");

        long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime() - start) / 1000000);
    }
}
