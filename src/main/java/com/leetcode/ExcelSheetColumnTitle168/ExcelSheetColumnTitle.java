package com.leetcode.ExcelSheetColumnTitle168;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-29 Time: 09:40:47
 * Description: 168. Excel Sheet Column Title Given a positive integer, return
 * its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB Credits: Special thanks
 * to @ifanchu for adding this problem and creating all test cases.
 */
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		StringBuilder stringBuilder = new StringBuilder();
		if (n < 0) {
			throw new IllegalArgumentException("Input is not valid!");

		}
		while (n > 0) {
			n--;
			char ch = (char) (n % 26 + 'A');
			n /= 26;
			stringBuilder.append(ch);
		}

		stringBuilder.reverse();
		return stringBuilder.toString();
	}

}
