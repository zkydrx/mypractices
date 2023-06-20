package com.leetcode.LongestCommonPrefix14;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-12-27 Time: 16:11
 * Description: 14. Longest Common Prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * <p>
 * example: Input : {“geeksforgeeks”, “geeks”, “geek”, “geezer”} Output : "gee"
 * <p>
 * Input : {"apple", "ape", "april"} Output : "ap"
 */
public class LongestCommonPrefix {
	/**
	 * test the method.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		String s = new LongestCommonPrefix().longestCommonPrefix(new String[]{"apple", "app", "ap"});

		System.out.println(s);
	}

	public String longestCommonPrefix(String[] strs) {
		/**
		 * sort the array by length of the strings.
		 */
		Arrays.sort(strs);
		if (strs.length == 0 || strs == null) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}

		for (int i = 0; i < strs[0].length(); i++) {
			for (int j = 0; j < strs.length - 1; j++) {
				String x = strs[j];
				String y = strs[j + 1];
				if (x.charAt(i) != y.charAt(i)) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
}
