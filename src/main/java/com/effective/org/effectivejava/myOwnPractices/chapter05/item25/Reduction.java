// List-based generic reduction - Page 123
package com.effective.org.effectivejava.myOwnPractices.chapter05.item25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reduction {
	static <E> E reduce(List<E> list, Function<E> f, E initVal) {
		List<E> snapshot;
		synchronized (list) {
			snapshot = new ArrayList<E>(list);
		}
		E result = initVal;
		for (E e : snapshot) {
			result = f.apply(result, e);
		}
		return result;
	}

	// A few sample functions

	private static final Function<Integer> SUM = new Function<Integer>() {
		@Override
		public Integer apply(Integer i1, Integer i2) {
			return i1 + i2;
		}
	};

	private static final Function<Integer> PRODUCT = new Function<Integer>() {
		@Override
		public Integer apply(Integer i1, Integer i2) {
			return i1 * i2;
		}
	};

	private static final Function<Integer> MAX = new Function<Integer>() {
		@Override
		public Integer apply(Integer i1, Integer i2) {
			return Math.max(i1, i2);
		}
	};

	private static final Function<Integer> MIN = new Function<Integer>() {
		@Override
		public Integer apply(Integer i1, Integer i2) {
			return Math.min(i1, i2);
		}
	};

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);

		// Reduce intList using each of the above reducers
		System.out.println("从零加：" + reduce(intList, SUM, 0));
		System.out.println("阶乘：" + reduce(intList, PRODUCT, 1));
		System.out.println("最大值：" + reduce(intList, MAX, Integer.MIN_VALUE));
		System.out.println("最小值：" + reduce(intList, MIN, Integer.MAX_VALUE));
	}
}
