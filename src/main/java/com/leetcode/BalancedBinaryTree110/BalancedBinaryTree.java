package com.leetcode.BalancedBinaryTree110;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-16
 * Time: 08:46:16
 * Description:
 * <p>
 * 110. Balanced Binary Tree
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example 1:
 * <p>
 * Given the following tree [3,9,20,null,null,15,7]:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Return true.
 * <p>
 * Example 2:
 * <p>
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * Return false.
 */
public class BalancedBinaryTree
{
    public boolean isBalanced(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        if(getHegith(root) == -1)
        {
            return false;
        }

        return true;
    }

    public int getHegith(TreeNode treeNode)
    {
        if(treeNode == null)
        {
            return 0;
        }
        int left = getHegith(treeNode.left);
        int right = getHegith(treeNode.right);
        if(left == -1 ||right ==-1)
        {
            return  -1;
        }
        if(Math.abs(left-right)>1)
        {
            return  -1;
        }

        return Math.max(left,right)+1;
    }


}
