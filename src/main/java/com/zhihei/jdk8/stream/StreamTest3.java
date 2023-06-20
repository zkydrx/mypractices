package com.zhihei.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZKY
 * @createTime 2019/7/7 0:42
 * @description
 */

public class StreamTest3 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

		// reduce终止操作 及早求值 求和，传递2个参数返回一个参数Bifunction
		System.out.println(list.stream().map(i -> i * 2).reduce(0, (a, b) -> a + b));// map 映射
		System.out.println(list.stream().map(i -> i * 2).reduce(0, (a, b) -> {
			return a + b;
		}));// map 映射

		/**
		 * 这是对上面的方法的一个解释，用简单的java代码来完成上面的一句话
		 */
		Integer acc = 0;
		for (Integer i : list) {
			Integer integer = i * 2;
			acc = integer + acc;
		}
		System.out.println(acc);// map 映射

	}
}
