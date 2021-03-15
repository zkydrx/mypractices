package knowledgeable.review202101.msb.lock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-03-05
 * Time: 00:26:24
 * Description:
 */
public class CallAbleTest implements Callable<String>
{

    @Override
    public String call() throws Exception
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }
        return "ok";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        CallAbleTest callAbleTest = new CallAbleTest();
        FutureTask futureTask = new FutureTask<>(callAbleTest);

        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
        ;
    }
}
