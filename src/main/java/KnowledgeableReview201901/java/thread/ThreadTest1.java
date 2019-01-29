package KnowledgeableReview201901.java.thread;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-29
 * Time: 11:02:44
 * Description:
 */
public class ThreadTest1
{
    private int i;

    class Plus implements Runnable
    {

        @Override
        public void run()
        {
            for (int i = 0; i < 10; i++)
            {
                plus();
            }
        }
    }

    class Dec implements Runnable
    {

        @Override
        public void run()
        {
            for (int i = 0; i < 10; i++)
            {
                decrease();
            }
        }
    }

    private synchronized void plus()
    {
        System.out.println(Thread.currentThread().getName() + "plus+++:" + i++);
    }

    private synchronized void decrease()
    {
        System.out.println(Thread.currentThread().getName() + "decrease---:" + i--);
    }

    public static void main(String[] args)
    {
        ThreadTest1 t = new ThreadTest1();
        Plus p = t.new Plus();
        Dec d = t.new Dec();
        for (int i = 0; i < 2; i++)
        {
            Thread thread = new Thread(p);
            thread.start();
            thread= new Thread(d);
            thread.start();
        }
    }
}
