package com.zhihei.springAOP.proxy.dynamicproxy.handler;

import com.zhihei.springAOP.proxy.staticproxy.impl.RealBoss;
import com.zhihei.springAOP.proxy.staticproxy.interfaces.Boss;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-07
 * Time: 21:53:41
 * Description:
 */
class CglibProxyHandlerTest
{
    @Test
    public void testCglibProxyHandler()
    {
        Boss realBoss = new RealBoss();
        Boss proxyBoss = (Boss) new CglibProxyHandler().getProxyInstance(realBoss);
        proxyBoss.work();
    }
}