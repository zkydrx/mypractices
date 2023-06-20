package com.zhihei.arithmetic;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-16 Time: 17:21:07
 * Description:
 */
public class StringBufferAndStringBuilderTest {
	@Test
	public void testStringBufferAndStringBUilder() throws InterruptedException {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				for (int i1 = 0; i1 < 10000; i1++) {
					stringBuilder.append("1");
				}
			}).start();
		}
		Thread.sleep(1000);
		System.out.println(stringBuilder.toString().length());

		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				for (int i1 = 0; i1 < 10000; i1++) {
					stringBuffer.append("r");
				}
			}).start();
		}
		Thread.sleep(1000);
		System.out.println(stringBuffer.toString().length());
	}
}
