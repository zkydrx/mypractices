package com.leetcode.BinaryTreeLevelOrderTraversalII107;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-12
 * Time: 09:02:25
 * Description:
 */
class BinaryTreeLevelOrderTraversalIITest
{

    @Test
    void levelOrderBottom()
    {
        BinaryTreeLevelOrderTraversalII binaryTreeLevelOrderTraversalII = new BinaryTreeLevelOrderTraversalII();

        TreeNode treeNode = new TreeNode(1);
        treeNode.left =new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right =new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        List<List<Integer>> arrayLists = binaryTreeLevelOrderTraversalII.levelOrderBottom(treeNode);

        for (int i = 0; i < arrayLists.size(); i++)
        {
            ArrayList<Integer> integers = (ArrayList<Integer>) arrayLists.get(i);

            for (int i1 = 0; i1 < integers.size(); i1++)
            {
                System.out.print(integers.get(i1)+"\t");
            }
        }
        System.out.println();


    }

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
}