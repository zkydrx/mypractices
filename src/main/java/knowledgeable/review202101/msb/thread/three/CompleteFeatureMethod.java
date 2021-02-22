package knowledgeable.review202101.msb.thread.three;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-01-30
 * Time: 19:23:03
 * Description:
 * 这是java模仿的guava的ListenableFeuture类库完善后的feature.
 */
public class CompleteFeatureMethod
{

    static enum Result
    {
        SUCCESS,
        FAIL,
        CANCELLED;
    }

    static List<MyTask> tasks = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        MyTask taskA = new MyTask("A", 10000, Result.SUCCESS);
        MyTask taskB = new MyTask("B", 20000, Result.SUCCESS);
        MyTask taskC = new MyTask("C", 1, Result.FAIL);
        tasks.add(taskA);
        tasks.add(taskB);
        tasks.add(taskC);


        for (MyTask task : tasks)
        {
            CompletableFuture.supplyAsync(task::runTask).thenAccept((result) -> callbak(result, task));
        }
        System.in.read();

    }

    private static void callbak(Result result, MyTask myTask)
    {
        /**
         * 这里会有同步问题，除非cancel无状态，或者幂等，否则应该加同步处理
         */
        if (Result.FAIL == result)
        {
            for (MyTask myTask1 : tasks)
            {
                if (myTask1 != myTask)
                {
                    myTask1.cancel();
                }
            }
        }
    }

    private static class MyTask
    {
        private String name;
        private int timeInSeconds;
        private Result ret;

        volatile boolean canceling = false;
        volatile boolean canceled = false;

        public MyTask(String name, int timeInSeconds, Result ret)
        {
            this.name = name;
            this.timeInSeconds = timeInSeconds;
            this.ret = ret;
        }


        public Result runTask()
        {
            int interval = 100;
            int total = 0;
            try
            {
                for (; ; )
                {
                    Thread.sleep(interval);
                    total += interval;
                    if (total >= timeInSeconds)
                    {
                        break;
                    }
                    if (canceled)
                    {
                        return Result.CANCELLED;
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return ret;
        }


        public void cancel()
        {
            /**
             * cpu密集型可以使用这种方式优雅结束一个线程。
             */
            if (!canceled)
            {
                synchronized (this)
                {
                    if (canceled)
                    {
                        return;
                    }
                    canceling = true;
                    System.out.println(name + " canceling");
                    try
                    {
                        Thread.sleep(50);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    System.out.println(name + " canceled");
                    canceled = true;
                }
            }
        }
    }
}
