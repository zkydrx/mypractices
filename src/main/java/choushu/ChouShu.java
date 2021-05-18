package choushu;

/**
 * Created by ZKY on 2017-06-19 10:22.
 * 写一个程序来检测一个整数是不是丑数。
 * <p>
 * 丑数的定义是，只包含质因子 2, 3, 5 的正整数。比如 6, 8 就是丑数，但是 14 不是丑数以为他包含了质因子 7。
 * 样例
 * 给出 num = 8，返回 true。
 * 给出 num = 14，返回 false。
 */

public class ChouShu
{
    public boolean isUgly(int num)
    {
        // Write your code here
        boolean b = true;
        for (int i = 1; i < num; i++)
        {
            if (num % i == 0)
            {

            }
        }
        return false;
    }

    /**
     * 判断一个数是否是质数
     *
     * @param a
     * @return
     */
    public boolean isZhiSu(int a)
    {
        boolean b = true;
        if (a == 1)
        {
            b = false;
        }
        else
        {
            for (int i = 2; i < a; i++)
            {
                if (a % i == 0)
                {
                    b = false;
                }
            }
        }

        return b;
    }
}
