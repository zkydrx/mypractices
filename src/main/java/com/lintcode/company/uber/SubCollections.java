package com.lintcode.company.uber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-12-22 Time: 00:51
 * Description: 给定一个含不同整数的集合，返回其所有的子集
 * <p>
 * 注意事项 子集中的元素排列必须是非降序的，解集必须不包含重复的子集
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes 样例 如果 S = [1,2,3]，有如下的解：
 * <p>
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 */
public class SubCollections {
	public static void main(String[] args) {
		SubCollections subCollections = new SubCollections();

		List list = new ArrayList();
		list.add(1);

		list.add(2);
		list.add(3);
		list.add(4);
		Set allSubCollections = subCollections.getAllSubCollections(list);

		for (Object a : allSubCollections) {
			System.out.println(a.toString());
		}

		System.out.println("****************************************");
		List subArrayList = subCollections.getSubArrayList(list);

		for (Object o : subArrayList) {
			System.out.println(o.toString());
		}

		int a = 10;
		a >>= 1;// a = a>>1;右移1，并把新值赋予a.
	}

	/**
	 * 位移。 集合中所有的元素用一个二进制位来代表1代表是存在的，0代表是不存在的。 例如{a,b,c} 一共有2^3用三个二进制位就可以表示了。 000
	 * 001 010 011 100 101 110 111 除了全1的都是该集合的真子集。所以一共有2^3-1=7个真子集。 该方法就是对上面例子的一种梳理。
	 *
	 * @param list
	 * @return
	 */
	public Set<Set<Integer>> getAllSubCollections(List<Integer> list) {
		Set<Set<Integer>> result = new HashSet<>();
		int length = list.size();
		int num = length == 0 ? 0 : 1 << (length);// 1<<n代表的是2的n次方
		for (int i = 0; i < num; i++) {
			Set<Integer> subSet = new HashSet<>();
			int index = i;
			for (int j = 0; j < length; j++) {
				if ((index & 1) == 1)// 如果某位不为零则说明该种情况是一个非空子集。所以加入到Set集合中。
				{
					subSet.add(list.get(j));
				}
				index >>= 1;
			}
			result.add(subSet);
		}
		return result;
	}

	/**
	 * 通过递归的方式实现查找子集。
	 *
	 * @param resouces
	 * @param nonius
	 * @param childs
	 * @param result
	 */
	public void getSubList(List<String> resouces, int nonius, ArrayList<String> childs,
			List<ArrayList<String>> result) {
		for (int i = nonius; i < resouces.size(); i++) {
			if (childs.size() < resouces.size() - 1) {
				childs.add(resouces.get(i));
				result.add(new ArrayList<>(childs));
				getSubList(resouces, i + 1, childs, result);
				childs.remove(childs.size() - 1);
			}
		}
	}

	/**
	 * 对递归的方法进行封装。
	 *
	 * @param resource
	 * @return
	 */
	public List<ArrayList<String>> getSubArrayList(List<String> resource) {
		ArrayList<String> child = new ArrayList<>();
		List<ArrayList<String>> result = new ArrayList<>();
		getSubList(resource, 0, child, result);
		return result;
	}

	/**
	 * 判断两个集合是否相等
	 *
	 * @param list1
	 * @param list2
	 * @return
	 */
	public boolean isSameListOrNot(List<Integer> list1, List<Integer> list2) {
		boolean b = true;
		if (!list1.containsAll(list2) || !list2.containsAll(list1)) {
			b = false;
		}

		return b;
	}
}
