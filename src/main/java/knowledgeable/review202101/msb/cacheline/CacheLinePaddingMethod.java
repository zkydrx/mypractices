package knowledgeable.review202101.msb.cacheline;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-02-01 Time: 19:01:52
 * Description: 该程序的宗旨是证明cache line 的概念，缓存行对齐。 执行结果大概是290ms左右
 * 说明：由于cpu读取缓存的时候都是读取一个缓存行，所以两个T对象中的long类型只占了16个字节
 * 由于T的变量是volatile的，由于volatile对线程的可见性，那么在多核cpu对这两个对象进行循环赋值的时候
 * 一定会进行线程同步，这样就导致了对每个变量进行复制操作的时候都要去同步另外一个线程的更新后的值，这样就会大大的降低效率，从而是增加了计算时间
 * 比CacheLinePaddingMethod1的各自执行计算操作耗时要长。
 */
public class CacheLinePaddingMethod {
	private static class T {
		public volatile long x = 0L;
	}

	public static T[] arr = new T[2];

	static {
		arr[0] = new T();
		arr[1] = new T();
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			for (long i = 0; i < 10000000L; i++) {
				arr[0].x = i;
			}
		}, "threadName");

		Thread t2 = new Thread(() -> {
			for (long i = 0; i < 10000000L; i++) {
				arr[1].x = i;
			}
		}, "threadName");

		long start = System.nanoTime();
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println((System.nanoTime() - start) / 1000000);
	}
}
