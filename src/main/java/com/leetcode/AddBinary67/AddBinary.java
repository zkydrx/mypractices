package com.leetcode.AddBinary67;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-02
 * Time: 10:22:06
 * Description:
 * <p>
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary
{
    public String addBinary(String a, String b)
    {
        int i = binToInteger(a) + binToInteger(b);

        String s = integerToBinString(i);
        return s;
    }

    /**
     * bin string to integer.
     *
     * @param num
     * @return
     */
    public int binToInteger(String num)
    {
        int res = 0;
        int length = num.length();


        if (!num.equals("0"))
        {
            for (int i = length - 1; i >= 0; i--)
            {
                res += Math.pow(2, length - 1 - i);
            }
        }

        return res;
    }


    public String integerToBinString(int num)
    {
        if(num != 0)
        {
            StringBuilder bin = new StringBuilder();
            StringBuilder reverseString = new StringBuilder();
            while (num >= 1)
            {
                int temp = num % 2;
                bin.append(temp);
                num /= 2;
            }

            String s = bin.toString();

            for (int i = s.length() - 1; i >= 0; i--)
            {
                reverseString.append(s.charAt(i));
            }

            return reverseString.toString();
        }
        else
        {
            return "0";
        }

    }
}
