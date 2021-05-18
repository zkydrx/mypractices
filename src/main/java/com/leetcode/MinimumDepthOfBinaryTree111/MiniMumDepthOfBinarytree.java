package com.leetcode.MinimumDepthOfBinaryTree111;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-16
 * Time: 11:14:14
 * Description:
 * <p>
 * 111. Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MiniMumDepthOfBinarytree
{
    public int minDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        if (root.left == null && root.right == null)
        {
            return 1;
        }
        if (root.left == null)
        {
            return minDepth(root.right) + 1;
        }
        if (root.right == null)
        {
            return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
