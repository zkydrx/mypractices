package com.lintcode.www.FirstPositionUniqueCharacter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-18
 * Time: 20:41
 * Description:
 * Given a string, find the first non-repeating character
 * in it and return it's index. If it doesn't exist, return -1.
 * Example
 Given s = "lintcode", return 0.

 Given s = "lovelintcode", return 2.
 */
public class FirstPositionUniqueCharacter
{
    public int firstUniqChar(String s)
    {
        Map<Character, Integer> table = new LinkedHashMap<>();
        for (char c : s.toCharArray())
        {
            if (table.get(c) == null)
            {
                table.put(c, 1);
            }
            else
            {
                table.put(c, table.get(c) + 1);
            }
        }

        Set<Character> set = table.keySet();
        for (char c : set)
        {
            if (table.get(c) == 1)
            {
                return s.indexOf(c);
            }
        }

        return -1;

    }

    public static void main(String[] args)
    {
        FirstPositionUniqueCharacter f = new FirstPositionUniqueCharacter();
        System.out.println(f.firstUniqChar("lintcode"));
        System.out.println(f.firstUniqChar("lovelintcode"));
    }
}
