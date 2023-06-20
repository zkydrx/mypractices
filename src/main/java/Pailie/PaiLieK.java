package pailie;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZKY on 2017-06-15 20:01. 给定 n 和 k，求123..n组成的排列中的第 k 个排列。
 * <p>
 * 注意事项
 * <p>
 * 1 ≤ n ≤ 9
 * <p>
 * 对于 n = 3, 所有的排列如下： 123 132 213 231 312 321 如果 k = 4, 第4个排列为，231.
 */
public class PaiLieK {
	public String getPermutation(int n, int k) {
		List<Integer> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		boolean has = true;
		first : for (int i = 0; i < Math.pow(10, n); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (!(i + "").contains(list.get(j) + "")) {
					has = false;
					continue;
				}
			}
			if (has && list.size() == getDigits(i)) {
				list1.add(i);
			}
			has = true;
		}
		Integer integer = list1.get(k - 1);
		return String.valueOf(integer);
	}

	public int getDigits(int i) {
		int count = 0;
		while (i > 0) {
			count++;
			i /= 10;
		}
		return count;
	}

	@Test
	public void testGetDigits() {
		System.out.println(getDigits(198));
		getDigits(198);
	}

	@Test
	public void testGetPermutation() {
		String permutation = getPermutation(3, 4);
		System.out.println(permutation);
	}

}
