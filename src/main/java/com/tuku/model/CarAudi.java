package com.tuku.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2020-04-22 Time: 15:39:45
 * Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarAudi {
	private String name;
	private Double price;
	private Integer age;
}
