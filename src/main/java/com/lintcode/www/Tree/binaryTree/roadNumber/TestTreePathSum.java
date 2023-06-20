package com.lintcode.www.Tree.binaryTree.roadNumber;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-09-17 Time: 15:31
 * Description:
 */
public class TestTreePathSum {
	@Test
	public void testBinaryTreePathSum() {
		TreePathSum treePathSum = new TreePathSum();
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(4);
		treeNode.left.left = new TreeNode(2);
		treeNode.left.right = new TreeNode(3);
		List<List<Integer>> lists = treePathSum.binaryTreePathSum(treeNode, 5);

		for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i));
		}
	}
}
