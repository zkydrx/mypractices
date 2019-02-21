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
    //    AtomicInteger i = new AtomicInteger(0);
    int i = 0;

    public void add()
    {
        //        i.incrementAndGet();
        i++;
    }

    public static void main(String[] args)
    {
        LockDemo lockDemo = new LockDemo();
        for (int i = 0; i < 2; i++)
        {

            new Thread(() -> {
                for (int j = 0; j < 10000; j++)
                {
                    lockDemo.add();
                }
            }).run();
        }
        System.out.println(lockDemo.i);
    }
}
