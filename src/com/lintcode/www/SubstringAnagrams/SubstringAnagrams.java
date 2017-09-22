package com.lintcode.www.SubstringAnagrams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-21
 * Time: 15:39
 * Description:
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than
 * 40,000.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example
 * Given s = "cbaebabacd" p = "abc"
 * <p>
 * return [0, 6]
 * <p>
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */
public class SubstringAnagrams
{
    public static void main(String[] args)
    {
        SubstringAnagrams f = new SubstringAnagrams();
        List<Integer> anagrams = f.findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);
    }

    /**
     * 方法一：
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p)
    {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
        {
            return list;
        }
        int[] hash = new int[256];
        for (char c : p.toCharArray())
        {
            hash[c]++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length())
        {
            if (hash[s.charAt(right++)]-- >= 1)
            {
                count--;
            }
            if (count == 0)
            {
                list.add(left);
            }
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
            {
                count++;
            }
        }
        return list;
    }

    /**
     * 方法二：
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagramsOther(String s, String p)
    {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return list;

        int[] hash = new int[256];

        for (char c : p.toCharArray())
        {
            hash[c]++;
        }

        int left = 0, right = 0, count = p.length();

        while (right < s.length())
        {

            if (hash[s.charAt(right)] >= 1)
            {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            if (count == 0)
            {
                list.add(left);
            }

            if (right - left == p.length())
            {

                if (hash[s.charAt(left)] >= 0)
                {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;

            }
        }
        return list;
    }

}
