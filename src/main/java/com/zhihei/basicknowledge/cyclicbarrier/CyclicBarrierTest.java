package com.zhihei.basicknowledge.cyclicbarrier;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-22 Time: 22:22:05
 * Description: CyclicBarrier：可循环使用的屏障，让一组线程达到一个屏障
 * （也可以叫同步点）时被阻塞，直到最后一个线程达到屏障时，屏障才会开门， 所有被屏障拦截的线程才能继续干活，线程进入屏障通过CyclicBarrier的
 * await()方法
 */
public class CyclicBarrierTest {
	@Test
	public void testCyclicBarrier() {
		int count = 10;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(count, () -> System.out.println("人员到齐开始开会"));
		for (int i = 1; i <= count; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + "\t 号员工达到会议室");
				try {
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}, String.valueOf(i)).start();
		}
	}
}
