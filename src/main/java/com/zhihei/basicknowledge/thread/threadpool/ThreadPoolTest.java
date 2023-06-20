package com.zhihei.basicknowledge.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-12-01 Time: 14:58:59
 * Description: 使用java的线程池实现多线程
 */
public class ThreadPoolTest {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService1 = Executors.newFixedThreadPool(5);
		ExecutorService executorService2 = Executors.newSingleThreadExecutor();
		ExecutorService executorService3 = Executors.newCachedThreadPool();
		System.out.println("固定线程数量的线程池newFixedThreadPool：");
		try {
			for (int i = 1; i <= 10; i++) {
				executorService1.execute(() -> {
					System.out.println(Thread.currentThread().getName() + "\t办理线程");
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			executorService1.shutdown();
		}

		TimeUnit.SECONDS.sleep(1);
		System.out.println("---------------------------------------------------------");
		System.out.println("1个线程数量的线程池newSingleThreadExecutor：");
		try {
			for (int i = 1; i <= 10; i++) {
				executorService2.execute(() -> {
					System.out.println(Thread.currentThread().getName() + "\t 执行任务");
				});

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			executorService2.shutdown();
		}

		TimeUnit.SECONDS.sleep(1);

		System.out.println("---------------------------------------------------------");
		System.out.println("不固定线程数量的线程池newCachedThreadPool：");
		System.out.println("一个线程处理所有的请求-------------------------");
		// try
		// {
		// for (int i = 1; i <= 10; i++)
		// {
		//
		// executorService3.execute(() -> {
		// System.out.println(Thread.currentThread().getName() + "\t 执行任务");
		// });
		// try
		// {
		// TimeUnit.MILLISECONDS.sleep(300);
		// }
		// catch (InterruptedException e)
		// {
		// e.printStackTrace();
		// }
		// }
		// }
		// catch (Exception e)
		// {
		// e.printStackTrace();
		// }
		// finally
		// {
		// executorService3.shutdown();
		// }

		TimeUnit.SECONDS.sleep(5);
		/**
		 * 这个与上面的一个线程处理所有请求的例子不要一起执行，否者会报错。
		 */
		System.out.println("多个线程处理所有的请求-------------------------");
		try {
			for (int i = 1; i <= 10; i++) {
				executorService3.execute(() -> {
					System.out.println(Thread.currentThread().getName() + "\t 执行任务");
				});

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			executorService3.shutdown();
		}
		TimeUnit.SECONDS.sleep(1);
	}

}
