package com.zhihei.ThreadPool;


import org.junit.jupiter.api.TestFactory;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-03-27
 * Time: 22:43:15
 * Description:
 */
public class TestThreadPool
{
    @TestFactory
    public void testThreadPool()
    {
        ThreadPool instance = ThreadPool.getInstance();

        instance.execute(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("1");
            }
        });
        instance.waitFinish();
    }

}
