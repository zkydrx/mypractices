package com.lintcode.www.Tree.binaryTree.roadNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-09-17 Time: 15:12
 * Description: 给定一个二叉树，找出所有路径中各节点相加总和等于给定 目标值 的路径。
 * <p>
 * 一个有效的路径，指的是从根节点到叶节点的路径。
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes 样例 给定一个二叉树，和 目标值 = 5:
 * <p>
 * 1 / \ 2 4 / \ 2 3 返回：
 * <p>
 * [ [1, 2, 2], [1, 4] ]
 */
public class TreePathSum {
	/**
	 * @param root
	 * @param target
	 * @return
	 */
	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
		ArrayList<List<Integer>> result = new ArrayList<>();
		if (null == root) {
			return result;
		}
		Stack<Integer> stack = new Stack<>();
		binaryTreePathSum(result, stack, root, 0, target);
		return result;
	}

	public void binaryTreePathSum(List<List<Integer>> result, Stack<Integer> stack, TreeNode root, int sum,
			int target) {
		sum += root.val;
		stack.push(root.val);
		if (sum == target && root.left == null && root.right == null) {
			List<Integer> list = new ArrayList<Integer>(stack);
			result.add(list);
			stack.pop();
			return;
		} else {
			if (root.left != null) {
				binaryTreePathSum(result, stack, root.left, sum, target);
			}
			if (root.right != null) {
				binaryTreePathSum(result, stack, root.right, sum, target);
			}
			stack.pop();
		}
	}

}
