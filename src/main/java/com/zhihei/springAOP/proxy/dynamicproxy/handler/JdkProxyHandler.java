package com.zhihei.springAOP.proxy.dynamicproxy.handler;

import com.zhihei.springAOP.proxy.staticproxy.interfaces.Boss;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-07
 * Time: 21:13:25
 * Description:
 */
public class JdkProxyHandler
{
    /**
     * 用來接受真boss
     */
    private Object realBoss;

    /**
     * 通过构造方法来传进去真实的明星对象
     *
     * @param boss
     */
    public JdkProxyHandler(Boss boss)
    {
        super();
        this.realBoss = boss;
    }

    /**
     * 给真实对象生成一个代理的实例
     *
     * @return
     */
    public Object getProxyInstance()
    {
        /**
         * Proxy.newProxyInstance() 方法，该方法接收三个参数：
         * 第一个参数指定当前目标对象使用的类加载器,获取加载器的方法是固定的；
         * 第二个参数指定目标对象实现的接口的类型；
         * 第三个参数指定动态处理器，
         * 执行目标对象的方法时,会触发事件处理器的方法。网上针对第三个参数的写法都是 new
         * 一个匿名类来处理，我这直接用的 Java8 里面的 lamda 表达式来写的，都一样。底层原理使用的是反射机制

         */
        return Proxy.newProxyInstance(realBoss.getClass().getClassLoader(), realBoss.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("整理工作会议以及准备工作任务");
            Object invoke = method.invoke(realBoss, args);
            System.out.println("准备衣食住行");
            return invoke;
        });
    }
}
