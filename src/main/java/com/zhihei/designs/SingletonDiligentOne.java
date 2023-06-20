package com.zhihei.designs;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-10-26 Time: 20:25:34
 * Description: 饿汉模式
 */
public class SingletonDiligentOne {
	private static SingletonDiligentOne instance = new SingletonDiligentOne();

	private SingletonDiligentOne() {
	}

	public static SingletonDiligentOne getInstance() {
		return instance;
	}
}
