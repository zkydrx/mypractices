package com.zhihei.jdk8.example.ityu.functioninterface;

import com.zhihei.jdk8.example.ityu.functioninterface.impl.MyFunctionInterfaceImpl;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-13
 * Time: 00:01:10
 * Description:
 * 函数式接口的使用:一般可以作为方法的参数和返回值类型
 */
public class FunctionInterfaceTest
{
    /**
     * 定义一个方法,参数使用函数式接口MyFunctionalInterface
     *
     * @param myFunctionInterface
     */
    public static void show(MyFunctionInterface myFunctionInterface)
    {
        myFunctionInterface.hello();
    }

    @Test
    public void testFunctionInterface()
    {
        /**
         * 调用show方法,方法的参数是一个接口,所以可以传递接口的实现类对象
         */
        show(new MyFunctionInterfaceImpl());

        /**
         * 调用show方法,方法的参数是一个接口,所以我们可以传递接口的匿名内部类
         */
        show(new MyFunctionInterface()
        {
            @Override
            public void hello()
            {
                System.out.println("使用匿名内部类重写MyFunctionInterface接口中的抽象方法");
            }
        });
        /**
         * 调用show方法，由于show方法的参数是一个函数式接口，所以我们可以使用lambda表达式
         */
        show(() -> {
            System.out.println("使用lambda表达式重写MyFunctionInterface接口中的抽象方法");
        });

        /**
         * 简洁版的lambda
         */
        show(() -> System.out.println("使用lambda表达式重写MyFunctionInterface接口中的抽象方法"));
    }


    /**
     * 函数式接口和普通方法的差异
     */
    public static void print1(String message)
    {
        System.out.println(message);
    }

    public static void print2(Supplier<String> message)
    {
        System.out.println(message.get());
    }

    /**
     * 以上代码会得到同样的结果，但使用了函数式接口相当于把数据进行了延迟加载。
     * 使用函数式接口，数据并没有完全确定，等到真正调用的时候才确定，类似推模型。
     */
    @Test
    public void testSuplier()
    {
        print1("Hello Suplier<T>");
        print2(() -> "Hello Suplier<T>");
    }

    public static void showLog1(int level, String message)
    {
        if (level == 1)
        {
            System.out.println(message);
        }
    }

    public static void showLog2(int level, MessageBuilder messageBuilder)
    {
        if (level == 1)
        {
            System.out.println(messageBuilder.builderMessage());
        }
    }

    /**
     * @FunctionalInterface注解
     */
    @Test
    public void testMessageBuilder()
    {
        String message1 = "Java";
        String message2 = "Python";
        String message3 = "Go";

        showLog1(1, message1 + message2 + message3);
        /**
         * 分析：使用Lambda表达式作为参数传递,仅仅是把参数传递到showLog方法中，
         * 只有满足条件,日志的等级是1级才会调用接口MessageBuilder中的方法builderMessage，
         * 才会进行字符串的拼接；
         * 如果条件不满足,日志的等级不是1级，那么MessageBuilder接口中的方法builderMessage
         * 也不会执行，所以拼接字符串的代码也不会执行，所以不会存在性能的浪费
         */
        showLog2(1, () -> message1 + message2 + message3);
    }


    /**
     * 定义一个方法startThread,方法的参数使用函数式接口Runnable
     *
     * @param runnable
     */
    public void startThread(Runnable runnable)
    {
        /**
         * 开启多线程
         */
        new Thread(runnable).start();
    }

    /**
     * 使用函数式接口作为方法的参数
     */
    @Test
    public void testStartThread()
    {
        /**
         * 调用startThread方法,方法的参数是一个接口,那么我们可以传递这个接口的匿名内部类
         */
        startThread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println(Thread.currentThread().getName() + "-->线程启动了");
            }
        });
        /**
         * 调用startThread方法,方法的参数是一个函数式接口,所以可以传递Lambda表达式
         */
        startThread(() -> {
            System.out.println(Thread.currentThread().getName() + "-->线程启动了");
        });

        /**
         * 简洁版的lambda
         */
        startThread(() -> System.out.println(Thread.currentThread().getName() + "-->线程启动了"));
    }
}
