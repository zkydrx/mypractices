package knowledgeable.review202101.msb.jvm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-02-05 Time: 14:08:37
 * Description: 此程序的作用是模拟大量的循环创建对象，指定最大堆内存和最小堆内存为200M并打印出GC信息，可能会看到频繁的FULLGC的情况
 * <p>
 * java -Xms200M -Xmx200M -XX:+PrintGC FullGarbageCollecteProblem
 * <p>
 * 以下是在服务器上执行后的结果：
 * <p>
 * Exception: java.lang.OutOfMemoryError thrown from the
 * UncaughtExceptionHandler in thread "pool-1-thread-38" [Full GC (Ergonomics)
 * 159656K->159655K(182272K), 0.3610383 secs] [Full GC (Ergonomics)
 * 159655K->159655K(182272K), 0.3082337 secs] [Full GC (Ergonomics)
 * 159655K->159655K(182272K), 0.3076320 secs] [Full GC (Ergonomics)
 * 159655K->159655K(182272K), 0.3043142 secs] [Full GC (Ergonomics)
 * 159657K->159655K(182272K), 0.3057041 secs] [Full GC (Ergonomics)
 * 159656K->159655K(182272K), 0.3099699 secs] [Full GC (Ergonomics)
 * 159656K->159655K(182272K), 0.3078043 secs] [Full GC (Ergonomics)
 * 159656K->159655K(182272K), 0.3067159 secs] [Full GC (Ergonomics)
 * 159655K->159655K(182272K), 0.3084236 secs] [Full GC (Ergonomics)
 * 159655K->159655K(182272K), 0.3096631 secs] [Full GC (Ergonomics)
 * 159655K->159655K(182272K), 0.3095860 secs] [Full GC (Ergonomics)
 * 159655K->159655K(182272K), 0.3062731 secs] Exception in thread
 * "pool-1-thread-94" java.lang.OutOfMemoryError: GC overhead limit exceeded
 * [Full GC (Ergonomics) 159658K->159655K(182272K), 0.3065711 secs] [Full GC
 * (Ergonomics) 159656K->159655K(182272K), 0.3082267 secs] [Full GC (Ergonomics)
 * 159656K->159655K(182272K), 0.3067698 secs] [Full GC (Ergonomics)
 * 159656K->159655K(182272K), 0.3040433 secs] [Full GC (Ergonomics)
 * 159656K->159655K(182272K), 0.3087531 secs] [Full GC (Ergonomics)
 * 159656K->159655K(182272K), 0.3050596 secs] Exception in thread
 * "pool-1-thread-138" [Full GC (Ergonomics) 159656K->159655K(182272K),
 * 0.3129013 secs] [Full GC (Ergonomics) 159656K->159656K(182272K), 0.3093329
 * secs] [Full GC (Ergonomics) 159656K->159656K(182272K), 0.3065622 secs]
 */
public class FullGarbageCollecteProblem {
	private static ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(50,
			new ThreadPoolExecutor.DiscardOldestPolicy());

	private static class CardInfo {
		BigDecimal price = new BigDecimal(0.0);
		String name = "李四";
		int age = 5;
		Date birthday = new Date();

		public void m() {
		}
	}

	private static List<CardInfo> getAllCardInfo() {
		List<CardInfo> taskList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			CardInfo cardInfo = new CardInfo();
			taskList.add(cardInfo);
		}
		return taskList;
	}

	private static void modelFit() {
		List<CardInfo> allCardInfo = getAllCardInfo();

		allCardInfo.forEach(
				cardInfo -> scheduledThreadPoolExecutor.scheduleWithFixedDelay(cardInfo::m, 2, 3, TimeUnit.SECONDS));
	}

	public static void main(String[] args) throws InterruptedException {
		scheduledThreadPoolExecutor.setMaximumPoolSize(50);
		for (;;) {
			modelFit();
			Thread.sleep(100);
		}
	}
}
