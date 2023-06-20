package com.zhihei.jdk8;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author ZKY
 * @createTime 2019/7/5 0:17
 * @description
 */

public class FunctionTest2 {
	public static void main(String[] args) {
		FunctionTest2 test2 = new FunctionTest2();
		// System.out.println(test2.compute(2, value -> value * 4, value -> value *
		// value));//输出16
		// System.out.println(test2.compute2(2, value -> value * 4, value -> value *
		// value));//输出64
		// System.out.println(test2.compute3(2, value -> value * 4, value -> value *
		// value));//输出16*4=64
		//
		// System.out.println(test2.compute4(1, 2, (value1, value2) -> value1 +
		// value2));
		// System.out.println(test2.compute4(1, 2, (value1, value2) -> value1 -
		// value2));
		// System.out.println(test2.compute4(1, 2, (value1, value2) -> value1 *
		// value2));
		// System.out.println(test2.compute4(1, 2, (value1, value2) -> value1 /
		// value2));

		System.out.println(test2.compute5(2, 4, (value1, value2) -> value1 + value2, value -> value * value));// 36

	}

	public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
		return function1.compose(function2).apply(a);
	}

	public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
		return function1.andThen(function2).apply(a);
	}

	public int compute3(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
		return function1.compose(function2).andThen(function1).apply(a);// 从左到右执行
	}

	public int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
		return biFunction.apply(a, b);
	}

	public int compute5(int a, int b, BiFunction<Integer, Integer, Integer> biFunction,
			Function<Integer, Integer> function) {
		// 应为先用Bifunction 返回一个值来作为 funtion的入参 所以没有compose
		return biFunction.andThen(function).apply(a, b);
	}
}
