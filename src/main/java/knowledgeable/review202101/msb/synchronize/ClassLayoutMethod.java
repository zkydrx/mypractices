package knowledgeable.review202101.msb.synchronize;

import org.openjdk.jol.info.ClassLayout;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-01-30 Time: 12:42:58
 * Description: 该程序是为了查看java的内存布局。 借助了jol-core 类库，可以通过以下方法打印出java的内存布局信息
 */
public class ClassLayoutMethod {
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(5000);
		TT t = new TT();
		System.out.println(ClassLayout.parseInstance(t).toPrintable());
		synchronized (t) {
			System.out.println(ClassLayout.parseInstance(t).toPrintable());
		}
	}

	private static class TT {
		int m;
	}

}
