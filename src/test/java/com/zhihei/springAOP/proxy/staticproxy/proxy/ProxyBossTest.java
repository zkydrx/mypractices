package com.zhihei.springAOP.proxy.staticproxy.proxy;

import com.zhihei.springAOP.proxy.staticproxy.impl.RealBoss;
import com.zhihei.springAOP.proxy.staticproxy.interfaces.Boss;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-07
 * Time: 21:04:33
 * Description:
 */
class ProxyBossTest
{
    @Test
    public void testProxyBoss()
    {
        Boss realBoss = new RealBoss();
        Boss proxyBoss = new ProxyBoss(realBoss);
        proxyBoss.work();
    }
}