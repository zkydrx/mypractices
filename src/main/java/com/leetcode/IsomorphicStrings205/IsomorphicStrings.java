package com.leetcode.IsomorphicStrings205;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-04-21
 * Time: 23:39:51
 * Description:
 * <p>
 * 205. Isomorphic Strings
 * <p>
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * <p>
 * For example,
 * Given "egg", "add", return true.
 * <p>
 * Given "foo", "bar", return false.
 * <p>
 * Given "paper", "title", return true.
 * <p>
 * Note:
 * You may assume both s and t have the same length.
 */
public class IsomorphicStrings
{
    public boolean isIsomorphic(String s, String t)
    {
        if (s == null || t == null)
        {
            return false;
        }

        if (s.length() != t.length())
        {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<Character, Character>();

        for (int i = 0; i < s.length(); i++)
        {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1))
            {
                if (map.get(c1) != c2)
                {
                    return false;
                }

            }
            else
            {
                if (map.containsValue(c2))
                {
                    return false;
                }
                map.put(c1, c2);
            }
        }
        return true;


        //        if (s == null || t == null)
        //        {
        //            return false;
        //        }
        //
        //        if (s.length() != t.length())
        //        {
        //            return false;
        //        }
        //
        //        HashMap<Character, Character> map = new HashMap<Character, Character>();
        //
        //
        //        for (int i = 0; i < s.length(); i++)
        //        {
        //            char c1 = s.charAt(i);
        //            char c2 = t.charAt(i);
        //
        //            if (map.containsKey(c1))
        //            {
        //                if (map.get(c1) != c2)// if not consistant with previous ones
        //                {
        //                    return false;
        //                }
        //            }
        //            else
        //            {
        //                if (map.containsValue(c2)) //if c2 is already being mapped. Time complexity O(n) here
        //                {
        //                    return false;
        //                }
        //                map.put(c1, c2);
        //            }
        //        }
        //
        //        return true;
    }
}
