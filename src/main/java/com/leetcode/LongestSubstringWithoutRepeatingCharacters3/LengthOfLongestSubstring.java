package com.leetcode.LongestSubstringWithoutRepeatingCharacters3;

import java.util.HashMap;

/**
 * @ProjectName: mypractices
 * @Package: com.leetcode.LongestSubstringWithoutRepeatingCharacters3
 * @ClassName: LengthOfLongestSubstring
 * @Author: hspcadmin
 * @Description: longest string no repeating.
 * 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 * @Date: 2022-06-13 17:30
 * @Version: 1.0
 */
public class LengthOfLongestSubstring
{
    public int lengthOfLongestSubstring(String s)
    {
        String temp = new String(s);
        for (int i = temp.length() - 1; i >= 1; i--)
        {
            for (int i1 = 0; i1 < s.length(); i1++)
            {

            }
        }


        return 0;
    }


    public Boolean checkTheString(String s)
    {
        Boolean temp = Boolean.FALSE;
        HashMap<String, Integer> hashMap = new HashMap();
        for (int i = 0; i < s.length(); i++)
        {
            if (hashMap.containsKey(s.charAt(i)))
            {
                hashMap.put(String.valueOf(s.charAt(i)), hashMap.get(s.charAt(i)) + 1);
            }
            hashMap.put(String.valueOf(s.charAt(i)), 1);
        }
        Integer integer = hashMap.values().stream().filter(e -> e.compareTo(1) == 1).findFirst().get();
        if (integer != null)
        {
            temp = Boolean.TRUE;
        }
        return temp;
    }


}
