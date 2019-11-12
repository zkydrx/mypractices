package com.zhihei.jdk8.example.ityu.functioninterface;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-12
 * Time: 23:53:36
 * Description:
 */
@FunctionalInterface
public interface MyFunctionInterface
{
    void hello();

    /**
     * 排除掉default修饰的方法
     */
    default void method1(){

    }

    /**
     * 排除掉object下的方法
     * @return
     */
    int hashCode();
}

