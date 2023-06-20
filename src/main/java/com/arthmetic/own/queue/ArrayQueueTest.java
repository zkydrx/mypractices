package com.arthmetic.own.queue;

import java.util.Scanner;

/**
 * 缺点：数组不能重复使用，只能使用一次。
 */
public class ArrayQueueTest {
	public static void main(String[] args) {
		HeadNode headNode = new HeadNode(3);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s(show): 显示队列");
			System.out.println("e(exit): 退出程序");
			System.out.println("a(add): 添加数据到队列");
			System.out.println("g(get): 从队列取出数据");
			System.out.println("h(head): 查看队列头的数据");
			/**
			 * 接收一个字符
			 */
			key = scanner.next().charAt(0);
			switch (key) {
				case 's' :
					headNode.showQueue();
					break;
				case 'a' :
					try {
						System.out.println("请输入一个数字:");
						headNode.addQueue(scanner.nextInt());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 'g' :

					try {
						System.out.println("取出的数字是：" + headNode.getQueue());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 'h' :
					try {
						System.out.println("头节点的数字是：" + headNode.showHead());
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 'e' :
					loop = false;
					break;
				default :
					break;
			}
		}
	}
}

class HeadNode {
	/**
	 * 队列的最大长度
	 */
	private Integer maxSize;
	/**
	 * 队列头
	 */
	private Integer head;
	/**
	 * 队列尾
	 */
	private Integer rear;

	/**
	 * 数组
	 */
	private int[] queue;

	/**
	 * 初始化构造器
	 *
	 * @param maxSize
	 */
	public HeadNode(Integer maxSize) {
		this.maxSize = maxSize;
		queue = new int[maxSize];
		head = -1;
		rear = -1;
	}

	/**
	 * 添加到队列
	 */
	public void addQueue(int n) {
		if (isFull()) {
			throw new RuntimeException("队列满，无法添加");
		}
		rear++;
		queue[rear] = n;
	}

	private boolean isFull() {
		return rear == maxSize - 1;
	}

	/**
	 * 从队列取元素
	 */
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列不能为空");
		}
		head++;
		return queue[head];
	}

	private boolean isEmpty() {
		return head == rear;
	}

	/**
	 * 显示队列元素
	 */
	public void showQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列是空的，无数据。");
		}
		for (int i = 0; i < queue.length; i++) {
			System.out.printf("queue[%d]=[%d]\n", i, queue[i]);
		}
	}

	/**
	 * 显示队列头的数据
	 *
	 * @return
	 */
	public int showHead() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		return queue[head + 1];
	}

}
