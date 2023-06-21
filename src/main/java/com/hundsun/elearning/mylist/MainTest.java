package com.hundsun.elearning.mylist;

/**
 * @ProjectName: mypractices
 * @Package: com.hundsun.elearning.mylist
 * @ClassName: MainTest
 * @Author: hspcadmin
 * @Description:
 * @Date: 2022-05-29 0:19
 * @Version: 1.0
 */
public class MainTest {
	public static void main(String[] args) {
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(1);
		myLinkedList.add(2);
		myLinkedList.add(3);
		myLinkedList.add(4);
		myLinkedList.add(5);
		myLinkedList.add(6);
		myLinkedList.add(7);
		myLinkedList.add(8);
		MyLinkedList.Node remove = myLinkedList.remove(3);
		System.out.println(remove.data);
		myLinkedList.display();

	}
}
