package com.hundsun.practices.lambda;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * 文件描述
 **/
public class BIgDecimalTest {
	@Test
	public void test() {
		BigDecimal bigDecimal = BigDecimal.valueOf(5L);
		BigDecimal bigDecimal1 = BigDecimal.valueOf(6L);
		System.out.println(bigDecimal1.compareTo(bigDecimal));
	}
}
