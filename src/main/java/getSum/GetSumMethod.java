package getSum;

import org.junit.jupiter.api.Test;

/**
 * Created by ZKY on 2017-06-16 10:13.
 */
public class GetSumMethod {

	/**
	 * 利用递归写的一个阶乘运算，发现非常的占用资源。慎用。 递归能不用，尽量不用，结构虽然简单，但是数据量一大很容易栈溢出。
	 *
	 * @param n
	 * @return
	 */
	public int getJieCheng(int n) {
		if (n == 1) {
			return n;
		} else {
			return getJieCheng(n - 1) * n;
		}
	}

	/**
	 * 利用迭代相乘的办法得到阶乘。
	 *
	 * @param n
	 * @return
	 */
	public long getJieChengOne(int n) {
		long temp = 1L;
		for (int i = 1; i <= n; i++) {
			temp *= i;
		}
		return temp;
	}

	public long getSum(int n) {
		long sum = 0L;
		/**
		 * 此处注意0阶乘是零。
		 */
		for (int i = 1; i <= n; i++) {
			sum += getJieCheng(i);
		}
		return sum;
	}

	public long getSumOne(int n) {
		long sum = 0L;
		/**
		 * 此处注意0阶乘是零。
		 */
		for (int i = 1; i <= n; i++) {
			sum += getJieChengOne(i);
		}
		return sum;
	}

	@Test
	public void testGetJieCheng() {
		long time2 = System.currentTimeMillis();
		long sum1 = getSumOne(30000);
		time2 = System.currentTimeMillis() - time2;
		System.out.println("迭代用时：" + time2);
		long time1 = System.currentTimeMillis();
		long sum = getSum(30000);
		time1 = System.currentTimeMillis() - time1;
		System.out.println("阶乘用时：" + time1);
	}
}
