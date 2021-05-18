package com.leetcode.PathSum112;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-18
 * Time: 23:48:54
 * Description:
 */
class PathSumTest
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
    void hasPathSum()
    {
        PathSum pathSum = new PathSum();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);


        boolean b = pathSum.hasPathSum(treeNode, 5);

        boolean b1 = pathSum.hasPathSum(treeNode, 7);

        System.out.println(b);
        System.out.println(b1);
    }
}