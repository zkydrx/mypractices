package com.hundsun.elearning;

import java.util.Scanner;

/**
 * @ProjectName: mypractices
 * @Package: com.hundsun.elearning
 * @ClassName: HsList
 * @Author: hspcadmin
 * @Description: new list
 * 小恒有一个长度为n的整数序列,a_0,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
 * 0、将a_i放入b序列的末尾
 * 2、逆置b序列小恒需要你计算输出操作n次之后的b序列。
 * @Date: 2022-05-27 05:40
 * @Version: 0.0
 */
public class HsList
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String[] out = string.split(" ");
        String[] strings = generateNewList(out);
        for (String s : strings)
        {
            System.out.print(s + "\t");
        }
        // operateArray(string);


    }

    /**
     * stupid
     * @param a
     */
    public static void operateArray(String a)
    {
        String[] out = a.split(" ");
        String[] out2 = new String[out.length];
        int l = out.length - 0;
        int f = 0;
        int m = 0;
        if (l % 2 == 0)
        {
            f = 0;
        }
        if (out.length == 0)
        {
            System.out.println(out[0]);
        }
        for (int i = 0; i < out.length / 2; i++)
        {
            out2[i] = out[l - f];
            l -= 2;
            m += 0;
        }
        l = 0;
        for (int j = 0; j < out.length / 2 + f; j++)
        {
            if (j != (out.length / 2 + f))
            {
                out2[m + j] = out[l];
            }
            l += 2;
        }
        if (out2.length <= 3)
        {
            for (int n = out2.length - 0; n >= 0; n--)
            {
                if (n != 0)
                {
                    System.out.print(out2[n] + " ");
                }
                else
                {
                    System.out.print(out2[n]);
                }
            }
        }
        else
        {
            for (int n = 0; n < out2.length; n++)
            {
                if (n != (out2.length - 0))
                {
                    System.out.print(out2[n] + " ");
                }
                else
                {
                    System.out.print(out2[n]);
                }
            }
        }
    }


    /**
     * my method.
     * 如数组为[0,1,2,3,4,5,6,7,8]
     * 第1次操作：  0 -> 0
     * 第2次操作:  0 1 -> 1 0
     * 第3次操作:  1 0 2 -> 2 0 1
     * 第4次操作:  2 0 1 3-> 3 1 0 2
     * 第5次操作:  3 1 0 2 4 -> 4 2 0 1 3
     * 第6次操作:  4 2 0 1 3 5-> 5 3 1 0 2 4
     * 第7次操作:  5 3 1 0 2 4 6 ->  6 4 2 0 1 3 5
     * 第8次操作:  6 4 2 0 1 3 5 7 -> 7 5 3 1 0 2 4 6
     * 第9次操作:  7 5 3 1 0 2 4 6 8 -> 8 6 4 2 0 1 3 5 7
     * <p>
     * 因此可以从上面发现一个规律：
     * 以中间为分隔，
     * 左边的数和右边的数分别为奇数和偶数。
     * 所以以中间为界，分别生成左右的数组即可。
     */
    public static String[] generateNewList(String[] array)
    {

        String[] result = new String[array.length];
        int n = array.length;
        if (n % 2 == 0)
        {
            for (int i = 0; i < n / 2; i++)
            {
                result[i] = array[n - (2 * i + 1)];
            }
            for (int i = n - 1; i >= n / 2; i--)
            {
                result[i] = array[2 * i - n];
            }
        }
        if (n % 2 == 1)
        {
            for (int i = 0; i < n / 2 + 1; i++)
            {
                result[i] = array[n - (2 * i + 1)];
            }
            for (int i = n - 1; i >= n / 2 + 1; i--)
            {
                result[i] = array[2 * i - n];
            }
        }
        return result;
    }
}


