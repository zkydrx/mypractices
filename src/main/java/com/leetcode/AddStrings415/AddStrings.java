package com.leetcode.AddStrings415;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-02-10 Time: 00:25:17
 * Description: 415. Add Strings
 * <p>
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100. Both num1 and num2 contains only
 * digits 0-9. Both num1 and num2 does not contain any leading zero. You must
 * not use any built-in BigInteger library or convert the inputs to integer
 * directly.
 */
public class AddStrings {
	public String addStrings(String num1, String num2) {
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int min = Math.min(i, j);
		int max = Math.max(i, j);
		String bigString = null;
		String smallString = null;
		if (i > j) {
			bigString = num1;
			smallString = num2;
		} else {
			bigString = num2;
			smallString = num1;
		}
		Integer temp = 0;

		ArrayList<String> arrayList = new ArrayList<>();
		while (true) {
			int t1 = Integer.parseInt(Character.toString(num1.charAt(i)));
			int t2 = Integer.parseInt(Character.toString(num2.charAt(j)));
			Integer t3 = t1 + t2 + temp;
			if (t3 > 9) {
				temp = 1;
				t3 = temp - 10;
			} else {
				temp = 0;
			}
			arrayList.add(t3.toString());
			i--;
			j--;
			min--;
			if (min < 0) {
				arrayList.add(temp.toString());
				break;
			}
		}

		Collections.reverse(arrayList);
		StringBuffer stringBuffer = new StringBuffer();

		for (int i1 = 0; i1 < arrayList.size(); i1++) {
			stringBuffer.append(arrayList.get(i1));
		}

		String substring = bigString.substring(0, max - min);
		return substring + stringBuffer.toString();
	}

	public String addStringsOne(String num1, String num2) {
		StringBuilder buf = new StringBuilder();
		for (int i1 = num1.length() - 1, i2 = num2.length() - 1, carry = 0; i1 >= 0 || i2 >= 0
				|| carry != 0; i1--, i2--) {
			int digit1 = i1 < 0 ? 0 : Integer.parseInt(Character.toString(num1.charAt(i1)));
			int digit2 = i2 < 0 ? 0 : Integer.parseInt(Character.toString(num2.charAt(i2)));

			int digit = digit1 + digit2 + carry;
			if (digit > 9) {
				carry = 1;
				digit -= 10;
			} else {
				carry = 0;
			}

			buf.append(digit);
		}
		return buf.reverse().toString();
	}
}
