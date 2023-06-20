package com.zhihei.jdk8;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author ZKY
 * @createTime 2019/7/4 22:44
 * @description 字符串比较
 */

public class StringComparator {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");
		//
		// Collections.sort(names, new Comparator<String>(){
		// @Override
		// public int compare(String o1, String o2) {
		// //倒叙排序
		// return o2.compareTo(o1);
		// }
		// System.out.println(names);

		Collections.sort(names, (o1, o2) -> o2.compareTo(o1));

		// Collections.sort(names, Comparator.reverseOrder());
		System.out.println(names);

	}
}
