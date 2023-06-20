package com.zhihei.jdk8.defaultmethod;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-09 Time: 17:21:48
 * Description:
 */
public interface UserService {
	/**
	 * 普通抽象方法
	 */
	void run();

	/**
	 * 静态方法
	 */
	static void study() {
		System.out.println("Study is a required course in life");
	}

	/**
	 * 默认方法
	 */
	default void work() {
		System.out.println("Love your job so you can live more poetically");
	}

}
