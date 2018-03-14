package com.leetcode.ConvertSortedArrayToBinarySearchTree108;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-14
 * Time: 14:08:28
 * Description:
 */
class ConvertSortedArrayToBinarySearchTreeTest
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
    void sortedArrayToBST()
    {
        ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree = new
                ConvertSortedArrayToBinarySearchTree();
        int [] nums = {-10,-3,0,5,9};
        TreeNode treeNode = convertSortedArrayToBinarySearchTree.sortedArrayToBST(nums);

        convertSortedArrayToBinarySearchTree.printTreeNode(treeNode);
    }

    @Test
    void sortedArrayToBST1()
    {
    }
}