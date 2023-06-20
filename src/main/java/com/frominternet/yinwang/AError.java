package com.frominternet.yinwang;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2020-09-28 Time: 16:55:29
 * Description:
 */
public class AError {
	public static void f() {
		String[] a = new String[2];
		Object[] b = a;
		a[0] = "hi";
		b[1] = Integer.valueOf(42);
	}

	public static void main(String[] args) {
		f();
	}
}
