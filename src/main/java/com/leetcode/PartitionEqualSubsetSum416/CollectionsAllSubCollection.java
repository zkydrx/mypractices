package com.leetcode.PartitionEqualSubsetSum416;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-12-25 Time: 15:01
 * Description: 求一个集合所有的子集。
 */
public class CollectionsAllSubCollection {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		List<String> allCollections = new CollectionsAllSubCollection().getAllCollections(list);

		// for (int i = 0; i < allCollections.size(); i++)
		// {
		// System.out.print(allCollections.get(i));
		// }
		long collectionsOne = new CollectionsAllSubCollection().getCollectionsOne(4);

		System.out.println(collectionsOne);

		CollectionsAllSubCollection collectionsAllSubCollection = new CollectionsAllSubCollection();

		System.out.println("start....");

		String[] collectionTwo = collectionsAllSubCollection.getCollectionTwo(new String[]{"1", "2", "3", "4"}, 0, 4);
		System.out.println("*****************************************88");
		for (int i = 0; i < collectionTwo.length; i++) {
			System.out.println(collectionTwo[i]);
		}
	}

	public static void swap(String[] strings, int i, int j) {
		String temp = strings[i];
		strings[i] = strings[j];
		strings[j] = temp;
	}

	/**
	 * 求全组合，则假设原有元素n个，则最终组合结果是2^n个。原因是：
	 * 用位操作方法：假设元素原本有：a,b,c三个，则1表示取该元素，0表示不取。故去a则是001，取ab则是011.
	 * 所以一共三位，每个位上有两个选择0,1.所以是2^n个结果。
	 * 这些结果的位图值都是0,1,2....2^n。所以可以类似全真表一样，从值0到值2^n依次输出结果：即：
	 * 000,001,010,011,100,101,110,111 。对应输出组合结果为： 空,a, b ,ab,c,ac,bc,abc.
	 * 这个输出顺序刚好跟数字0~2^n结果递增顺序一样 取法的二进制数其实就是从0到2^n-1的十进制数。
	 *
	 * @param list
	 * @return
	 */
	public List<String> getAllCollections(List<String> list) {
		int a = 1 << 3;
		int a1 = 2 << 3;
		System.out.println(a + ":::" + a1);
		// 元素个数
		int length = list.size();
		// 全组合的个数"<<" 表示左移：各二进位全部左移若干位，高位丢弃，低位补0.即求出2^n=2Bit;
		long b = 1 << length;
		System.out.println("全组合的个数为：" + b);
		List<String> list1 = new ArrayList<>();
		/**
		 * 结果又b个。输出结果从小到大排列：0,1,2,3,4... 2^n
		 */
		for (long i = 0; i < b; i++) {
			System.out.println("组合数值：" + i + " 对应编码为：");
			for (int i1 = 0; i1 < length; i1++) {
				// 每个数二进制最多可以向做移动n次。即遍历完所有可能的变化的二进制的数值了。
				int temp = 1 << i1;
				// &表示与。两个位都为1时结果此案为1.
				if ((temp & i) != 0) {
					System.out.print(list.get(i1));
					list1.add(list.get(i1));
				}
			}
			System.out.println();
		}
		return list1;
	}

	/**
	 * 阶乘（递归版本）
	 *
	 * @param n
	 * @return
	 */
	public long getCollectionsOne(int n) {
		long result = 1L;

		if (n == 1) {
			result = n;
		} else {
			result = n * getCollectionsOne(n - 1);
		}
		return result;
	}

	public String[] getCollectionTwo(String[] strings, int from, int to) {
		if (to <= 1) {
			return null;
		} else if (from == to) {

			System.out.println(Arrays.toString(strings));
		} else {
			for (int i = from; i < to; i++) {
				swap(strings, i, from);
				getCollectionTwo(strings, from + 1, to);
				swap(strings, from, i);
			}
		}
		return strings;
	}
}
