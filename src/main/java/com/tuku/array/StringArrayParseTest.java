package com.tuku.array;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2020-04-28 Time: 10:23:20
 * Description: 字符串转为字符串数组的问题
 */
@Slf4j
public class StringArrayParseTest {
	@Test
	public void testStringArray() {
		String arrayString = "[\"110000\",\"110100\"]";
		String substring = arrayString.substring(arrayString.indexOf("[") + 1, arrayString.indexOf("]"));
		String[] split1 = substring.split(",");
		log.info("截取的字符串：substring：{}", substring);
		log.info("直接字符串截取，处理---split1[0]:{}", split1[0]);
		log.info("直接字符串截取，处理---split1[1:{}", split1[1]);
		JSONArray jsonArray = JSONObject.parseArray(arrayString);
		log.info("解析成json数组---jsonArray 0:{}", jsonArray.get(0));
		log.info("解析成json数组---jsonArray 1:{}", jsonArray.get(1));
		String toString = jsonArray.toString();
		/**
		 * 这里已经成功完成了数据的转换。
		 */
		toString = toString.substring(toString.indexOf("[") + 1, toString.indexOf("]")).replaceAll("\"", "");
		log.info("json数组转成字符串toString:{}", toString);
		String[] split = toString.split(",");
		log.info("json数组转成字符串，然后对字符串进行处理---split[0]:{}", split[0]);
		log.info("json数组转成字符串，然后对字符串进行处理---split[1]:{}", split[1]);

		/**
		 * 其实可以直接使用字符串。
		 */

		String[] split2 = arrayString.substring(arrayString.indexOf("[") + 1, arrayString.indexOf("]"))
				.replaceAll("\"", "").split(",");

		log.info("直接使用字符串，进行截取与处理---split2[0]:{}", split2[0]);
		log.info("直接使用字符串，进行截取与处理---split2[0]:{}", split2[1]);

	}

	@Test
	public void testForeachRemoveAllAndAddAll() {
		List<Integer> integers = Arrays.asList(22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
		for (int i = 22; i < 32; i++) {
			List<Integer> integers2 = getIntegers(i);
			for (Integer integer : integers) {
				if (integers2.contains(integer)) {
					log.info("已经存在，不做任何操作");
				} else {
					log.info("这里做一些赋值或者其他操作");
				}
			}
		}
	}

	private List<Integer> getIntegers(int i) {
		List<Integer> integers = new ArrayList<>();
		if (i < 10) {
			for (int i1 = 0; i1 < i; i1++) {
				integers.add(i1);
			}
		} else {
			int i1 = (int) (i - Math.random() * 10);
			log.info("i1:{}", i1);
			for (; i1 < i; i1++) {
				integers.add(i1);
			}
		}
		return integers;
	}

	/**
	 * 测试通过：
	 */
	@Test
	public void testGetIntegers() {
		List<Integer> integers = getIntegers(88);
		log.info("获取到的整数数组列表:{}", JSONObject.toJSONString(integers));
	}
}
