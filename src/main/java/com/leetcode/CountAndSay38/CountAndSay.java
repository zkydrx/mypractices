package com.leetcode.CountAndSay38;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2018-01-05
 * Time: 19:43
 * Description:
 * 38. Count and Say
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 */
public class CountAndSay
{
    public static void main(String[] args)
    {
        String s = new CountAndSay().countAndSay(4);

        System.out.println(s);
    }

    public String countAndSay(int n)
    {
        /**
         * if n < 0 and the result was null.
         */
        if (n <= 0)
        {
            return null;
        }

        String result = "1";
        int i = 1;

        /**
         * For the n we count it from one because the one's result was konw.
         */
        while (i < n)
        {
            /**
             * StringBuilder to append the result.
             */
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++)
            {
                if (result.charAt(j) == result.charAt(j - 1))
                {
                    count++;
                }
                else
                {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }

        /**
         * return the right the answer.
         */
        return result;
    }
}
