package com.tuku.utils;

import cn.hutool.core.date.DateUtil;
import com.tuku.model.TvPay;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2020-03-10 Time: 11:20:25
 * Description: 用于检测项目中可能遇到的错误
 */
@Slf4j
public class CheckTheErrorTest {
	/**
	 * flag:测试基于lambda排序过程遇到空字段如何处理的问题 result:使用如下的方法是可以避免NPE的，如果直接使用
	 * list.sort(Comparator.comparing(TvPay::getCreateTime).reversed());
	 * 当比较的字段为空的时候，会报NPE
	 */
	@Test
	public void testSortListForNullDate() {
		List<TvPay> list = new ArrayList<>();
		for (Long i = 0L; i < 2L; i++) {
			TvPay build = new TvPay();
			if (i % 2 == 0) {
				build = TvPay.builder().id(i).createTime(DateUtil.parseDateTime("2019-12-12 00:00:00")).build();
			} else {
				build = TvPay.builder().id(i).createTime(DateUtil.parseDateTime("2019-12-13 00:00:00")).build();
			}
			list.add(build);
		}
		for (Long i = 10L; i < 12L; i++) {
			TvPay build = TvPay.builder().id(i).build();
			list.add(build);
		}

		List<TvPay> collect = list.stream()
				.sorted(Comparator.comparing(TvPay::getCreateTime, Comparator.nullsFirst(Date::compareTo)))
				.collect(Collectors.toList());
		for (TvPay tvPay : collect) {
			System.out.println(tvPay);
		}
	}

	final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) throws Exception {

		ThreadPoolExecutor executor = new ThreadPoolExecutor(2000, 5000, 2, TimeUnit.MINUTES,
				new ArrayBlockingQueue<Runnable>(5000));
		// 模拟100人并发请求
		CountDownLatch latch = new CountDownLatch(1);
		// 模拟100个用户
		for (int i = 0; i < 100; i++) {

			AnalogUser analogUser = new AnalogUser(latch);
			executor.execute(analogUser);

		}
		// 计数器減一 所有线程释放 并发访问。
		latch.countDown();
	}

	static class AnalogUser implements Runnable {
		CountDownLatch latch;

		public AnalogUser(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			long starTime = 0;
			try {
				starTime = System.currentTimeMillis();
				latch.await();
				System.out.println("请求开始了");
				String result = httpPost("http://localhost:8080/index", "token=123&integer=1");
				log.info("result=======>{}", result);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long endTime = System.currentTimeMillis();
			Long t = endTime - starTime;
			System.out.println(t / 1000F + "秒");
		}

	}

	static String httpPost(String url, String strParam) {

		// post请求返回结果
		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost(url);
		// 设置请求和传输超时时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
		httpPost.setConfig(requestConfig);
		String str = null;
		try {
			if (null != strParam) {
				// 解决中文乱码问题
				StringEntity entity = new StringEntity(strParam, "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/x-www-form-urlencoded");
				httpPost.setEntity(entity);
			}
			CloseableHttpResponse result = httpClient.execute(httpPost);
			// 请求发送成功，并得到响应
			if (result.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {

				try {
					// 读取服务器返回过来的json字符串数据
					str = EntityUtils.toString(result.getEntity(), "utf-8");
				} catch (Exception e) {

				}
			}
		} catch (IOException e) {

		} finally {
			httpPost.releaseConnection();
		}
		return str;
	}

}
