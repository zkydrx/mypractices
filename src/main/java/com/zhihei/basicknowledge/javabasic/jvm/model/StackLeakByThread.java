package com.zhihei.basicknowledge.javabasic.jvm.model;

public class StackLeakByThread {
	public static void main(String[] args) {
		while (true) {
			new Thread() {
				public void run() {
					while (true) {

					}
				}
			}.start();
		}
	}
}
