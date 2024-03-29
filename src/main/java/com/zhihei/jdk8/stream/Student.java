package com.zhihei.jdk8.stream;

import lombok.Data;

/**
 * @author ZKY
 * @createTime 2019/7/11 19:58
 * @description
 */

@Data
public class Student {
	private String name;
	private int score;
	private int age;

	public Student(String name, int score, int age) {
		this.name = name;
		this.score = score;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
