package com.zhihei.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ZKY
 * @createTime 2019/7/7 0:30
 * @description 流
 */

public class SteamTest1 {

	public static void main(String[] args) {
		// 几种创建Stream常见方法
		Stream stream = Stream.of("hello", "world", "hello world");

		String[] myArray = new String[]{"hello", "world", "hello world"};

		Stream stream1 = Stream.of(myArray);

		Stream stream2 = Arrays.stream(myArray);

		List<String> list = Arrays.asList(myArray);

		Stream stream3 = list.stream();

	}
}
