package com.leetcode.ExcelSheetColumnNumber171;

/**
 * Created with IntelliJ IDEA.
 * User: zky
 * Date: 2018-03-31
 * Time: 22:02:13
 * Description:
 *
 * 171. Excel Sheet Column Number
 * Related to question Excel Sheet Column Title
 * <p>
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
public class ExcelSheetColumnNumber
{
    public int titleToNumber(String s)
    {
        if(s == null || s.length()==0)
        {
            throw new IllegalArgumentException("Input is not valid!");
        }

        int result = 0;
        int i = s.length()-1;
        int t = 0;
        while (i >= 0)
        {
            char curr = s.charAt(i);
            result = result+(int)Math.pow(26,t)*(curr-'A'+1);
            t++;
            i--;
        }
        return result;
    }
}
