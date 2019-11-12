package com.zhihei.jdk8.example.ityu.functioninterface.impl;

import com.zhihei.jdk8.example.ityu.functioninterface.MyFunctionInterface;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-12
 * Time: 23:59:12
 * Description:
 */
public class MyFunctionInterfaceImpl implements MyFunctionInterface
{

    @Override
    public void hello()
    {
        System.out.println("com from MyFunctionInterfaceImpl ===>"+Thread.currentThread().getName());
    }
}
