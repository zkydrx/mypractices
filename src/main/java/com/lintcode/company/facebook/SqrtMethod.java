package com.lintcode.company.facebook;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-12-17 Time: 20:17
 * Description: 实现 int sqrt(int x) 函数，计算并返回 x 的平方根。
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes 样例 sqrt(3) = 1
 * <p>
 * sqrt(4) = 2
 * <p>
 * sqrt(5) = 2
 * <p>
 * sqrt(10) = 3
 * <p>
 */
public class SqrtMethod {
	public int sqrt(int x) {
		int result = 0;
		for (int i = 0; i <= x / 2; i++) {
			if (Math.pow(i, 2) <= x && Math.pow(i + 1, 2) >= x) {
				result = i;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int sqrt = new SqrtMethod().sqrt(5);

		System.out.println(sqrt);

		System.out.println(new SqrtMethod().sqrt(10));

	}
}
