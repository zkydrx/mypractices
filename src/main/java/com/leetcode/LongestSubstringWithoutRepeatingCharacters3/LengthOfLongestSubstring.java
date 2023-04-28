package com.leetcode.LongestSubstringWithoutRepeatingCharacters3;

import java.util.HashMap;

/**
 * @ProjectName: mypractices
 * @Package: com.leetcode.LongestSubstringWithoutRepeatingCharacters3
 * @ClassName: LengthOfLongestSubstring
 * @Author: hspcadmin
 * @Description: longest string no repeating. 3. Longest Substring Without
 *               Repeating Characters Given a string s, find the length of the
 *               longest substring without repeating characters.
 *               <p>
 *               <p>
 *               <p>
 *               Example 1:
 *               <p>
 *               Input: s = "abcabcbb" Output: 3 Explanation: The answer is
 *               "abc", with the length of 3. Example 2:
 *               <p>
 *               Input: s = "bbbbb" Output: 1 Explanation: The answer is "b",
 *               with the length of 1. Example 3:
 *               <p>
 *               Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke",
 *               with the length of 3. Notice that the answer must be a
 *               substring, "pwke" is a subsequence and not a substring.
 *               <p>
 *               <p>
 *               Constraints:
 *               <p>
 *               0 <= s.length <= 5 * 104 s consists of English letters, digits,
 *               symbols and spaces.
 * @Date: 2022-06-13 17:30
 * @Version: 1.0
 */
public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		String temp = new String(s);
		for (int i = temp.length() - 1; i >= 1; i--) {
			for (int i1 = 0; i1 < s.length(); i1++) {

			}
		}
		return 0;
	}

	public Boolean checkTheString(String s) {
		Boolean temp = Boolean.FALSE;
		HashMap<String, Integer> hashMap = new HashMap();
		for (int i = 0; i < s.length(); i++) {
			if (hashMap.containsKey(s.charAt(i))) {
				hashMap.put(String.valueOf(s.charAt(i)), hashMap.get(s.charAt(i)) + 1);
			}
			hashMap.put(String.valueOf(s.charAt(i)), 1);
		}
		Integer integer = hashMap.values().stream().filter(e -> e.compareTo(1) == 1).findFirst().get();
		if (integer != null) {
			temp = Boolean.TRUE;
		}
		return temp;
	}

	/**
	 *
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstri(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int[] freq = new int[256]; // 构造一个字符集，用来记录字符出现的频率
		int l = 0, r = -1; // 使用双指针表示窗口区间 [l, r]
		int maxLength = 0; // 记录最长子字符串的长度
		while (l < s.length()) {
			if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
				freq[s.charAt(++r)]++; // 将右指针向右移动，并更新字符频率
			} else {
				freq[s.charAt(l++)]--; // 将左指针向右移动，并更新字符频率
			}
			maxLength = Math.max(maxLength, r - l + 1); // 更新最长子字符串长度
		}
		return maxLength;
	}

}
