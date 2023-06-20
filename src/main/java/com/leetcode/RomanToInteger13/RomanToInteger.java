package com.leetcode.RomanToInteger13;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-12-27 Time: 13:36
 * Description: 13. Roman to Integer Given a roman numeral, convert it to an
 * integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {
	public static void main(String[] args) {
		int i = new RomanToInteger().romanToInt("MD");

		System.out.println(i);
	}

	public int romanToInt(String s) {
		char symbols[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
		int values[] = {1000, 500, 100, 50, 10, 5, 1};

		if (s.length() == 0) {
			return 0;
		}

		s = s.toUpperCase();
		for (int i = 0; i < symbols.length; i++) {
			int index = s.indexOf(symbols[i]);
			if (index != -1) {
				return values[i] - romanToInt(s.substring(0, index)) + romanToInt(s.substring(index + 1));
			}
		}
		return 0;
	}
}
