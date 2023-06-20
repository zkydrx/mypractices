package knowledgeable.review202101.msb.thread.three;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-01-30 Time: 19:14:01
 * Description:
 */
public class ListenableFeatureMethod {
	public static void main(String[] args) {
		/**
		 * 使用装饰器模式
		 */
		ListeningExecutorService listeningExecutorService = MoreExecutors
				.listeningDecorator(Executors.newFixedThreadPool(2));
		ListenableFuture<Integer> submit = listeningExecutorService.submit(new Callable<Integer>() {

			@Override
			public Integer call() {
				return 8;
			}
		});
		Futures.addCallback(submit, new FutureCallback<Integer>() {
			@Override
			public void onSuccess(@Nullable Integer integer) {
				System.out.println(integer);
			}

			@Override
			public void onFailure(Throwable throwable) {
				throwable.printStackTrace();
			}
		}, listeningExecutorService);

		listeningExecutorService.shutdownNow();
	}
}
