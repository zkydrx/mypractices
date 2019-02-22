package KnowledgeableReview201901.java.thread;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-02-21
 * Time: 20:15:46
 * Description:
 */
public class LockDemo
{
    volatile int i = 0;

    public void add()
    {
        i++;
    }

    public static void main(String[] args) throws InterruptedException
    {
        LockDemo lockDemo = new LockDemo();
        /**
         * 期望20000
         */
        for (int i = 0; i < 2; i++)
        {

            new Thread(() -> {
                for (int j = 0; j < 10000; j++)
                {
                    lockDemo.add();
                }
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(lockDemo.i);
    }
}
