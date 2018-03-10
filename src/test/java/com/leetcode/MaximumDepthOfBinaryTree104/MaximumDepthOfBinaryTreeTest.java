package com.leetcode.MaximumDepthOfBinaryTree104;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-11
 * Time: 00:40:10
 * Description:
 */
class MaximumDepthOfBinaryTreeTest
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
    void maxDepth()
    {
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(5);
        treeNode.right.right.left = new TreeNode(6);
        int i = maximumDepthOfBinaryTree.maxDepth(treeNode);

        System.out.println(i);
    }
}