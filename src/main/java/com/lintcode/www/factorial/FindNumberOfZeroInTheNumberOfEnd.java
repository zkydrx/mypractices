package com.lintcode.www.factorial;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-12-24
 * Time: 01:15
 * Description:
 * 设计一个算法，计算出n阶乘中尾部零的个数
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 * 11! = 39916800，因此应该返回 2
 */
public class FindNumberOfZeroInTheNumberOfEnd
{
    public static void main(String[] args)
    {
        long l = new FindNumberOfZeroInTheNumberOfEnd().trailingZeros(11);
        long l1 = new FindNumberOfZeroInTheNumberOfEnd().trailingZeros(5);
        long l2 = new FindNumberOfZeroInTheNumberOfEnd().trailingZeros(6);

        System.out.println(l);
        System.out.println(l1);
        System.out.println(l2);
    }
    /**
     * 获取一个阶乘末尾零的个数。
     * @param n
     * @return
     */
    public long trailingZeros(long n)
    {
        long factorial = getFactorial(n);

        int numberOfZeroEnd = getNumberOfZeroEnd(factorial);
        return numberOfZeroEnd;
    }

    /**
     * 获取一个数的阶乘。
     *
     * @param n
     * @return
     */
    public long getFactorial(long n)
    {
        long result = 1L;
        for (long i = 1; i <= n; i++)
        {
            result *= i;
        }
        return result;
    }

    /**
     * 获取一个数字末尾零的个数。
     *
     * @param number
     * @return
     */
    public int getNumberOfZeroEnd(long number)
    {
        int sum = 0;
        while (number % 10 == 0)
        {
            sum++;
            number /= 10;
        }
        return sum;
    }
}
