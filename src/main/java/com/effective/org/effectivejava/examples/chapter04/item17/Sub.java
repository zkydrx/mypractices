package com.effective.org.effectivejava.examples.chapter04.item17;

import java.util.Date;

public final class Sub extends Super {
	private final Date date; // Blank final, set by constructor

	Sub() {
		date = new Date();
	}

	// Overriding method invoked by superclass constructor
	@Override
	public void overrideMe() {
		System.out.println(date);
	}

	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.overrideMe();
	}
}
