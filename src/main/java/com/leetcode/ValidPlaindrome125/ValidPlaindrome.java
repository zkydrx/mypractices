package com.leetcode.ValidPlaindrome125;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-22
 * Time: 10:36:05
 * Description:
 * 125. Valid Palindrome
 * <p>
 * <p>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p>
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPlaindrome
{
    public boolean isPalindrome(String s)
    {
        if(s.length() ==0||s ==null)
        {
            return false;
        }

        s.replaceAll("[^a-zA-Z0-9]","");
        System.out.println(s);

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
            {
                return false;
            }
        }

        return true;
    }
}
