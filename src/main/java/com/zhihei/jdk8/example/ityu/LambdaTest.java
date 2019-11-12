package com.zhihei.jdk8.example.ityu;

import com.zhihei.jdk8.MyInterface;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-12
 * Time: 23:43:55
 * Description:
 */
public class LambdaTest
{
    @Test
    public void testThread()
    {
        /**
         * java8 以前启动一个线程执行某些任务
         */
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("java7启动一个线程");
            }
        }).start();

        new Thread(() -> {
            System.out.println("java8启动一个线程方法1");
        }).start();
        new Thread(() -> System.out.println("java8启动一个线程方法2")).start();

        MyInterface hello_lambda = () -> System.out.println("Hello Lambda");


    }
}
