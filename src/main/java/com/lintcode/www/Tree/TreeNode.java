package com.lintcode.www.Tree;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-14
 * Time: 14:44
 * Description:
 */
public class TreeNode
{

    int value;

    public TreeNode(int value)
    {
        this.value = value;
    }

    TreeNode left = null;
    TreeNode right = null;

    @Override
    public String toString()
    {
        return "TreeNode{" + "value=" + value + ", left=" + left + ", right=" + right + '}';
    }
}
