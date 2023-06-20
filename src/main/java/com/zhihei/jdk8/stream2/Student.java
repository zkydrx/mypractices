package com.zhihei.jdk8.stream2;

/**
 * @author ZKY
 * @createTime 2019/7/11 22:17
 * @description
 */

public class Student {
	private String name;
	private int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", score=" + score + '}';
	}
}
