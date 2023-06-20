package com.zhihei.jdk8.optional;

/**
 * @author ZKY
 * @createTime 2019/7/6 11:45
 * @description 员工对象
 */

public class Employee {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee{" + "name='" + name + '\'' + '}';
	}
}
