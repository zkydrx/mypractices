package com.leetcode.MinimumIndexSumOfTwoLists599;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-02-01
 * Time: 23:25:39
 * Description:
 * 599. Minimum Index Sum of Two Lists
 * <p>
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants
 * represented by strings.
 * <p>
 * You need to help them find out their common interest with the least list index sum. If there is a choice tie
 * between answers, output all of them with no order requirement. You could assume there always exists an answer.
 * <p>
 * Example 1:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 * Example 2:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 * Note:
 * The length of both lists will be in the range of [1, 1000].
 * The length of strings in both lists will be in the range of [1, 30].
 * The index is starting from 0 to the list length minus 1.
 * No duplicates in both lists.
 */
public class MinimumIndexSumOfTwoLists
{
    public String[] findRestaurant(String[] list1, String[] list2)
    {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++)
        {
            map1.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++)
        {
            map2.put(list2[i], i);
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        List<String> list = null;
        for (int i = 0; i < list1.length; i++)
        {
            if (map2.containsKey(list1[i]))
            {
                sum = map1.get(list1[i]) + map2.get(list1[i]);
                if (sum < min)
                {
                    min = sum;
                    /**
                     * 如果sum比min小就新建Arraylist集合
                     * 始终保证list中保存的是下标和最小的String.
                     */
                    list = new ArrayList<>();
                    list.add(list1[i]);
                }
                else if (sum == min)
                {
                    list.add(list1[i]);
                }
            }
        }

        String[] str = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            str[i] = list.get(i);
        }

        return str;
    }
}
