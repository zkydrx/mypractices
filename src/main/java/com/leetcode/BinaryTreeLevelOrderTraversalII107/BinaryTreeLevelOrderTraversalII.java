package com.leetcode.BinaryTreeLevelOrderTraversalII107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-11
 * Time: 00:55:21
 * Description:
 * <p>
 * 107. Binary Tree Level Order Traversal II
 * <p>
 * <p>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right,
 * level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversalII
{
    public List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
        {
            return result;
        }
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        current.offer(root);
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        while (!current.isEmpty())
        {
            TreeNode head = current.poll();
            numberList.add(head.val);
            if (head.left != null)
            {
                next.offer(head.left);
            }

            if (head.right != null)
            {
                next.offer(head.right);
            }

            if (current.isEmpty())
            {
                current = next;
                next = new LinkedList<TreeNode>();
                result.add(numberList);
                numberList = new ArrayList<Integer>();
            }
        }

        List<List<Integer>> reverseResult = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--)
        {
            reverseResult.add(result.get(i));
        }
        return reverseResult;
    }
}
