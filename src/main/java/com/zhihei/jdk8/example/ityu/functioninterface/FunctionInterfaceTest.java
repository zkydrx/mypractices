package com.zhihei.jdk8.example.ityu.functioninterface;

import com.zhihei.jdk8.example.ityu.functioninterface.impl.MyFunctionInterfaceImpl;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-13
 * Time: 00:01:10
 * Description:
 *  函数式接口的使用:一般可以作为方法的参数和返回值类型
 */
public class FunctionInterfaceTest
{
    /**
     * 定义一个方法,参数使用函数式接口MyFunctionalInterface
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
        show(()->{
            System.out.println("使用lambda表达式重写MyFunctionInterface接口中的抽象方法");
        });

        /**
         * 简洁版的lambda
         */
        show(()-> System.out.println("使用lambda表达式重写MyFunctionInterface接口中的抽象方法"));
    }
}
