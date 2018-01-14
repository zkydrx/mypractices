package com.leetcode.ReverseWordsInAStringIII557;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-01-14
 * Time: 22:03
 * Description:
 * 557. Reverse Words in a String III
 * <p>
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving
 * whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class ReverseWordsInAStringIII
{
    public static void main(String[] args)
    {
        ReverseWordsInAStringIII reverseWordsInAStringIII = new ReverseWordsInAStringIII();

        String s = reverseWordsInAStringIII.reverseWords("Let's take LeetCode contest");

        System.out.println(s + "***");
    }

    public String reverseWords(String s)
    {
        String[] split = s.split(" ");

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < split.length; i++)
        {
            String s1 = reverseString(split[i]);

            stringBuffer.append(s1 + " ");
        }
        String s1 = stringBuffer.toString();
        return s1.substring(0, s1.length() - 1);
    }

    public String reverseString(String s)
    {
        StringBuffer stringBuffer = new StringBuffer(s);
        StringBuffer reverse = stringBuffer.reverse();

        return reverse.toString();
    }
}
