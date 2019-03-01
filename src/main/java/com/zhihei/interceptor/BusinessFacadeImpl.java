package com.zhihei.interceptor;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-03-01
 * Time: 10:45:48
 * Description:
 *  创建业务组件实现类 BusinessClass
 */
public class BusinessFacadeImpl implements BusinessFacade
{

    @Override
    public void doSomething()
    {
        System.out.println("在业务组件 BusinessClass 中调用方法: doSomething()");
    }
}
