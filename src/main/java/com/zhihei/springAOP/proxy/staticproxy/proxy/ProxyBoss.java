package com.zhihei.springAOP.proxy.staticproxy.proxy;

import com.zhihei.springAOP.proxy.staticproxy.interfaces.Boss;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-07 Time: 21:00:00
 * Description: boss的静态代理类
 */
public class ProxyBoss implements Boss {
	/**
	 * 接受真实的boss
	 */
	private Boss boss;

	/**
	 * 通过构造方法传进来真实的构造对象
	 *
	 * @param boss
	 */
	public ProxyBoss(Boss boss) {
		this.boss = boss;
	}

	@Override
	public void work() {
		System.out.println("整理工作会议以及准备工作任务");
		this.boss.work();
		System.out.println("准备衣食住行");
	}
}
