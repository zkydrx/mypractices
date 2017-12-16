package com.lintcode.company.facebook;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-12-16
 * Time: 22:04
 * Description:
 * 给定一个排序数组，在原数组中删除重复出现的数字，使得每个元素只出现一次，并且返回新的数组的长度。
 * <p>
 * 不要使用额外的数组空间，必须在原地没有额外空间的条件下完成。
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 * 给出数组A =[1,1,2]，你的函数应该返回长度2，此时A=[1,2]。
 * <p>
 * 标签
 */
public class RemoveNumberOfArray
{
    public int removeDuplicates(int [] nums)
    {
        Set<Integer> set = new HashSet() ;
        for (int i = 0; i < nums.length; i++)
        {
            set.add(nums[i]);
        }

        Object[] objects = set.toArray();
        return set.size();
    }

    public static void main(String[] args)
    {
        int i = new RemoveNumberOfArray().removeDuplicates(new int[]{1, 2, 3, 3, 3, 4});

        System.out.println(i);
    }
}
