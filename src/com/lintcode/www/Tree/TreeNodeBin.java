package com.lintcode.www.Tree;


/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-09-14
 * Time: 14:03
 * Description:
 * 在二叉树中寻找值最大的节点并返回。
 */
public class TreeNodeBin
{

    /**
     * @param root the root of binary tree
     * @return the max ndoe
     */
    private TreeNode max = new TreeNode(Integer.MIN_VALUE);

    public TreeNode maxNode(TreeNode root)
    {
        if (root == null)
        {
            return root;
        }
        max = max.value > root.value ? max : root;
        maxNode(root.left);
        maxNode(root.right);
        return max;
    }

    public static void main(String[] args)
    {
        TreeNodeBin treeNodeBin = new TreeNodeBin();
        TreeNode t = new TreeNode(1);

        t.left = new TreeNode(-5);
        t.right = new TreeNode(2);
        t.left.left = new TreeNode(0);
        t.left.right = new TreeNode(3);
        t.right.left = new TreeNode(-4);
        t.right.right = new TreeNode(9);
        TreeNode treeNode = treeNodeBin.maxNode(t);
        System.out.println(treeNode.value);
    }

}
