package com.zhihei.jdk8.defaultmethod;

/**
 * @author ZKY
 * @createTime 2019/7/6 23:12
 * @description
 */

public interface MyInterface2
{
    default void myMethod()
    {
        System.out.println("MyInterface2");
    }
}
