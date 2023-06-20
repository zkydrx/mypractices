package knowledgeable.review202101.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-01-29 Time: 15:56:18
 * Description:
 */
public class LRUCacheDemo {
	/**
	 * map 负责查找，构建一个虚拟的双向链表，它里面安装的就是个个node节点，作为数据载体
	 */
	/**
	 * 1.node节点作为数据载体
	 *
	 * @param <K>
	 * @param <V>
	 */
	class Node<K, V> {
		K key;
		V value;
		Node<K, V> prev;
		Node<K, V> next;

		public Node() {
			this.prev = this.next = null;
		}

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.prev = this.next = null;
		}
	}

	class DoubleLinkedList<K, V> {
		Node<K, V> head;
		Node<K, V> tail;

		/**
		 * 2.1构造方法
		 */
		public DoubleLinkedList() {
			head = new Node<>();
			tail = new Node<>();
			head.next = tail;
			tail.prev = head;
		}

		/**
		 * 2.2添加到头
		 */
		public void addHead(Node<K, V> node) {
			node.next = head.next;
			node.prev = head;
			head.next.prev = node;
			head.next = node;
		}

		/**
		 * 2.3 删除节点
		 */
		public void removeNode(Node<K, V> node) {
			node.next.prev = node.prev;
			node.prev.next = node.next;
			node.prev = null;
			node.next = null;
		}

		/**
		 * 2.4获取最后一个节点
		 */
		public Node getLast() {
			return tail.prev;
		}
	}

	private int cacheSize;
	Map<Integer, Node<Integer, Integer>> map;
	DoubleLinkedList<Integer, Integer> doubleLinkedList;

	public LRUCacheDemo(int cacheSize) {
		this.cacheSize = cacheSize;
		map = new HashMap<>();
		doubleLinkedList = new DoubleLinkedList<>();
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		Node<Integer, Integer> integerIntegerNode = map.get(key);
		doubleLinkedList.removeNode(integerIntegerNode);
		doubleLinkedList.addHead(integerIntegerNode);
		return integerIntegerNode.value;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node<Integer, Integer> integerIntegerNode = map.get(key);
			integerIntegerNode.value = value;
			map.put(key, integerIntegerNode);
			doubleLinkedList.removeNode(integerIntegerNode);
			doubleLinkedList.addHead(integerIntegerNode);
		} else {
			if (map.size() == cacheSize) {
				Node<Integer, Integer> lastNode = doubleLinkedList.getLast();
				map.remove(lastNode.key);
				doubleLinkedList.removeNode(lastNode);
			}
			/**
			 * 新增
			 */
			Node<Integer, Integer> newNode = new Node<>(key, value);
			map.put(key, newNode);
			doubleLinkedList.addHead(newNode);
		}
	}

	public static void main(String[] args) {
		LRUCacheDemo lruMethod = new LRUCacheDemo(3);

		lruMethod.put(1, 1);
		lruMethod.put(2, 2);
		lruMethod.put(3, 3);
		System.out.println(lruMethod.map.keySet());
		lruMethod.put(5, 5);
		System.out.println(lruMethod.map.keySet());
		lruMethod.put(6, 6);
		lruMethod.put(3, 3);
		System.out.println(lruMethod.map.keySet());
		lruMethod.put(3, 3);
		System.out.println(lruMethod.map.keySet());
		lruMethod.put(3, 3);
		System.out.println(lruMethod.map.keySet());
		lruMethod.put(7, 7);
		System.out.println(lruMethod.map.keySet());
	}
}
