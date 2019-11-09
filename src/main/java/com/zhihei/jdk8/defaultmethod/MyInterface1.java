package com.zhihei.jdk8.defaultmethod;

/**
 * @author ZKY
 * @createTime 2019/7/6 23:09
 * @description
 */

public interface MyInterface1
{

    default void myMethod()
    {
        System.out.println("MyInterface1");
    }
}
