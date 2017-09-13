package com.lintcode.www.SortNumbers;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-13
 * Time: 21:27
 * Description:
 * 给一组整数，按照升序排序，使用选择排序，冒泡排序，插入排序或者任何 O(n2) 的排序算法。
 * 样例
 * 对于数组 [3, 2, 1, 4, 5], 排序后为：[1, 2, 3, 4, 5]。
 */
public class Solution
{

    /**
     * 总结：冒泡排序算法比我的冒泡排序算法的变种确实效率高，比较的次数少了将近1/4.
     *
     * [0, 1, 2, 3, 4, 5, 6, 7, 8, 13, 19, 19, 23, 27, 32, 34, 64, 234, 234, 343, 345, 354, 634, 756, 756, 1111,
     * 2342, 2345, 3234]
     * 冒泡排序算法变种---排序次数：214
     * [3234, 2345, 2342, 1111, 756, 756, 634, 354, 345, 343, 234, 234, 64, 34, 32, 27, 23, 19, 19, 13, 8, 7, 6, 5,
     * 4, 3, 2, 1, 0]
     * 正宗的冒泡排序算法---排序次数：162
     *
     */
    /**
     * 冒泡排序算法的变种。把小的值放到前面。
     *
     * @param A
     */
    public void sortIntegers(int[] A)
    {
        int count = 0;
        for (int i = 0; i < A.length - 1; i++)
        {
            for (int j = i; j < A.length; j++)
            {
                if (A[i] > A[j])
                {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(A));
        System.out.println("冒泡排序算法变种---排序次数：" + count);
    }


    /**
     * 正宗的冒泡排序法。
     *
     * @param A
     */
    public void sortNumber(int[] A)
    {
        int count = 0;
        for (int i = 0; i < A.length - 1; i++)
        {
            for (int j = 0; j < A.length - 1 - i; j++)
            {
                if (A[j] < A[j + 1])
                {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                    count++;
                }
            }
        }

        System.out.println(Arrays.toString(A));
        System.out.println("正宗的冒泡排序算法---排序次数：" + count);
    }


    public static void main(String[] args)
    {
        Solution solution = new Solution();
        solution.sortIntegers(new int[]{2, 8, 3, 19, 234, 354, 32, 64, 634, 2345, 1111, 2342, 34, 343, 756, 756, 234,
                3234, 23, 13, 345, 27, 0, 19, 7, 6, 4, 5, 1});
        solution.sortNumber(new int[]{2, 8, 3, 19, 234, 354, 32, 64, 634, 2345, 1111, 2342, 34, 343, 756, 756, 234,
                3234, 23, 13, 345, 27, 0, 19, 7, 6, 4, 5, 1});
    }
}
