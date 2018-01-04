package com.leetcode.ImplementStr28;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2018-01-04
 * Time: 22:10
 * Description:
 * 28. Implement strStr()
 * <p>
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 */
public class ImplementStr
{
    public static void main(String[] args)
    {
        ImplementStr implementStr = new ImplementStr();

        int i = implementStr.strStr("hello", "ll");
        int i1 = implementStr.strStr("aaaa", "bba");

        System.out.println(i);
        System.out.println(i1);
    }

    public int strStr(String haystack, String needle)
    {
        int i = -1;
        if (haystack.contains(needle))
        {
            i = haystack.indexOf(needle);
        }
        return i;
    }
}
