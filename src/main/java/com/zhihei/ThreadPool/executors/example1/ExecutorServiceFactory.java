package com.zhihei.ThreadPool.executors.example1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-10-27 Time: 09:06:31
 * Description: 线程池构造工厂
 * <p>
 * 饿汉单例模式的应用，主要用在创建线程服务工厂，同时返回线程工厂服务
 */
public class ExecutorServiceFactory {
	private static ExecutorServiceFactory executorFactory = new ExecutorServiceFactory();
	/**
	 * 定时任务线程池
	 */
	private ExecutorService executors;

	private ExecutorServiceFactory() {
	}

	/**
	 * 获取ExecutorServiceFactory
	 *
	 * @return
	 */
	public static ExecutorServiceFactory getInstance() {
		return executorFactory;
	}

	/**
	 * 创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。 特点：定长线程池，支持定时及周期性任务执行。
	 *
	 * @return
	 */
	public ExecutorService createScheduledThreadPool() {
		// CPU个数
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		// 创建
		executors = Executors.newScheduledThreadPool(availableProcessors * 10, getThreadFactory());
		return executors;
	}

	/**
	 * 创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。（注意，如果因为在关闭前的执行期间出现失败
	 * 而终止了此单个线程，那么如果需要，一个新线程将代替它执行后续的任务）。 可保证顺序地执行各个任务，并且在任意给定的时间不会有多个线程是活动的。与其他等效的
	 * newFixedThreadPool(1) 不同，可保证无需重新配置此方法所返回的执行程序即可使用其他的线程。
	 * 特点：单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
	 *
	 * @return
	 */
	public ExecutorService createSingleThreadExecutor() {
		// 创建
		executors = Executors.newSingleThreadExecutor(getThreadFactory());
		return executors;
	}

	/**
	 * 创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。 对于执行很多短期异步任务的程序而言，这些线程池通常可提高程序性能。调用
	 * execute 将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的， 则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60
	 * 秒钟未被使用的线程。因此，长时间保持空闲的线程池不会使用任何资源。 注意，可以使用 ThreadPoolExecutor
	 * 构造方法创建具有类似属性但细节不同（例如超时参数）的线程池。
	 * <p>
	 * 特点：可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
	 *
	 * @return
	 */
	public ExecutorService createCachedThreadPool() {
		// 创建
		executors = Executors.newCachedThreadPool(getThreadFactory());
		return executors;
	}

	/**
	 * 创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程。在任意点，在大多数 nThreads
	 * 线程会处于处理任务的活动状态。如果在所有线程处于活动状态时提交附加任务
	 * ，则在有可用线程之前，附加任务将在队列中等待。如果在关闭前的执行期间由于失败而导致任何线程终止
	 * ，那么一个新线程将代替它执行后续的任务（如果需要）。在某个线程被显式地关闭之前，池中的线程将一直存在。
	 * <p>
	 * 特点：定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
	 *
	 * @return
	 */
	public ExecutorService createFixedThreadPool(int count) {
		// 创建
		executors = Executors.newFixedThreadPool(count, getThreadFactory());
		return executors;
	}

	/**
	 * 获取线程池工厂
	 *
	 * @return
	 */
	private ThreadFactory getThreadFactory() {
		return new ThreadFactory() {
			AtomicInteger sn = new AtomicInteger();

			public Thread newThread(Runnable r) {
				SecurityManager s = System.getSecurityManager();
				ThreadGroup group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
				Thread t = new Thread(group, r);
				t.setName("任务线程 - " + sn.incrementAndGet());
				return t;
			}
		};
	}
}
