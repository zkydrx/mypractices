package com.leetcode.PascalsTriangleII119;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-19
 * Time: 00:41:32
 * Description:
 * 119. Pascal's Triangle II
 * <p>
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p>
 * For example, given k = 3,
 * Return [1,3,3,1].
 * <p>
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII
{
    public List<Integer> getRow(int rowIndex)
    {
        List<Integer> result = new ArrayList<>();
        if (rowIndex < 0)
        {
            return result;
        }

        result.add(1);
        for (int i = 1; i <= rowIndex; i++)
        {
            for (int j = result.size() - 2; j >= 0; j--)
            {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }

            result.add(1);
        }

        return result;
    }
}
