package com.zhihei.jdk8.example.map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-10 Time: 09:58:13
 * Description:
 */
public class MapExample {
	private static Map<String, Integer> map = new HashMap<>();

	static {
		map.put("A", 10);
		map.put("B", 20);
		map.put("C", 30);
		map.put("D", 40);
		map.put("E", 50);
		map.put("F", 60);
	}

	public static void main(String[] args) {
		/**
		 * java 8 以前遍历map是这样进行的
		 */
		for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
			System.out.println("key: " + stringIntegerEntry.getKey() + " value:" + stringIntegerEntry.getValue());
		}

		System.out.println("java8遍历map集合是这样的");
		map.entrySet().stream().forEach(a -> {
			System.out.println("key: " + a.getKey() + " value:" + a.getValue());
		});

		System.out.println("java8遍历map集合的另外一种办法：");
		map.forEach((key, value) -> {
			System.out.println("key: " + key + " value:" + value);
		});

		System.out.println("筛选出value值大于20的map元素：");
		map.forEach((k, v) -> {
			if (v > 20) {
				System.out.println("key: " + k + " value:" + v);
			}
		});
		System.out.println("筛选出value值大于20的map元素之方法二：");

		map.entrySet().stream().filter(a -> a.getValue() > 20).collect(Collectors.toList()).forEach(a -> {
			System.out.println("key: " + a.getKey() + " value:" + a.getValue());
		});

		System.out.println("筛选出value值大于20的map元素之方法三：");
		map.entrySet().stream().filter(item -> item.getValue() > 20)
				.forEach(a -> System.out.println("key: " + a.getKey() + " value:" + a.getValue()));

	}
}
