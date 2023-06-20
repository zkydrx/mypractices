package com.zhihei.designs;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-10-26 Time: 20:25:34
 * Description: 饿汉模式变种2
 * Singleton类被装载instance不一定被初始化，因为内部类SingletonHolder没有被主动使用，
 * 只有显示调用getInstance才会显示装载SingletonHolder 类，从而实例化instance
 */
public class SingletonDiligentThree {
	private static class SingletonHolder {
		private static final SingletonDiligentThree INSTANCE = new SingletonDiligentThree();
	}

	private SingletonDiligentThree() {
	}

	public static final SingletonDiligentThree getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
