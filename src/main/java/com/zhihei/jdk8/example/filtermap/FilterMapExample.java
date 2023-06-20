package com.zhihei.jdk8.example.filtermap;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-10 Time: 10:57:29
 * Description:
 */
public class FilterMapExample {
	private static Map<Integer, String> map = new HashMap<>();

	static {
		map.put(1, "google.com");
		map.put(2, "alibaba.com");
		map.put(3, "fackbook.com");
		map.put(4, "apple.com");
		map.put(5, "amazon.com");
		map.put(6, "twitter.com");
		map.put(7, "google.com");
	}

	public static void main(String[] args) {
		System.out.println("java8以前过滤数据的办法是：");
		System.out.println("找出google.com的元素");
		for (Map.Entry<Integer, String> integerStringEntry : map.entrySet()) {
			if ("google.com".equals(integerStringEntry.getValue())) {
				System.out.println(integerStringEntry);
			}
		}

		System.out.println("java8中的过滤数据的办法是：");
		map.entrySet().stream().filter(item -> "google.com".equals(item.getValue())).forEach(System.out::println);
		System.out.println("获取指定的value的办法：");
		map.entrySet().stream().filter(item -> "google.com".equals(item.getValue()))
				.forEach(item -> System.out.println(item.getValue()));
		System.out.println("将获取到的value串联起来:");
		String collect = map.entrySet().stream().filter(item -> "google.com".equals(item.getValue()))
				.map(item -> item.getValue()).collect(Collectors.joining());
		System.out.println(collect);

		System.out.println("获取指定key的元素");
		map.entrySet().stream().filter(item -> 2 == item.getKey())
				.collect(Collectors.toMap(k -> k.getKey(), k -> k.getValue()))
				.forEach((k, v) -> System.out.println(k + "::" + v));
	}
}
