package choushu;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
    public static boolean isUgly(int num)
    {
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(2, true);
        map.put(3, true);
        map.put(5, true);
        boolean b = false;


        for (; ; )
        {
            if (isZhiSu(num))
            {
                b = isB(num, map, b);
                break;
            }
            if (num % 2 == 0)
            {
                if (isZhiSu(num = num / 2))
                {
                    b = isB(num, map, b);
                    break;
                }
            }
            if (num % 3 == 0)
            {
                num = num / 3;
                if (isZhiSu(num))
                {
                    b = isB(num, map, b);
                    break;
                }
            }
            if (num % 5 == 0)
            {
                num = num / 5;
                if (isZhiSu(num))
                {
                    b = isB(num, map, b);
                    break;
                }
            }
        }
        return b;
    }

    private static boolean isB(int num, Map<Integer, Boolean> map, boolean b)
    {
        if (map.containsKey(num))
        {
            b = true;
        }
        return b;
    }

    /**
     * 判断一个数是否是质数
     *
     * @param a
     * @return
     */
    public static boolean isZhiSu(int a)
    {
        boolean b = true;
        if (a == 1)
        {
            b = false;
        }
        else
        {
            /**
             * 除了1和他本身不能被任何数字整除
             */
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

    public static void main(String[] args)
    {
        Random random = new Random();
        while (true)
        {
            int i = random.nextInt(1000);
            if (i > 0 && isUgly(i))
            {
                System.out.println(i + "：是一个丑数");

            }
            else if (i == 99999)
            {
                break;
            }
            else
            {
                continue;
            }

        }
    }
}
