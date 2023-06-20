package fromeFaceBook.JavaProgramming.Thread;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-09-14 Time: 21:21
 * Description:
 */
public class TestGo implements Runnable {

	/**
	 * When an object implementing interface <code>Runnable</code> is used to create
	 * a thread, starting the thread causes the object's <code>run</code> method to
	 * be called in that separately executing thread.
	 * <p>
	 * The general contract of the method <code>run</code> is that it may take any
	 * action whatsoever.
	 *
	 * @see Thread#run()
	 */
	@Override
	public void run() {
		System.out.println("r1");
		System.out.println("r2");

	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new TestGo());
		t.start();
		System.out.println("m1");
		t.join();
		System.out.println("m2");
	}
}
