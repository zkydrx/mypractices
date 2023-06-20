package knowledgeable.review202101.msb.threadlocal;

import java.lang.ref.SoftReference;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-01-29 Time: 20:35:32
 * Description: 软引用 特点：内存不够时被回收。 使用场景：非常适合做缓存使用
 */
public class SoftReferenceMethod {
	public static void main(String[] args) {
		SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024 * 10]);
		System.out.println(softReference.get());
		System.gc();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(softReference.get());

		byte[] bytes = new byte[1024 * 1024 * 15];
		System.out.println(softReference.get());
	}
}
