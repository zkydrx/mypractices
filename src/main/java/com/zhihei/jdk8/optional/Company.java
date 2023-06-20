package com.zhihei.jdk8.optional;

import java.util.List;

/**
 * @author ZKY
 * @createTime 2019/7/6 11:45
 * @description 公司对象
 */

public class Company {

	private String name;

	private List<Employee> employees;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
