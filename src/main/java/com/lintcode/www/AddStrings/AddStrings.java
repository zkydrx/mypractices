package com.lintcode.www.AddStrings;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-09-19 Time: 14:05
 * Description: Given two non-negative integers num1 and num2 represented as
 * string, return the sum of num1 and num2.
 * <p>
 * Notice
 * <p>
 * The length of both num1 and num2 is < 5100. Both num1 and num2 contains only
 * digits 0-9. Both num1 and num2 does not contain any leading zero. You must
 * not use any built-in BigInteger library or convert the inputs to integer
 * directly.
 * <p>
 * Example Given num1 = "123", num2 = "45" return "168"
 */
public class AddStrings {
	public String addStrings(String num1, String num2) {
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int carry = 0;
		String res = "";
		while (i >= 0 || j >= 0) {
			if (i >= 0) {
				/**
				 * num1.charAt(i--)是Asic II码中的数。 想得到十进制的数就用该值减去Asic II码中的零。
				 */
				carry += num1.charAt(i--) - '0';
			}

			if (j >= 0) {
				carry += num2.charAt(j--) - '0';
			}

			res = Integer.toString(carry % 10) + res;
			carry /= 10;
		}
		return carry != 0 ? "1" + res : res;
	}

	public static void main(String[] args) {
		AddStrings addStrings = new AddStrings();
		String s = addStrings.addStrings("123", "456");
		System.out.println(s);
		System.out.println((int) ('0'));
		System.out.println('0' > 0);
	}
}
