package com.leetcode.AddTwoNumbers2;

import lombok.Data;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.leetcode.AddTwoNumbers2
 * @Description: note
 * @Author: zky
 * @CreateDate: 2021/7/28 0:38
 * @UpdateUser: zky
 * @UpdateDate: 2021/7/28 0:38
 * @UpdateRemark: The modified content
 * @DATE: 2021-07-28 00:38
 * @SINCE:
 * @Version: 1.0
 *           <p>
 *           Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@Data
public class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return "ListNode{" + "val=" + val + ", next=" + next + '}';
	}
}
