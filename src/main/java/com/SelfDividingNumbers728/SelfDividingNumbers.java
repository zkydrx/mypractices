package com.SelfDividingNumbers728;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2018-01-11
 * Time: 22:39
 * Description:
 * <p>
 * 728. Self Dividing Numbers
 * <p>
 * A self-dividing number is a number that is divisible by every digit it contains.
 * <p>
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * <p>
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * <p>
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds
 * if possible.
 * <p>
 * Example 1:
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * Note:
 * <p>
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 */
public class SelfDividingNumbers
{
    public static boolean isDividingNumbers(int num)
    {
        int temp = num;
        boolean b = true;
        while (num > 0)
        {
            int digit = num % 10;
            if (digit != 0)
            {
                if (temp % digit != 0)
                {
                    b = false;
                    break;
                }
            }
            else
            {
                b = false;
            }


            num /= 10;
        }
        return b;
    }

    public static void main(String[] args)
    {
        List<Integer> list = new SelfDividingNumbers().selfDividingNumbers(1, 22);

        System.out.println(Arrays.toString(list.toArray()));
    }

    public List<Integer> selfDividingNumbers(int left, int right)
    {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i < right + 1; i++)
        {
            if (isDividingNumbers(i))
            {
                list.add(i);
            }
        }

        return list;
    }
}
