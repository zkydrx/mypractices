package knowledgeable.review202101.msb.thread.two;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-01-30 Time: 15:09:58
 * Description: 这个程序的作用是证明cpu指令重新排序了。 正常情况下是：x=0,y=1 或者x=1,y=0 或者x=y=1
 * 但是结果出现了x=y=0的情况，说明cpu底层对执行顺序进行了重新排列 其中一次运行结果是第98212次（0,0)
 * 证明了cpu底层针对汇编码进行了重新排序。 以下是这个程序的汇编码： 0 iconst_0 1 istore_1 2 iinc 1 by 1 5
 * iconst_0 6 putstatic #7
 * <knowledgeable/review202101/msb/thread/two/DisOrderMethod.x> 9 iconst_0 10
 * putstatic #13 <knowledgeable/review202101/msb/thread/two/DisOrderMethod.y> 13
 * iconst_0 14 putstatic #16
 * <knowledgeable/review202101/msb/thread/two/DisOrderMethod.a> 17 iconst_0 18
 * putstatic #19 <knowledgeable/review202101/msb/thread/two/DisOrderMethod.b> 21
 * new #22 <java/lang/Thread> 24 dup 25 invokedynamic #24 <run, BootstrapMethods
 * #0> 30 ldc #28 <t1> 32 invokespecial #30 <java/lang/Thread.<init>> 35
 * astore_2 36 new #22 <java/lang/Thread> 39 dup 40 invokedynamic #33 <run,
 * BootstrapMethods #1> 45 ldc #34 <t2> 47 invokespecial #30
 * <java/lang/Thread.<init>> 50 astore_3 51 aload_2 52 invokevirtual #36
 * <java/lang/Thread.start> 55 aload_3 56 invokevirtual #36
 * <java/lang/Thread.start> 59 aload_2 60 invokevirtual #39
 * <java/lang/Thread.join> 63 aload_3 64 invokevirtual #39
 * <java/lang/Thread.join> 67 new #42 <java/lang/StringBuilder> 70 dup 71
 * invokespecial #44 <java/lang/StringBuilder.<init>> 74 ldc #45 <第> 76
 * invokevirtual #47 <java/lang/StringBuilder.append> 79 iload_1 80
 * invokevirtual #51 <java/lang/StringBuilder.append> 83 ldc #54 <次（> 85
 * invokevirtual #47 <java/lang/StringBuilder.append> 88 getstatic #7
 * <knowledgeable/review202101/msb/thread/two/DisOrderMethod.x> 91 invokevirtual
 * #51 <java/lang/StringBuilder.append> 94 ldc #56 <,> 96 invokevirtual #47
 * <java/lang/StringBuilder.append> 99 getstatic #13
 * <knowledgeable/review202101/msb/thread/two/DisOrderMethod.y> 102
 * invokevirtual #51 <java/lang/StringBuilder.append> 105 ldc #58 <)> 107
 * invokevirtual #47 <java/lang/StringBuilder.append> 110 invokevirtual #60
 * <java/lang/StringBuilder.toString> 113 astore 4 115 getstatic #7
 * <knowledgeable/review202101/msb/thread/two/DisOrderMethod.x> 118 ifne 138
 * (+20) 121 getstatic #13
 * <knowledgeable/review202101/msb/thread/two/DisOrderMethod.y> 124 ifne 138
 * (+14) 127 getstatic #64 <java/lang/System.err> 130 aload 4 132 invokevirtual
 * #70 <java/io/PrintStream.println> 135 goto 141 (+6) 138 goto 2 (-136) 141
 * return
 */
public class DisOrderMethod {
	private static int x = 0, y = 0;
	private static int a = 0, b = 0;

	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		for (;;) {
			i++;
			x = 0;
			y = 0;
			a = 0;
			b = 0;
			Thread thread1 = new Thread(() -> {
				a = 1;
				x = b;
			}, "t1");
			Thread thread2 = new Thread(() -> {
				b = 1;
				y = a;
			}, "t2");
			thread1.start();
			thread2.start();
			thread1.join();
			thread2.join();
			String result = "第" + i + "次（" + x + "," + y + ")";
			if (x == 0 && y == 0) {
				System.err.println(result);
				break;
			}
		}
	}
}
