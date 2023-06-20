package com.zhihei.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZKY
 * @createTime 2019/7/8 0:35
 * @description
 */

public class StreamTest7 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("hello", "world", "helloworld");

		// list.stream().map(i -> i.substring(0, 1).toUpperCase() +
		// i.substring(1)).forEach(System.out::println);

		list.stream().map(item -> {
			String result = item.substring(0, 1).toLowerCase() + item.substring(1);
			System.out.println("test");// 没有forEach时 这里不输出
			return result;
		}).forEach(System.out::println);

		// 没有终止操作时（惰性求值） 中间操是不会被执行

	}
}
