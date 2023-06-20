package com.leetcode.InvertBinaryTree226;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-01-23 Time: 18:48:40
 * Description:
 * <p>
 * Invert a binary tree. 4 / \ 2 7 / \ / \ 1 3 6 9 to 4 / \ 7 2 / \ / \ 9 6 3 1
 * Trivia: This problem was inspired by this original tweet by Max Howell:
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you
 * can’t invert a binary tree on a whiteboard so fuck off.
 */
public class InvertBinaryTree {
	public static void main(String[] args) {
		InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

		TreeNode treeNode = new TreeNode(4);
		treeNode.right = new TreeNode(7);
		treeNode.left = new TreeNode(2);
		treeNode.left.left = new TreeNode(1);
		treeNode.left.right = new TreeNode(3);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(9);
		TreeNode treeNode1 = invertBinaryTree.invertTree(treeNode);

		System.out.println(treeNode1.left.left.val);
		System.out.println(treeNode1.left.right.val);
		System.out.println(treeNode1.right.left.val);
		System.out.println(treeNode1.right.right.val);
		System.out.println(treeNode1.val);

	}

	public TreeNode invertTree(TreeNode root) {
		if (root != null) {
			invert(root);
		}
		return root;
	}

	public void invert(TreeNode t) {
		TreeNode temp = t.left;
		t.left = t.right;
		t.right = temp;

		if (t.left != null) {
			invertTree(t.left);
		}
		if (t.right != null) {
			invertTree(t.right);
		}
	}
}
