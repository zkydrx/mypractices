package com.leetcode.FindTheDifference389;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-07
 * Time: 21:21:36
 * Description:
 * 389. Find the Difference
 * <p>
 * Given two strings s and t which consist of only lowercase letters.
 * <p>
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 * <p>
 * Find the letter that was added in t.
 * <p>
 * Example:
 * <p>
 * Input:
 * s = "abcd"
 * t = "abcde"
 * <p>
 * Output:
 * e
 * <p>
 * Explanation:
 * 'e' is the letter that was added.
 */
public class FindTheDifference
{
    public char findTheDifference(String s, String t)
    {
        char ans = 0;

        for (int i = 0; i < s.length(); i++)
        {
            ans ^=s.charAt(i);
        }

        System.out.println(ans);

        for (int i = 0; i < t.length(); i++)
        {
            ans ^= t.charAt(i);
        }
        System.out.println(ans);
        return ans;
    }
}
