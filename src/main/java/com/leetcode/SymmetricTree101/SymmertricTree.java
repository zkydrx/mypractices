package com.leetcode.SymmetricTree101;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-09
 * Time: 09:09:03
 * Description:
 * <p>
 * 101. Symmetric Tree
 * <p>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmertricTree
{
    public boolean isSymmetric(TreeNode root)
    {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right)
    {
        if (left == null || right == null)
        {
            return left == right;
        }
        if (left.val != right.val)
        {
            return false;
        }

        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
}
