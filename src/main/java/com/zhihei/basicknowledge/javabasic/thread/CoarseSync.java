package com.zhihei.basicknowledge.javabasic.thread;

/**
 * 锁粗化 通过扩大加锁的范围，避免反复的加锁和解锁
 */
public class CoarseSync {
	public static String copyString100Times(String target) {
		int i = 0;
		/**
		 * StringBuffer是线程安全的。
		 */
		StringBuffer sb = new StringBuffer();
		while (i < 100) {
			sb.append(target);
		}
		return sb.toString();
	}
}
