package com.design.mode.iterator;

/**
 *
 */

public class Test {
	public static void main(String[] args) {
		String fileName = "d:\\JavaProject\\Iterator\\src\\data.txt";
		DataVector dataVector = new DataVector(fileName);
		Iterator iVector = dataVector.CreateIterator();
		for (iVector.First(); !iVector.IsDone(); iVector.Next()) {
			iVector.CurrentItem();
		}
	}
}