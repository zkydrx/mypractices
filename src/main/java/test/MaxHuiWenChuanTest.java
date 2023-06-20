package test;

import HuiWenChuan.MaxHuiWenChuan;
import org.junit.jupiter.api.Test;

/**
 * Created by ZKY on 2017-06-14 18:26.
 */
class MaxHuiWenChuanTest {
	@Test
	public void testLongestPalindrome() {
		String s = "abccccdd";
		MaxHuiWenChuan maxHuiWenChuan = new MaxHuiWenChuan();
		int i = maxHuiWenChuan.longestPalindrome(s);
		System.out.println(i);
		double pow = Math.pow(2, 16);
		System.out.println(pow);
	}
}