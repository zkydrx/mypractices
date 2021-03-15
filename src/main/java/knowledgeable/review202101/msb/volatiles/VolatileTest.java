package knowledgeable.review202101.msb.volatiles;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-02-26
 * Time: 11:14:02
 * Description:
 * Volatile 测试
 */
public class VolatileTest
{
    public static boolean init = false;

    public static void main(String[] args) throws InterruptedException
    {
        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + " 开始启动");
            while (!init)
            {
                System.out.println(Thread.currentThread().getName() + " 任务进行中，此时init的值：" + init);
            }
            System.out.println(Thread.currentThread().getName() + " 任务完成,此时init的值：" + init);
        }, "threadNameA").start();

        Thread.sleep(1000);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 开始启动");
            init = true;
            System.out.println(Thread.currentThread().getName() + " 任务完成，此时init的值为：" + init);
        }, "threadNameB").start();
    }
}
