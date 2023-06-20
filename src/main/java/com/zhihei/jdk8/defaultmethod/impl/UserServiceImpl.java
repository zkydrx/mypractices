package com.zhihei.jdk8.defaultmethod.impl;

import com.zhihei.jdk8.defaultmethod.UserService;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-09 Time: 17:25:34
 * Description:
 */
public class UserServiceImpl implements UserService {

	/**
	 * 实现抽象的方法
	 */
	@Override
	public void run() {
		System.out.println("运动是强身健体的根本！");
	}

	@Override
	public void work() {
		System.out.println("我实现了接口中定义的默认方法，工作是人生的必修课，要么为自己要么为别人！");
	}
}
