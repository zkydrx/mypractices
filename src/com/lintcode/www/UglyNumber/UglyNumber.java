package com.lintcode.www.UglyNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-12
 * Time: 15:56
 * Description:
 * 写一个程序来检测一个整数是不是丑数。
 * <p>
 * 丑数的定义是，只包含质因子 2, 3, 5 的正整数。比如 6, 8 就是丑数，但是 14 不是丑数以为他包含了质因子 7。
 * 样例
 * 给出 num = 8，返回 true。
 * 给出 num = 14，返回 false。
 */
public class UglyNumber
{
    /**
     * 判断是否是丑数
     *
     * @param number
     * @return
     */
    public boolean isUgly(int number)
    {
        /**
         * 定义三个变量用于分别存放以2，3,5为底的指数结果。
         */
        double num2;
        double num3;
        double num5;

        boolean b = false;
        /**
         * 用三层循环来求幂指数，将三个底的指数结果进行乘积运算，
         * 并判断是否满足与给定的值相等，如果相等则记录布尔值为真，并且
         * 退出三层循环。
         * 返回结果。否者直至循环结束不对初始的布尔值进行值得修改。
         * 最终返回布尔值。就是我们判断的结果。
         */
        lab:
        for(int i = 0; i<= number ; i++)
        {
            num2 = Math.pow(2,i);
            for(int j = 0; j<= number ; j++)
            {
                num3 = Math.pow(3,j);
                for(int k = 0;k <=number ; k++)
                {
                    num5 = Math.pow(5,k);
                    if(num2*num3*num5 == number)
                    {
                        b = true;
                        break lab;
                    }
                }
            }
        }

        return b;
    }


    /**
     * 获取小于或等于输入值的所有质数。(求质数的副产品，获取小于某个数的质数列表。求丑数时并没有使用。)
     *
     * @param number
     * @return
     */
    public static List<Integer> getPrimeList(int number)
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= number; i++)
        {
            if (isPrime(i))
            {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * 判断是否是质数。(丑数的副产品顺便复习下质数的求法。算法中并没有使用。)
     *
     * @param number
     * @return
     */
    public static boolean isPrime(int number)
    {
        boolean b = true;
        if (number == 2)
        {
            b = true;
        }
        else
        {
            for (int i = 2; i <= Math.sqrt(number); i++)
            {
                if (number % i == 0)
                {
                    b = false;
                    break;
                }
            }
        }
        return b;
    }

    public static void main(String[] args)
    {
        UglyNumber number = new UglyNumber();
        System.out.println(number.isUgly(14));
        System.out.println(number.isUgly(8));
        System.out.println(number.isUgly(9));
        System.out.println(number.isUgly(10));
        System.out.println(number.isUgly(11));
        System.out.println(number.isUgly(21));
        System.out.println(number.isUgly(13));
        System.out.println(number.isUgly(12));
    }

}
