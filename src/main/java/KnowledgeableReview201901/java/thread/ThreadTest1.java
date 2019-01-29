package KnowledgeableReview201901.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-29
 * Time: 11:02:44
 * Description:
 */
public class ThreadTest1
{
    private int i =2;

    class Plus implements Runnable
    {

        @Override
        public void run()
        {
            for (int i = 0; i < 5; i++)
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
            for (int i = 0; i < 5; i++)
            {
                decrease();
            }
        }
    }

    class Multiply implements Callable<Integer>
    {

        @Override
        public Integer call() throws Exception
        {
            for (int j = 0; j < 5; j++)
            {
                mul();
            }
            return 1;
        }
    }

    class Divide extends Thread
    {
        @Override
        public void run()
        {
            for (int j = 0; j < 5; j++)
            {
                div();
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

    private synchronized Integer mul()
    {
        i *=2;
        System.out.println(Thread.currentThread().getName() + "mul***:" + i);
        return i;
    }

    private synchronized void div()
    {
        i /=2;
        System.out.println(Thread.currentThread().getName() + "div///:" + i);
    }
    public static void main(String[] args)
    {
        ThreadTest1 t = new ThreadTest1();
        Plus p = t.new Plus();
        Dec d = t.new Dec();
        Multiply m = t.new Multiply();
        Divide di = t.new Divide();
        for (int i = 0; i < 2; i++)
        {
            Thread thread = new Thread(p);
            thread.start();
            thread= new Thread(d);
            thread.start();
            FutureTask<Integer> futureTask = new FutureTask<>(m);
            new Thread(futureTask).start();
            thread = new Thread(di);
            thread.start();

        }
    }
}
