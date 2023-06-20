package knowledgeable.review202101.msb.thread.three;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-01-30 Time: 19:02:16
 * Description:
 */
public class CallableMethod {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "Hello";
			}
		};

		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<String> submit = executorService.submit(callable);
		/**
		 * submit.get()是阻塞的，所以这种写法无法解决问题。
		 */
		System.out.println(submit.get());
		executorService.shutdown();

	}
}
