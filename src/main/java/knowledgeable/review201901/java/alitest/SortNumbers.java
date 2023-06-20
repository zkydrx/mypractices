package knowledgeable.review201901.java.alitest;

import java.util.*;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-02-03 Time: 16:16:13
 * Description: //评测题目: 1. 两个数组递增数组, 合并成一个递增数组， 例如a[]={2,10,14,19,51,71}, b[]
 * ={2,9,10,14,19,40,51} 合并成{2，9，10，14，19，40，51，71}
 */
public class SortNumbers {
	public static void main(String[] args) {
		Integer a[] = {2, 10, 14, 19, 51, 71};
		Integer b[] = {2, 9, 10, 14, 19, 40, 51};
		Set<Integer> listNoSameNumber = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		for (int i : a) {
			listNoSameNumber.add(i);
		}
		for (int i : b) {
			listNoSameNumber.add(i);
		}
		for (Integer integer : listNoSameNumber) {
			list.add(integer);
		}
		Collections.sort(list);
		System.out.println("use hashSet list:" + list);

		Integer c[] = {2, 10, 14, 19, 51, 71, 71};
		Integer d[] = {2, 9, 10, 14, 19, 40, 51};
		List<Integer> listc = new ArrayList<>();
		List<Integer> listd = new ArrayList<>();
		listc.addAll(Arrays.asList(c));
		listd.addAll(Arrays.asList(d));
		listc.removeAll(listd);
		listc.addAll(listd);
		Collections.sort(listc);
		System.out.println("use removeAll:" + listc);

	}
}
