package com.zhihei.jdk8.stream;

import java.util.stream.IntStream;

/**
 * @author ZKY
 * @createTime 2019/7/7 0:34
 * @description
 */

public class StreamTest2 {

	public static void main(String[] args) {
		IntStream.of(new int[]{5, 6, 7}).forEach(System.out::println);
		// IntStream.of(new int[]{5, 6, 7}).forEachOrdered(System.out::println);//
		// //主要的区别在并行流的处理上 输出的顺序不一定（效率更高）
		System.out.println("--------------");

		IntStream.range(3, 8).forEach(System.out::println);// [3,8)
		System.out.println("--------------");
		IntStream.rangeClosed(3, 8).forEach(System.out::println);// [3,8]
	}
}
