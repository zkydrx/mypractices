package com.leetcode.PathSum112;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-18
 * Time: 23:22:55
 * Description:
 *
 * 112. Path Sum
 * <p>
 * 112. Path Sum
 * <p>
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values
 * along the path equals the given sum.
 * <p>
 * For example:
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if(root == null)
        {
            return false;
        }

        if(root.val == sum&&(root.left==null && root.right == null))
        {
            return true;
        }

        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }


}
