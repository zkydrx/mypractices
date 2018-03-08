package com.leetcode.SameTree100;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-08
 * Time: 10:07:05
 * Description:
 * <p>
 * <p>
 * 100. Same Tree
 * Given two binary trees, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:     1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * Output: true
 * Example 2:
 * <p>
 * Input:     1         1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * Output: false
 * Example 3:
 * <p>
 * Input:     1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * Output: false
 */
public class SameTree
{
    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        boolean b = false;
        if (p == null && q == null)
        {
            b = true;
        }
        if (p != null && q != null)
        {
            if (p.val == q.val)
            {
                if (isSameTree(p.left, q.left))
                {
                    if (isSameTree(p.right, q.right))
                    {
                        b = true;
                    }

                }
            }
        }
        //return p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return b;
    }
}
