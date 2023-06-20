package com.zhihei.basicknowledge.countdownlatch;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-22 Time: 21:47:05
 * Description: 枚举可以当数据库来用，而且效率超高，没有io瓶颈 要写高性能的代码，枚举可以在关键时刻帮你大忙！
 */
public enum CountryEnums {
	ONE(1, "A"), TWO(2, "B"), THREE(3, "C"), FOUR(4, "D"), FIVE(5, "E"), SIX(6, "F");
	@Getter
	private int id;
	@Getter
	private String name;

	CountryEnums(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public static CountryEnums getCountry(Integer id) {
		for (CountryEnums value : CountryEnums.values()) {
			/**
			 * 这两种都可以，但是我更倾向于第一种 id==value.id
			 */
			// if(id==value.getId())
			if (id == value.id) {
				return value;
			}
		}
		return null;
	}
}
