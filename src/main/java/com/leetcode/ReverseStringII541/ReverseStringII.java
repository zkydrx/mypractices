package com.leetcode.ReverseStringII541;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-02-03 Time: 21:36:31
 * Description: 541. Reverse String II
 * <p>
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original. Example: Input: s = "abcdefg", k =
 * 2 Output: "bacdfeg" Restrictions: The string consists of lower English
 * letters only. Length of the given string and k will in the range [1, 10000]
 */
public class ReverseStringII {
	public String reverseStr(String s, int k) {
		char[] ar = s.toCharArray();
		int n = ar.length;
		int i = 0;
		while (i < n) {
			int j = Math.min(i + k - 1, n - 1);
			swap(ar, i, j);
			i += 2 * k;
		}
		return String.valueOf(ar);
	}

	private void swap(char[] ar, int l, int r) {
		while (l < r) {
			char temp = ar[l];
			ar[l++] = ar[r];
			ar[r--] = temp;
		}
	}
}
