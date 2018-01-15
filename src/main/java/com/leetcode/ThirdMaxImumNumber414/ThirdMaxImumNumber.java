package com.leetcode.ThirdMaxImumNumber414;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-01-15
 * Time: 21:54
 * Description:
 * 414. Third Maximum Number
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return
 * the maximum number. The time complexity must be in O(n).
 * <p>
 * Example 1:
 * Input: [3, 2, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * <p>
 * Output: 2
 * <p>
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaxImumNumber
{
    public static int[] trimTheDoubleNumbers(int[] num)
    {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < num.length; i++)
        {
            set.add(num[i]);
        }

        int[] result = new int[set.size()];
        Object[] objects = set.toArray();
        for (int i = 0; i < result.length; i++)
        {
            result[i] = (int) objects[i];
        }

        return result;
    }

    public static void main(String[] args)
    {
        ThirdMaxImumNumber thirdMaxImumNumber = new ThirdMaxImumNumber();

        int[] num = {1, 2, 3, 4};
        int[] num1 = {1, 2, 3};
        int[] num2 = {1, 2};
        int[] num3 = {2, 2, 3, 1};
        int i = thirdMaxImumNumber.thirdMax(num);
        int i1 = thirdMaxImumNumber.thirdMax(num1);
        int i2 = thirdMaxImumNumber.thirdMax(num2);
        int i3 = thirdMaxImumNumber.thirdMax(num3);

        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
    }

    public int thirdMax(int[] nums)
    {
        int[] ints = trimTheDoubleNumbers(nums);
        Arrays.sort(ints);
        int temp = 0;
        if (ints.length < 3)
        {
            temp = ints[ints.length - 1];
        }
        else if (ints.length == 3)
        {
            temp = ints[0];
        }
        else
        {
            temp = ints[ints.length - 3];
        }
        return temp;
    }
}
