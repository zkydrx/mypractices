package com.zhihei.springAOP.proxy.staticproxy.impl;

import com.zhihei.springAOP.proxy.staticproxy.interfaces.Boss;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-07 Time: 20:58:16
 * Description:
 */
public class RealBoss implements Boss {

	@Override
	public void work() {
		System.out.println("谈生意");
	}
}
