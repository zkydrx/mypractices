package com.zhihei.jdk8.example.ityu.forkjoin;

import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-16 Time: 17:02:40
 * Description: 4.3 并行流和顺序流 并行流是把一个内容分成多个数据块，并用不同的线程分别处理每个数据块的流。
 * 通过parallel()与sequential()可以实现并行流和顺序流之间的切换。
 * Fork/Join框架：在必要的情况下，将一个大任务进行拆分（fork）成若干小任务 （拆到不可再拆时），再将一个个小任务运算的结果进行join汇总。
 */
public class ForkJoinTest {
	@Test
	public void testForkJoin() {
		/**
		 * 顺序流
		 */
		long reduce = LongStream.rangeClosed(1, 10000).reduce(0, Long::sum);

		/**
		 * 并行流计算
		 */
		long reduce1 = LongStream.rangeClosed(1, 10000).parallel().reduce(0, Long::sum);

		System.out.println("顺序流结果:" + reduce);
		System.out.println("平行流结果:" + reduce1);
	}
}
