package knowledgeable.review202101.msb.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-03-08 Time: 19:40:28
 * Description:
 */
public class ArraysVSLinkedList {
	static Integer N = 50000;

	static long readList(List list) {
		HashMap hashMap = new HashMap();
		Long currentTime = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++) {
			Object o = list.get(i);
		}
		return System.currentTimeMillis() - currentTime;
	}

	static List addList(List list) {
		for (Integer i = 0; i < N; i++) {
			Object o = new Object();
			list.add(o);
		}
		return list;
	}

	public static void main(String[] args) {
		List arrayList = addList(new ArrayList());
		List linkedList = addList(new LinkedList());
		System.out.println("ArrayList 查找" + N + " 条数据耗时：" + readList(arrayList));
		System.out.println("LinkedList 查找" + N + " 条数据耗时：" + readList(linkedList));
	}
}
