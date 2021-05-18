package com.lintcode.www.Tree.test;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-14
 * Time: 15:16
 * Description:
 */
public class TestTreeNodeBin1
{
    @Test
    public void testTreeNode()
    {
        TreeNodeBin1 treeNodeBin1 = new TreeNodeBin1();
        TreeNode1 t = new TreeNode1(1);
        t.left = new TreeNode1(-5);
        t.right = new TreeNode1(2);
        t.left.left = new TreeNode1(0);
        t.left.right = new TreeNode1(3);
        t.right.left = new TreeNode1(-4);
        t.right.right = new TreeNode1(-5);
        TreeNode1 treeNode1 = treeNodeBin1.maxNode(t);
        System.out.println(treeNode1.value);
    }
}
