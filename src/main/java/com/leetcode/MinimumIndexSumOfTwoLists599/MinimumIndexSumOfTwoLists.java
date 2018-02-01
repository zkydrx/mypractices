package com.leetcode.MinimumIndexSumOfTwoLists599;

import java.util.ArrayList;
import java.util.List;

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
        int min = Math.min(list1.length,list2.length);
        String[] result = new String[min];
        List<String> list = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        for (int i = 0, j = 0; i < list1.length && j < list2.length; i++, j++)
        {
            if(list1[i].equals(list2[j]))
            {
                list.add(list1[i]);
                index.add(i+j);
            }
        }

        int minIndexNum = getMinIndexNum(index);

        String[] str = new String [1];
    }


    public int getMinIndexNum(List<Integer> list)
    {
        int t  = list.get(0);
        int index=0;
        for (int i = 0; i < list.size(); i++)
        {
            if (t > list.indexOf(i))
            {
                int temp = t;
                t = list.indexOf(i);
                list.set(i,t);
                index =i;
            }
        }

        return index;
    }
}
