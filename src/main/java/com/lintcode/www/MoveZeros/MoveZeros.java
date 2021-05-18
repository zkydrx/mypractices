package com.lintcode.www.MoveZeros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-06
 * Time: 23:23
 * Description:
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the
 * non-zero elements.
 * Example
 * Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 */
public class MoveZeros
{
    public void moveZeroes(int[] nums)
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
        {
            list.add(nums[i]);
        }
        Iterator<Integer> iterator = list.iterator();
        int count = 0;
        while (iterator.hasNext())
        {
            if (iterator.next() == 0)
            {
                iterator.remove();
                count++;
            }
        }
        for (int i = 0; i < count; i++)
        {
            list.add(0);
        }
        for (int i = 0; i < list.size(); i++)
        {
            nums[i] = list.get(i);
        }
    }

    public static void main(String[] args)
    {
        MoveZeros moveZeros = new MoveZeros();
        int[] a = {1, 2, 3, 0, 0, 5};
        moveZeros.moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }
}
