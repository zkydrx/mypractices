package com.lintcode.company.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-12-13
 * Time: 21:38
 * Description:
 * <p>
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 * <p>
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。
 * 注意这里下标的范围是 1 到 n，不是以 0 开头。
 * 样例
 * 给出 numbers = [2, 7, 11, 15], target = 9, 返回 [1, 2].
 */
public class SumOfTwoNumber
{
    /**
     * 获取指定的数组
     * @param array
     * @param target
     * @return
     */
    public int[] getTheArrays(int[] array,int target)
    {
        List<Integer> list = new ArrayList<>();
        label:
        for (int i = 0; i < array.length; i++)
        {
            for (int i1 = 0; i1 < array.length; i1++)
            {
                if(array[i1]+array[i] == target&& i1!=i)
                {
                    list.add(i);
                    list.add(i1);
                    break label;
                }

            }
        }
        int [] array1 = new int[list.size()];
        for (int i = 0; i < array1.length; i++)
        {
            array1[i] = list.get(i)+1;
        }
        Arrays.sort(array1);
        return array1;
    }

    public static void main(String[] args)
    {
        int[] theArrays = new SumOfTwoNumber().getTheArrays(new int[]{2,4,2,4,342, 7, 11, 15}, 6);

        System.out.println(Arrays.toString(theArrays));
    }
}
