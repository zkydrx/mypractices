package com.zhihei.springAOP.proxy.dynamicproxy.handler;

import com.zhihei.springAOP.proxy.staticproxy.impl.RealBoss;
import com.zhihei.springAOP.proxy.staticproxy.interfaces.Boss;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-07
 * Time: 21:36:55
 * Description:
 */
class JDKProxyHandlerTest
{
    @Test
    public void testJDKProxyHandler()
    {
        Boss realBoss = new RealBoss();
        Boss proxyBoss = (Boss) new JdkProxyHandler(realBoss).getProxyInstance();
        proxyBoss.work();
    }
}