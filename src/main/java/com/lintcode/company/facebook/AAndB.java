package com.lintcode.company.facebook;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-12-15 Time: 17:20
 * Description: 1. A + B 问题 描述 笔记 数据 评测 给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。
 * <p>
 * 注意事项 你不需要从输入流读入数据，只需要根据aplusb的两个参数a和b，计算他们的和并返回就行。
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes 说明 a和b都是 32位 整数么？
 * <p>
 * 是的 我可以使用位运算符么？
 * <p>
 * 当然可以 样例 如果 a=1 并且 b=2，返回3
 */
public class AAndB {
	public static void main(String[] args) {
		int aPlusB = new AAndB().getAPlusB(1, 3);
	}

	/**
	 * 返回两个数的和。
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public int getAPlusB(int a, int b) {
		int sum = a;
		int carry = b;
		while (carry != 0) {
			int temps = sum;
			sum = temps ^ carry;

			carry = (temps & carry) << 1;
		}
		System.out.println(sum);
		return sum;
	}
}
