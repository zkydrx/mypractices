package com.leetcode.SumOfSquareNumbers633;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-01-30
 * Time: 22:41:00
 * Description:
 */
public class SumOfSqareNumbers
{
    public boolean judgeSquareSum(int c)
    {
        boolean b = false;
        lab:
        for (int i = 0; i <= Math.sqrt(c); i++)
        {
            for (int j = 0; j <= Math.sqrt(c); j++)
            {
                int temp1 = (int)Math.pow(i, 2);
                int temp2 = (int)Math.pow(j, 2);
                if (temp1 + temp2 == c)
                {
                    b = true;
                    break lab;
                }
            }
        }

        return b;
    }

    public static void main(String[] args)
    {
        boolean b = new SumOfSqareNumbers().judgeSquareSum(4);

        System.out.println(b);
    }
}
