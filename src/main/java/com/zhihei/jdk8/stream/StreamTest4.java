package com.zhihei.jdk8.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ZKY
 * @createTime 2019/7/7 17:32
 * @description
 */

public class StreamTest4 {
	public static void main(String[] args) {
		// Stream<String> stream = Stream.of("hello", "world", "hello world");

		// String[] strings = stream.toArray(length -> new String[length]);

		// 转换为方法引用
		// String[] strings1 = stream.toArray(String[]::new);

		// Arrays.asList(strings).forEach(System.out::println);

		// System.out.println("---------");
		// Arrays.asList(strings1).forEach(System.out::println);

		// 流转换list
		Stream<String> stream = Stream.of("hello", "world", "hello world");

		// List<String> list = stream.collect(Collectors.toList());

		// List<String> list = stream.collect(ArrayList::new,
		// (theList, item) -> theList.add(item),
		// (theList1, theList2) -> theList1.addAll(theList2));

		// List<String> list
		// =stream.collect(LinkedList::new,LinkedList::add,LinkedList::addAll);

		// List<String> list = stream.collect(Collectors.toCollection(ArrayList::new));

		// Set<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
		// System.out.println(set.getClass());
		// set.forEach(System.out::println);

		String str = stream.collect(Collectors.joining("!"));
		System.out.println(str);
	}
}
