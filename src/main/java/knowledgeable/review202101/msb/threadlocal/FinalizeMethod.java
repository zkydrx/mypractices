package knowledgeable.review202101.msb.threadlocal;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-01-29 Time: 20:32:18
 * Description: 强引用： 特点：不会被gc回收，及使oom也不会被回收。
 */
public class FinalizeMethod {
	public static void main(String[] args) throws IOException {
		M m = new M();
		m = null;
		System.gc();
		System.in.read();
	}
}
