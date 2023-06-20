package com.lintcode.www.Tree.test;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-09-14 Time: 15:20
 * Description:
 */
public class TreeNodeBin1 {
	/**
	 * @param root
	 *            the root of binary tree
	 * @return the max ndoe
	 */
	private TreeNode1 max = new TreeNode1(Integer.MIN_VALUE);

	public TreeNode1 maxNode(TreeNode1 root) {
		if (root == null) {
			return root;
		}
		max = max.value > root.value ? max : root;
		maxNode(root.left);
		maxNode(root.right);
		return max;
	}
}
