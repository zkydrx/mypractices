package com.leetcode.ReverseInteger7;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-12-26 Time: 22:29
 * Description: 7. Reverse Integer Given a 32-bit signed integer, reverse digits
 * of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123 Output: 321 Example 2:
 * <p>
 * Input: -123 Output: -321 Example 3:
 * <p>
 * Input: 120 Output: 21 Note: Assume we are dealing with an environment which
 * could only hold integers within the 32-bit signed integer range. For the
 * purpose of this problem, assume that your function returns 0 when the
 * reversed integer overflows.
 */
public class ReverseInteger {
	public static void main(String[] args) {
		ReverseInteger reverseInteger = new ReverseInteger();
		System.out.println(reverseInteger.reverse(123));
		System.out.println(reverseInteger.reverse(-123));
		System.out.println(reverseInteger.reverse(120));
		System.out.println(reverseInteger.reverse(1534236469));
	}

	public int reverse(int x) {
		long result = 0;
		if (x > 0) {
			while (x > 0) {
				int temp = x % 10;
				result = result * 10 + temp;
				x /= 10;
			}
		} else {
			int tempx = -x;
			while (tempx > 0) {
				int temp = tempx % 10;
				result = result * 10 + temp;
				tempx /= 10;
			}

			result = -result;
		}

		/**
		 * if not check it on the leetcode and this kind of issue well be ignored.
		 */
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			result = 0;
		}
		return (int) result;
	}
}
