package com.leetcode.AddDigits258;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2018-01-09 Time: 17:58
 * Description:
 * <p>
 * 258. Add Digits
 * <p>
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * <p>
 * For example:
 * <p>
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
 * one digit, return it.
 * <p>
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 * <p>
 * Credits: Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
public class AddDigits {
	public static int getDidits(int num) {
		int sum = 0;
		while (num > 0) {
			int tem = num % 10;
			sum += tem;
			num /= 10;
		}

		return sum;
	}

	public int addDigits(int num) {
		int tem = getDidits(num);
		while (tem >= 10) {
			tem = getDidits(tem);
		}

		return tem;
	}

	public static void main(String[] args) {
		int i = new AddDigits().addDigits(141);

		System.out.println(i);

		int i1 = addDigitsOne(141);
		System.out.println(i1);
	}


	public static int addDigitsOne(int num) {
		if (num == 0) {
			return 0;
		}
		return (num % 9 == 0) ? 9 : num % 9;
	}
}
