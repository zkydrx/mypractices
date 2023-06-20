package com.zhihei.jdk8.example.moudle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-10 Time: 09:33:17
 * Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	private String id;
	private String name;
	private String address;

	public Person getData() {
		return Person.builder().id(id).name(name).address(address).build();
	}
}
