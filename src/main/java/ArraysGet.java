import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ZKY on 2017-05-27 3:09 PM. 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。 注意这里下标的范围是 1 到 n，不是以 0 开头。
 * <p>
 * 样例 给出 numbers = [2, 7, 11, 15], target = 9, 返回 [1, 2].
 */
public class ArraysGet {

	/*
	 * @param numbers : An array of Integer
	 * 
	 * @param target : target = numbers[index1] + numbers[index2]
	 * 
	 * @return : [index1 + 1, index2 + 1] (index1 < index2)
	 */
	public int[] twoSum(int[] numbers, int target) {

		int[] temp = new int[2];
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					temp[0] = i + 1;
					temp[1] = j + 1;
					list.add(temp);
				}
			}
		}

		if (list.size() > 0) {
			return list.get(0);
		} else {
			System.out.println("Doesn't found the numbers!");
			return null;
		}
	}

	@Test
	public void testTwoSum() {
		int[] a = {2, 7, 11, 15};

		int[] ints = twoSum(a, 26);
		String string = Arrays.toString(ints);
		System.out.println(string);
	}
}
