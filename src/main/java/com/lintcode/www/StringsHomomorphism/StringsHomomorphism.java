package com.lintcode.www.StringsHomomorphism;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-18
 * Time: 19:24
 * Description:
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may hashMap to the same character but a character may hashMap to itself.
 * 样例
 * Given s = "egg", t = "add", return true.
 * <p>
 * Given s = "foo", t = "bar", return false.
 * <p>
 * Given s = "paper", t = "title", return true.
 */
public class StringsHomomorphism
{
    static int size = 256;

    //function return true if s an t are ismorphic
    public boolean isIsomorphic(String str1, String str2)
    {
        int m = str1.length();
        int n = str2.length();
        //Length of both strings must be same for one to one
        //corresponance
        if (m != n)
        {
            return false;
        }

        //To mark visited characters in str2
        Boolean[] marked = new Boolean[size];
        Arrays.fill(marked, Boolean.FALSE);

        //To store mapping of every character from str1 to
        // tha of str2. Initialize all entries of hashMap as -1
        int[] map = new int[size];
        Arrays.fill(map, -1);

        System.out.println(Arrays.toString(map));
        System.out.println(Arrays.toString(marked));
        //Process all characters one by on
        for (int i = 0; i < n; i++)
        {
            /**
             * If current character of str1 is seen first time in it.
             */
            if (map[str1.charAt(i)] == -1)
            {
                if (marked[str2.charAt(i)] == true)
                {
                    return false;
                }
                // Mark current character of str2 as visited
                marked[str2.charAt(i)] = true;

                // Store mapping of current characters
                map[str1.charAt(i)] = str2.charAt(i);
            }
            /**
             * If this is not first appearance of current character in str1,then
             * check if previous appearance ampped to smae character of str2
             */
            else if (map[str1.charAt(i)] != str2.charAt(i))
            {
                return false;
            }
        }

        return true;
    }

    //driver program
    public static void main(String[] args)
    {
        StringsHomomorphism res = new StringsHomomorphism();
        boolean isomorphic = res.isIsomorphic("aaab", "bbbc");

        System.out.println(isomorphic);

        System.out.println(res.isIsomorphic("xdad", "aaac"));
    }
}
