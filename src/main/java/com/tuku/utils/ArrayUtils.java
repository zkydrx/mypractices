package com.tuku.utils;

import net.sf.json.JSONArray;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2020-01-06 Time: 15:41:01
 * Description:
 */
public class ArrayUtils {

	/**
	 * 对象转数组 工具方式1 net.sf.json
	 */
	@Test
	public void testToArray() {
		Person build = Person.builder().age("1").money(100.0).name("tom").sex('A').build();
		/**
		 * 通过工具来将一个对象转成数组，全部是String数组
		 *
		 */
		JSONArray jsonArray = JSONArray.fromObject(build);
		for (Object o : jsonArray) {
			System.out.println(o);
		}
	}

	/**
	 * 在实体类中添加toArray方法
	 */
	@Test
	public void testToArrayByOwnMethod() {
		Person build = Person.builder().sex('A').name("Tom").money(100.00).age("100").build();

		String[] strings = build.toArray();

		for (String string : strings) {
			System.out.println(string);
		}
	}

}
