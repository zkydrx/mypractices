package com.zhihei.basicknowledge.transfervalue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-21 Time: 19:26:42
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Computer {
	private String name;
	private double mondy;
}
