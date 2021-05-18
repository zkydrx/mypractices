package com.zhihei.interceptor;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-03-01
 * Time: 11:06:04
 * Description:
 * 5.创建客户端 ClientDemo
 */
public class ClientDemo
{
    public static void main(String[] args)
    {
        //创建动态代理处理工具
        DynamicProxyHandler handler = new DynamicProxyHandler();
        //创建业务组件对象
        BusinessFacade business = new BusinessFacadeImpl();
        //用动态代理绑定代理类
        BusinessFacade businessFacadeProxy = (BusinessFacade) handler.bind(business);
        //调用业务组件中的方法，演示拦截器效果
        businessFacadeProxy.doSomething();
    }
}
