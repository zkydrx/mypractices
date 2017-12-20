package com.lintcode.company.facebook;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-12-20
 * Time: 22:24
 * Description:
 * 给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
 * <p>
 * 注意事项
 * 在三元组(a, b, c)，要求a <= b <= c。
 * <p>
 * 结果不能包含重复的三元组。
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes
 * 样例
 * 如S = {-1 0 1 2 -1 -4}, 你需要返回的三元组集合的是：
 * <p>
 * (-1, 0, 1)
 * <p>
 * (-1, -1, 2)
 */
public class ThreeNumberOfSum
{
    public static void main(String[] args)
    {
        ThreeNumberOfSum threeNumberOfSum = new ThreeNumberOfSum();

        List<int[]> list = threeNumberOfSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(Arrays.toString(list.get(i)));
        }
    }

    /**
     * 删除Arraylist的重复元素
     */
    public static void removeDuplicateObject(List list)
    {
        for (int i = 0; i < list.size() - 1; i++)
        {
            for (int i1 = list.size() - 1; i1 > i; i1--)
            {
                if (list.get(i1).equals(list.get(i)))
                {
                    list.remove(i1);
                }
            }
        }

        System.out.println(list);
    }

    /**
     * 使用Set集合的元素不可重复性来删除重复的元素
     */
    public static void removeDuplicateObjectOne(List list)
    {
        HashSet hashSet = new HashSet(list);
        list.clear();
        list.addAll(hashSet);
        System.out.println(list);

    }

    /**
     * 删除Arraylist中的元素保持顺序
     */

    public static void removeDuplicateObjectTwo(List list)
    {
        Set set = new HashSet();
        List newList = new ArrayList();

        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            Object next = iterator.next();

            if (set.add(next))
            {
                newList.add(next);
            }
        }
        list.clear();
        list.addAll(newList);
        System.out.println(list);
    }

    public List<int[]> threeSum(int[] array)
    {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++)
        {
            for (int i1 = 0; i1 < array.length; i1++)
            {
                for (int i2 = 0; i2 < array.length; i2++)
                {
                    int[] temp = new int[3];

                    if (i != i1 && i1 != i2 && i != i2)
                    {
                        if (array[i] + array[i1] + array[i2] == 0)
                        {

                            int[] sortArray = new int[]{array[i], array[i1], array[i2]};
                            Arrays.sort(sortArray);
                            temp[0] = sortArray[0];
                            temp[1] = sortArray[1];
                            temp[2] = sortArray[2];

                            list.add(temp);
                        }
                    }
                }
            }
        }

        /**
         * 删除重复的数组
         */
        for (int i = 0; i < list.size() - 1; i++)
        {
            for (int i1 = list.size() - 1; i1 > i; i1--)
            {
                if (isTheSameArrayOrNot(list.get(i), list.get(i1)))
                {
                    list.remove(i1);
                }
            }
        }
        return list;
    }

    /**
     * 判断两个数组是否相等
     *
     * @param a
     * @param b
     * @return
     */
    public boolean isTheSameArrayOrNot(int[] a, int[] b)
    {
        boolean b1 = true;
        lab:
        for (int i = 0; i < a.length; i++)
        {
            for (int i1 = 0; i1 < b.length; i1++)
            {
                if (i == i1)
                {
                    if (a[i] != b[i1])
                    {
                        b1 = false;
                        break lab;
                    }
                }
            }
        }

        return b1;
    }

}
