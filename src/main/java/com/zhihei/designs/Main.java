package com.zhihei.designs;

import java.util.ArrayList;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// write your code here
		new Thread(() -> {
			ArrayList<byte[]> lists = new ArrayList<byte[]>();
			while (true) {
				System.out.println(new Date().toString() + Thread.currentThread() + "==");
				byte[] bytes = new byte[1024 * 1024 * 1];
				lists.add(bytes);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.fillInStackTrace();
				}
			}
		}).start();

		new Thread(() -> {
			while (true) {
				System.out.println(new Date().toString() + Thread.currentThread() + "==");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.fillInStackTrace();
				}
			}
		}).start();
	}
}
