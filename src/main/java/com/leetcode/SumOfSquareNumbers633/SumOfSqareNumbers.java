package com.leetcode.SumOfSquareNumbers633;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-01-30
 * Time: 22:41:00
 * Description:
 */
public class SumOfSqareNumbers
{
    public static void main(String[] args)
    {
        boolean b = new SumOfSqareNumbers().judgeSquareSum(4);

        System.out.println(b);
        boolean b1 = new SumOfSqareNumbers().judgeSquareSumOne(16);

        System.out.println(b1);
    }

    /**
     * 时间复杂度n^2有点大。
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c)
    {
        boolean b = false;
        lab:
        for (int i = 0; i <= Math.sqrt(c); i++)
        {
            for (int j = 0; j <= Math.sqrt(c); j++)
            {
                int temp1 = (int) Math.pow(i, 2);
                int temp2 = (int) Math.pow(j, 2);
                if (temp1 + temp2 == c)
                {
                    b = true;
                    break lab;
                }
            }
        }

        return b;
    }

    /**
     * 时间复杂度n.
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSumOne(int c)
    {
        boolean b = false;
        for (int i = (int) Math.sqrt(c); i >= 0; i--)
        {
            if (i * i == c)
            {
                b = true;
                break;
            }
            int temp = c - i * i;
            int t = (int) Math.sqrt(temp);
            if (t * t == temp)
            {
                b = true;
                break;
            }
        }
        return b;
    }

    /**
     * 时间复杂度也是n
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSumTwo(int c)
    {
        boolean b = false;
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i <= (int) Math.sqrt(c); i++)
        {
            list.add(i * i);
            if (list.contains(c - i * i))
            {
                b = true;
                break;
            }
        }

        return b;

    }

    /**
     * 时间复杂度也是n,效率最高。
     * @param c
     * @return
     */
    public boolean judgeSquareSumThree(int c)
    {
        boolean boo = false;
        int a = 0;
        int b = (int) Math.sqrt(c);
        while (a <= b)
        {
            if (a * a + b * b == c)
            {
                boo = true;
                break;
            }
            else if (a * a + b * b > c)
            {
                b--;
            }
            else
            {
                a++;
            }
        }

        return boo;
    }


}
