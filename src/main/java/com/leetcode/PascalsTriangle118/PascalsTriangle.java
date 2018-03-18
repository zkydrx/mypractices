package com.leetcode.PascalsTriangle118;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-19
 * Time: 00:05:06
 * Description:
 * <p>
 * 118. Pascal's Triangle
 * <p>
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * For example, given numRows = 5,
 * Return
 * <p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle
{
    public List<List<Integer>> generate(int numRows)
    {

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0)
        {
            return null;
        }

        List<Integer> pre = new ArrayList<>();

        pre.add(1);
        result.add(pre);
        for (int i = 2; i <= numRows; i++)
        {

            List<Integer> cur = new ArrayList<>();
            cur.add(1);

            for (int j = 0; j < pre.size() - 1; j++)
            {
                cur.add(pre.get(j) + pre.get(j + 1));
            }
            cur.add(1);
            result.add(cur);
            pre = cur;
        }

        return result;
    }

}
