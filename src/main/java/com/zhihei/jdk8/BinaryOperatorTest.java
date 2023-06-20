package com.zhihei.jdk8;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @author ZKY
 * @createTime 2019/7/6 10:13
 * @description
 */

public class BinaryOperatorTest {
	public static void main(String[] args) {

		BinaryOperatorTest binaryOperatorTest = new BinaryOperatorTest();
		Integer num1 = 5;
		Integer num2 = 6;
		System.out.println(binaryOperatorTest.operation(num1, num2, (a, b) -> a + b));
		System.out.println(binaryOperatorTest.operation(num1, num2, (a, b) -> a - b));

		System.out.println("-----------------------");
		System.out.println(binaryOperatorTest.operationCompare(num1, num2, (a, b) -> a.hashCode() - b.hashCode()));

		System.out.println("-----------------------");
		String str1 = "helloword";
		String str2 = "world";
		System.out.println(binaryOperatorTest.operationCompare(str1, str2,
				(a, b) -> a.toString().charAt(0) - a.toString().charAt(0)));

	}

	public Integer operation(Integer a, Integer b, BinaryOperator<Integer> binaryOperator) {
		return binaryOperator.apply(a, b);
	}

	/**
	 * 比较器
	 *
	 * @param a
	 * @param b
	 * @param comparator
	 * @return
	 */
	public Object operationCompare(Object a, Object b, Comparator<Object> comparator) {
		return BinaryOperator.minBy(comparator).apply(a, b);
	}
}
