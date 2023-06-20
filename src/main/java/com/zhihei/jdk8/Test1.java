package com.zhihei.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author ZKY
 * @createTime 2019/7/3 1:04
 * @description
 */

public class Test1 {

	public static void main(String[] args) {
		// 遍历list
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

		// jdk4
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("jkd4-----------");

		// jdk5 增强for循环
		for (Integer integer : list) {
			System.out.println(integer);
		}
		System.out.println("jdk5-----------");

		// jdk8
		list.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer integer) {
				System.out.println(integer);
			}
		});

		System.out.println("jdk8-----------");

		// jdk8 lambda表达式 lambda expressions
		list.forEach(integer -> {
			System.out.println(2 * integer);
		});

		// 声明类型 则用括号 lambda expressions
		list.forEach((Integer integer) -> {
			System.out.println(3 * integer);
		});

		System.out.println("jdk8lambda表达式-----------");

		// 方法引用 method references
		list.forEach(System.out::println);
	}
}
