package com.leetcode.ConvertSortedArrayToBinarySearchTree108;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-12
 * Time: 23:49:30
 * Description:
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
 * of every node never differ by more than 1.
 * <p>
 * <p>
 * Example:
 * <p>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class ConvertSortedArrayToBinarySearchTree
{
    public TreeNode sortedArrayToBST(int[] nums)
    {
        if (nums.length == 0)
        {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end)
    {
        if (start > end)
        {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);
        return root;
    }


    public void printTreeNode(TreeNode root)
    {
        if (root != null)
        {
            System.out.println(root.val);
        }
        printTreeNode(root.left);
        printTreeNode(root.right);
    }

}
