package fromeFaceBook.JavaProgramming.Thread;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-14
 * Time: 21:26
 * Description:
 */
public class MyThread extends Thread
{
    public static void main(String[] args)
    {
        MyThread my = new MyThread();
        Thread t = new Thread(my);
        my.start();
    }

    public void run()
    {
        for (int i = 0; i <3 ; i++)
        {
            System.out.println(i+"..");
        }
    }
}
