package com.zhihei.basicknowledge.cas;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-20 Time: 09:50:54
 * Description:
 */
public class CasTest {
	/**
	 * 1.CAS是什么？：比较并交换，英文compareAndSet的缩写！
	 */
	@Test
	public void testAtomicInteger() {
		AtomicInteger atomicInteger = new AtomicInteger(10);
		System.out.println(atomicInteger.compareAndSet(10, 9999) + "\t current data:" + atomicInteger.get());
		System.out.println(atomicInteger.compareAndSet(10, 1111) + "\t current data:" + atomicInteger.get());

		/**
		 * public final int getAndAddInt(Object var1, long var2, int var4) { int var5;
		 * 这块是cas的自旋 do { var5 = this.getIntVolatile(var1, var2); }
		 * while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
		 *
		 * return var5; }
		 */
		atomicInteger.getAndIncrement();
	}

}
