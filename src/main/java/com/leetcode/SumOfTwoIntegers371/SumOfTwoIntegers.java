package com.leetcode.SumOfTwoIntegers371;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-01-26 Time: 22:03:36
 * Description: Calculate the sum of two integers a and b, but you are not
 * allowed to use the operator + and -.
 * <p>
 * Example: Given a = 1 and b = 2, return 3.
 * <p>
 * Credits: Special thanks to @fujiaozhu for adding this problem and creating
 * all test cases.
 */
public class SumOfTwoIntegers {
	public static void main(String[] args) {
		int sum = new SumOfTwoIntegers().getSum(1, 2);

		System.out.println(sum);
	}

	public int getSum(int a, int b) {
		int sum = Integer.sum(a, b);

		return sum;
	}
}
