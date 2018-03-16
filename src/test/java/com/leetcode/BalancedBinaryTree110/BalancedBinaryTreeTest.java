package com.leetcode.BalancedBinaryTree110;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-16
 * Time: 11:05:15
 * Description:
 */
class BalancedBinaryTreeTest
{

    @BeforeEach
    void setUp()
    {
        System.out.println("String...");
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("Ending...");
    }

    @Test
    void isBalanced()
    {
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        boolean balanced = balancedBinaryTree.isBalanced(treeNode);

        System.out.println(balanced);
    }

    @Test
    void getHegith()
    {
    }
}