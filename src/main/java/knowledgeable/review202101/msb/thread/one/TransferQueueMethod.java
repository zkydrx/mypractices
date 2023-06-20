package knowledgeable.review202101.msb.thread.one;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-01-29 Time: 18:49:09
 * Description:
 */
public class TransferQueueMethod {
	public static void main(String[] args) {
		TransferQueue<Character> queue = new LinkedTransferQueue<>();

		char[] num = {'1', '2', '3', '4', '5', '6', '7', '8'};
		char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

		new Thread(() -> {

			try {
				for (char c : chars) {
					System.out.print(queue.take());
					queue.tryTransfer(c);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}, "t1").start();

		new Thread(() -> {

			try {
				for (char c : num) {
					queue.tryTransfer(c);
					System.out.print(queue.take());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}, "t2").start();
	}
}
