package com.zhihei.basicknowledge.listnotsafe;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-20 Time: 21:06:10
 * Description: 总结：使用junit测试多线程的功能时，由于其本身的特殊性： public static void main(String[]
 * args) { TestRunner aTestRunner = new TestRunner();
 * <p>
 * try { TestResult r = aTestRunner.start(args); if (!r.wasSuccessful()) {
 * System.exit(1); }
 * <p>
 * System.exit(0); } catch (Exception var3) {
 * System.err.println(var3.getMessage()); System.exit(2); }
 * <p>
 * } 不管成功与否，都会调用 System.exit() 方法关闭程序， 这个方法是用来结束当前正在运行中的java虚拟机。 System.exit(0)
 * 是正常退出程序， 而 System.exit(1) 或者说非0表示非正常退出程序。 由此可见，junit 并不适合用来测试多线程程序呢，
 * 但是也不是没有方法，根据其原理可以尝试让主线程阻塞一下， 等待其他子线程执行完毕再继续。 最简单的方法就是让主线程睡眠个几秒钟：
 * TimeUnit.SECONDS.sleep(5); 第二种方法是使用 private int i = 5; 线程计数器 将线程数量初始化
 * 每执行完成一条线程，调用countDown()使计数器减1 主线程调用方法await()使其等待，当计数器为0时才被执行 private
 * CountDownLatch latch = new CountDownLatch(i); CountDownLatch countDownLatch =
 * new CountDownLatch(count); 再在每个线程里调用这个方法： countDownLatch.countDown(); try {
 * countDownLatch.await(); } catch (Exception e) { e.printStackTrace(); }
 * 可参考testSet()
 */
public class ContainerNotSafeTest {
	/**
	 * 集合不安全问题 1.故障现象：java.util.ConcurrentModificationException（并发修改异常）
	 * 2.导致原因：并发争抢修改导致
	 * <p>
	 * 3.解决方案 3.1 使用Vector 3.2 Collections.synchronizedList(new ArrayList<>()); 3.3
	 * new CopyOnWriteArrayList<>();
	 * <p>
	 * 写时复制：CopyOnWrite即写时复制的容器。往一个容器中添加元素的时候，不直接往当前容器object[]添加，而是先将当前容器object[]
	 * 进行copy,复制出一个新的容器object[] newElements,然后往新的容器object[] newElements里添加元素，添加完元素之后
	 * 再将原容器的引用指向新的容器 setArray(newElements);这样做的好处是可以对CopyOnWrite的容器进行并发的读，而不需要加锁
	 * 因为当前容器不会添加任何元素。所以CopyOnWrite 也是一种读写分离的思想，读和写不同的容器。 底层源码： public boolean add(E
	 * e) { final ReentrantLock lock = this.lock; lock.lock(); try { Object[]
	 * elements = getArray(); int len = elements.length; Object[] newElements =
	 * Arrays.copyOf(elements, len + 1); newElements[len] = e;
	 * setArray(newElements); return true; } finally { lock.unlock(); } }
	 * <p>
	 * 4.优化建议
	 */
	@Test
	public void testArrayList() {
		/**
		 * Vector加了synchronized线程安全，但是性能太差。吞吐量太低。
		 */
		// List<String> integers = new Vector<>();

		/**
		 * 使用 Collections.synchronizedList(new ArrayList<>());
		 */
		// List<String> integers = Collections.synchronizedList(new ArrayList<>());
		List<String> integers = new ArrayList<>();
		// List<String> integers = new CopyOnWriteArrayList<>();
		for (int i = 0; i < 30; i++) {
			new Thread(() -> {

				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				integers.add(UUID.randomUUID().toString().substring(0, 8));
				System.out.println(Thread.currentThread().getName() + "\t" + integers);
			}, String.valueOf(i)).start();
		}

		/**
		 * public static void main(String[] args) { TestRunner aTestRunner = new
		 * TestRunner();
		 *
		 * try { TestResult r = aTestRunner.start(args); if (!r.wasSuccessful()) {
		 * System.exit(1); }
		 *
		 * System.exit(0); } catch (Exception var3) {
		 * System.err.println(var3.getMessage()); System.exit(2); }
		 *
		 * }
		 *
		 *
		 * 不管成功与否，都会调用 System.exit() 方法关闭程序， 这个方法是用来结束当前正在运行中的java虚拟机。 System.exit(0)
		 * 是正常退出程序， 而 System.exit(1) 或者说非0表示非正常退出程序。 由此可见，junit 并不适合用来测试多线程程序呢，
		 * 但是也不是没有方法，根据其原理可以尝试让主线程阻塞一下， 等待其他子线程执行完毕再继续。 最简单的方法就是让主线程睡眠个几秒钟：
		 * TimeUnit.SECONDS.sleep(5);
		 */
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Set 线程不安全
	 */
	@Test
	public void testSet() {
		/**
		 * 方法1:Collections.synchronizedSet(new HashSet<>());
		 */
		// Set<String> set = Collections.synchronizedSet(new HashSet<>());
		Set<String> set = new CopyOnWriteArraySet<>();
		Set<String> set1 = new HashSet<>();
		int count = 100;
		/**
		 * 这个主要用来解决，junit在多线程测试时的异常输出问题 线程计数器 将线程数量初始化 每执行完成一条线程，调用countDown()使计数器减1
		 * 主线程调用方法await()使其等待，当计数器为0时才被执行
		 */
		CountDownLatch countDownLatch = new CountDownLatch(count);

		for (int i = 0; i < count; i++) {
			new Thread(() -> {
				set.add(UUID.randomUUID().toString().substring(0, 10));
				System.out.println(Thread.currentThread().getName() + "\t" + set);
				countDownLatch.countDown();
			}, "[当前线程id]" + i).start();
		}
		try {
			countDownLatch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Map 线程不安全
	 */
	@Test
	public void testMap() {
		int count = 100;
		/**
		 * 1.使用new ConcurrentHashMap<>()解决线程安全问题
		 */
		// Map<String,String> map =new ConcurrentHashMap<>();

		/**
		 * 2.使用Collections.synchronizedMap(new HashMap<>());解决
		 */
		// Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
		Map<String, String> map = new HashMap<>();
		CountDownLatch countDownLatch = new CountDownLatch(count);
		for (int i = 0; i < count; i++) {
			new Thread(() -> {
				map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
				System.out.println(Thread.currentThread().getName() + "\t" + map);
				countDownLatch.countDown();
			}, "【当前线程】：" + i).start();
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
