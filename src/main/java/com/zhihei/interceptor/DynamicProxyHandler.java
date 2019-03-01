package com.zhihei.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-03-01
 * Time: 10:50:34
 * Description:
 */
public class DynamicProxyHandler implements InvocationHandler
{
    //声明被代理的对象
    private Object business;
    //创建拦截器
    private IntercePtorClass intercePtor = new IntercePtorClass();

    /**
     * Proxy.newProxyInstance(参数1, 参数2, 参数3)
     *  参数1, 表示被代理类的 ClassLoader
     *  参数2, 表示被代理的接口
     *  参数3, 表示代理处理器对象
     *  该方法，返回代理实例
     * @param business
     * @return
     */
    public Object bind(Object business)
    {
        this.business =business;
        return Proxy.newProxyInstance(business.getClass().getClassLoader(),business.getClass().getInterfaces(),this);
    }


    /**
     * 代理需要调用的方法，并在该方法调用前后，先调用连接器的方法。
 　　 *
 　　 * @param proxy 代理类对象
 　　 * @param method 被代理的接口方法
 　　 * @param args 被代理接口方法的参数
 　　 * @return 方法调用返回的结果
 　　 * @throws Throwable
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        Object result = null;
        intercePtor.before();
        method.invoke(business,args);
        intercePtor.after();
        return null;
    }
}
