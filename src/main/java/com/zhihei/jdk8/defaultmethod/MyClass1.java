package com.zhihei.jdk8.defaultmethod;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-09
 * Time: 15:47:17
 * Description:
 */
public class MyClass1 implements MyInterface1,MyInterface2
{

    @Override
    public void myMethod()
    {
        MyInterface2.super.myMethod();
        System.out.println("如果实现多个接口，多个接口都有同名的默认方法时，一定要重写同名方法");
    }
}
