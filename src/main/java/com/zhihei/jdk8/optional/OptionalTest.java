package com.zhihei.jdk8.optional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author ZKY
 * @createTime 2019/7/6 11:47
 * @description
 */

public class OptionalTest {

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setName("zhangsan");

		Employee employee1 = new Employee();
		employee1.setName("zhangsan");

		Company company = new Company();
		company.setName("company1");
		List<Employee> employees = Arrays.asList(employee, employee1);
		// company.setEmployees(employees);

		// 需求判断 打印company中的list 没有则返回空的list对象

		Optional<Company> optionalCompany = Optional.ofNullable(company);

		System.out.println(optionalCompany.map(item -> item.getEmployees()).orElse(Collections.emptyList()));

	}
}
