package com.zhihei.basicknowledge.jmm.singleton;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-19 Time: 00:05:58
 * Description:
 */
public class SingletonTest {
	/**
	 * 加上volatile禁止指令重排，防止高并发导致的异常结果。
	 */
	public static volatile SingletonTest instance = null;

	private SingletonTest() {
		System.out.println(Thread.currentThread().getName() + "\t 私有构造器");
	}

	/**
	 * dcl(double chek lock 双重校验锁)
	 *
	 * @return
	 */
	public static synchronized SingletonTest getInstance() {
		if (instance == null) {
			synchronized (SingletonTest.class) {
				if (instance == null) {
					instance = new SingletonTest();
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		/**
		 * 不加sychronized在单线程模式下完全正确。
		 */
		// System.out.println(SingletonTest.getInstance()==SingletonTest.getInstance());
		// System.out.println(SingletonTest.getInstance()==SingletonTest.getInstance());
		// System.out.println(SingletonTest.getInstance()==SingletonTest.getInstance());
		/**
		 * 不加synchronized 同步锁的话，单例模式在高并发环境下失效 example: 1 私有构造器 0 私有构造器
		 */
		for (int i = 0; i < 1000; i++) {
			new Thread(() -> {
				SingletonTest.getInstance();
			}, String.valueOf(i)).start();
		}
	}
}
