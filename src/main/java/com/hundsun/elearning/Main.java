package com.hundsun.elearning;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: practices
 * @Author: zhouky36626
 * @Date: 2023/4/21 23:49
 * @Version: 1.0
 * @Copyright: 2023 Hundsun All rights reserved.
 */

public class Main {
	public static void main(String[] args) throws Exception {
		// 将时间戳转换为二进制字符串数字
		long timestamp = 1646101280000L;
		String numStr = getBinaryNumberFromTimestamp(timestamp);

		// 将二进制字符串数字转换为时间戳
		long recoveredTimestamp = getTimestampFromBinaryNumber("11173664690");

		// 将时间戳转换为 yyyy-MM-dd HH:mm:ss 格式的日期字符串
		String dateStr = formatDate(recoveredTimestamp);

		// 将日期字符串转换为时间戳
		long recoveredTimestamp2 = formatTimestamp(dateStr);

		System.out.println("timestamp: " + timestamp);
		System.out.println("numStr: " + numStr);
		System.out.println("recoveredTimestamp: " + recoveredTimestamp);
		System.out.println("dateStr: " + dateStr);
		System.out.println("recoveredTimestamp2: " + recoveredTimestamp2);
	}

	public static String getBinaryNumberFromTimestamp(long timestamp) {
		// 将时间戳转换为长度为16位的二进制字符串
		String str = String.format("%16s", Long.toBinaryString(timestamp)).replace(' ', '0');

		// 使用掩码 'xxxxxxxxxxxxxxxx' 将字符串转换为二进制字符串数字
		BigDecimal num = new BigDecimal(new BigInteger(str, 2));
		return num.toBigIntegerExact().toString();
	}

	public static long getTimestampFromBinaryNumber(String numStr) {
		// 将二进制字符串数字转换为 BigDecimal 类型
		BigDecimal num = new BigDecimal(new BigInteger(numStr, 2));

		// 使用掩码 'xxxxxxxxxxxxxxxx' 将 BigDecimal 转换成 long 类型的时间戳
		long timestamp = num.toBigInteger().longValue() & 0xffffffffffff0000L;
		return timestamp;
	}

	public static String formatDate(long timestamp) {
		// 将时间戳转换为日期对象
		Date date = new Date(timestamp);

		// 将日期对象格式化成 yyyy-MM-dd HH:mm:ss 格式的字符串
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static long formatTimestamp(String dateStr) throws Exception {
		// 将日期字符串解析成日期对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(dateStr);

		// 将日期对象转换为时间戳
		long timestamp = date.getTime();
		return timestamp;
	}
}
