package com.zhihei.designs;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-10-26 Time: 20:25:34
 * Description: 饿汉模式变种1
 */
public class SingletonDiligentTwo {

	private static final SingletonDiligentTwo instance;

	static {
		instance = new SingletonDiligentTwo();
	}

	private SingletonDiligentTwo() {
	}

	public SingletonDiligentTwo getInstance() {
		return instance;
	}
}
