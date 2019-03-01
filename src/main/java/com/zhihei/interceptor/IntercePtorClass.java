package com.zhihei.interceptor;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-03-01
 * Time: 10:47:04
 * Description:
 * 创建拦截器 InterceptorClass
 */
public class IntercePtorClass
{
    //在action之前调用
    public void before()
    {
        System.out.println("在拦截器InterceptorClass中调用方法：before()");
    }

    //在action之后调用
    public void after()
    {
        System.out.println("在拦截器InterceptorClass中调用方法：after()");
    }
}
