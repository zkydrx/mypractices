package com.zhihei.jdk8;

/**
 * @author ZKY
 * @createTime 2019/7/5 1:07
 * @description
 */

public class Person {

	private String username;
	private int age;

	public Person() {
	}

	public Person(String username, int age) {
		this.username = username;
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" + "username='" + username + '\'' + ", age=" + age + '}';
	}
}
