package KnowledgeableReview201803.multithreading;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-20
 * Time: 09:17:09
 * Description:
 * multithreading
 */
public class Multithreading extends Thread
{
    private int x;
    public void run()
    {
        System.out.println("extends Thread.");
    }
}

class MultithreadingOne implements Runnable
{
    private int y;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run()
    {
        System.out.println("Implement runnable.");
    }
}

class MultithreadingTwo implements Callable
{

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public MultithreadingOne call() throws Exception
    {
        System.out.println("*");
        return new MultithreadingOne();
    }
}
 class TestAll
{
    public static void main(String[] args) throws Exception
    {
        for (int i = 0; i < 10; i++)
        {
            Thread multithreading = new Multithreading();
            multithreading.start();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }



        MultithreadingOne multithreadingOne = new MultithreadingOne();

        for (int i = 0; i < 10; i++)
        {
            Thread thread = new Thread(multithreadingOne);

            thread.start();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        MultithreadingTwo multithreadingTwo = new MultithreadingTwo();

        for (int i = 0; i < 10; i++)
        {
            MultithreadingOne multithreadingOne1 = multithreadingTwo.call();
            Thread thread = new Thread(multithreadingOne1);
            thread.start();
            Thread.sleep(1000);
        }
    }
}