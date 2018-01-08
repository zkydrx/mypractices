package com.leetcode.ReverseString344;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2018-01-08
 * Time: 20:53
 * Description:
 * 344. Reverse String
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example:
 * Given s = "hello", return "olleh".
 */
public class ReverseString
{
    public static void main(String[] args)
    {
        String hello = new ReverseString().reverseString("hello");

        System.out.println(hello);
    }

    public String reverseString(String s)
    {
        StringBuffer stringBuffer = new StringBuffer(s);
        StringBuffer reverse = stringBuffer.reverse();
        return reverse.toString();
    }
}
