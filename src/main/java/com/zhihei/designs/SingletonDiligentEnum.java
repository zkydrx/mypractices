package com.zhihei.designs;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-10-26 Time: 20:37:15
 * Description: 饿汉模式变种3 枚举（既可以避免多线程同步问题，还可以防止被反序列化重建对象）
 */
public enum SingletonDiligentEnum {
	INSTANCE;

	public String getTheMessage(String message) {
		return Thread.currentThread().getName() + ":::" + message;
	}

	public static void main(String[] args) {
		SingletonDiligentEnum instance1 = SingletonDiligentEnum.INSTANCE;
		SingletonDiligentEnum instance2 = SingletonDiligentEnum.INSTANCE;
		System.out.println(instance1.getTheMessage("instance1"));
		System.out.println(instance2.getTheMessage("instance2"));
		System.out.println(instance1.equals(instance2));
		System.out.println(instance1 == instance2);

	}
}
