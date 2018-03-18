package com.leetcode.MinimumDepthOfBinaryTree111;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-18
 * Time: 23:07:11
 * Description:
 */
class MiniMumDepthOfBinarytreeTest
{

    @Test
    void minDepth()
    {
        MiniMumDepthOfBinarytree miniMumDepthOfBinarytree = new MiniMumDepthOfBinarytree();

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        int i = miniMumDepthOfBinarytree.minDepth(treeNode);

        System.out.println(i);
    }
}