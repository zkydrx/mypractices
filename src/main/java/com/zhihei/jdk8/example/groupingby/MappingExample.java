package com.zhihei.jdk8.example.groupingby;

import com.zhihei.jdk8.example.moudle.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-10 Time: 10:14:40
 * Description:
 */
public class MappingExample {
	private static List<Person> list = new ArrayList<>();

	static {
		list.add(Person.builder().id("1").name("Tom").address("HangZhou").build());
		list.add(Person.builder().id("2").name("Apple").address("BeiJing").build());
		list.add(Person.builder().id("3").name("Jarry").address("ChongQing").build());
		list.add(Person.builder().id("4").name("Linux").address("HangZhou").build());
		list.add(Person.builder().id("5").name("Microsoft").address("ShenZhen").build());
		list.add(Person.builder().id("6").name("Apple").address("HangZhou").build());
		list.add(Person.builder().id("7").name("Microsoft").address("BeiJing").build());
		list.add(Person.builder().id("7").name("Linux").address("BeiJing").build());
	}

	public static void main(String[] args) {
		/**
		 * 以地址进行划分人员
		 */
		System.out.println("以地址进行分组操作:");
		list.stream().collect(Collectors.groupingBy(c -> c.getAddress()))
				.forEach((a, b) -> System.out.println(a + "|||" + b));

		System.out.println("以名字进行分组操作:");
		list.stream().collect(Collectors.groupingBy(item -> item.getName())).entrySet().stream()
				.collect(Collectors.toList()).forEach(a -> System.out.println(a));
		System.out.println("以名字进行分组操作(方法二）:");
		list.stream().collect(Collectors.groupingBy(item -> item.getName()))
				.forEach((k, v) -> System.out.println(k + ":::::" + v));

		System.out.println("以id进行分组操作:");
		list.stream().collect(Collectors.groupingBy(item -> item.getId()))
				.forEach((k, v) -> System.out.println(k + ":::" + v));

		System.out.println("以数据进行分组:");
		list.stream().collect(Collectors.groupingBy(item -> item.getData()))
				.forEach((k, v) -> System.out.println(k + ":::" + v));
	}
}
