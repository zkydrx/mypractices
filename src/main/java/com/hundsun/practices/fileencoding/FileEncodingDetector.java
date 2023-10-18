package com.hundsun.practices.fileencoding;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.mozilla.universalchardet.UniversalDetector;

public class FileEncodingDetector {

	public static String detectEncoding(String filePath) {
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {
			byte[] buffer = new byte[1000]; // 读取足够的字节进行判断

			// 尝试读取文件的字节
			int bytesRead = bis.read(buffer);
			if (bytesRead == -1) {
				return "Unknown"; // 文件为空
			}

			// 检测文件编码格式
			Charset charset = detectCharset(buffer, bytesRead);
			if (charset != null) {
				return charset.displayName();
			}

			// 默认返回ANSI编码
			return "ANSI";
		} catch (IOException e) {
			e.printStackTrace();
			return "Unknown"; // 发生异常
		}
	}

	private static Charset detectCharset(byte[] buffer, int bytesRead) {
		Charset[] charsetsToCheck = {StandardCharsets.UTF_8, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE,
				Charset.forName("GBK"),};

		for (Charset charset : charsetsToCheck) {
			if (isCharset(buffer, bytesRead, charset)) {
				return charset;
			}
		}

		return null; // 无法确定编码格式
	}

	private static boolean isCharset(byte[] buffer, int bytesRead, Charset charset) {
		String content = new String(buffer, 0, bytesRead, charset);
		byte[] regeneratedBytes = content.getBytes(charset);

		for (int i = 0; i < bytesRead; i++) {
			if (buffer[i] != regeneratedBytes[i]) {
				return false;
			}
		}

		return true;
	}

	public static String detectEncoding1(String filePath) {
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {
			UniversalDetector detector = new UniversalDetector(null);

			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = bis.read(buffer)) > 0 && !detector.isDone()) {
				detector.handleData(buffer, 0, bytesRead);
			}
			detector.dataEnd();

			String encoding = detector.getDetectedCharset();
			detector.reset();

			if (encoding != null) {
				return encoding;
			} else {
				return "Unknown";
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "Unknown";
		}
	}

	public static void main(String[] args) throws IOException {
		String filePath = "D:\\document\\hundsunWork\\issue\\306.BTA转数设计\\temp\\BTA_PRD_SHARE_20230104_40";
		String filePath1 = "D:\\document\\hundsunWork\\issue\\306.BTA转数设计\\fileEncoding\\BTA_PRD_SHARE_20230104_40.csv";
		String filePath2 = "D:\\document\\hundsunWork\\issue\\306.BTA转数设计\\fileEncoding\\BTA_PRD_SHARE_20230613_70";
		String encoding = detectEncoding(filePath);
		String encoding1 = detectEncoding(filePath1);
		String encoding2 = detectEncoding(filePath2);
		System.out.println("File encoding: " + encoding);
		System.out.println("File encoding: " + encoding1);
		System.out.println("File encoding: " + encoding2);




		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(filePath), "GBK"));
		String tempString;
		while ((tempString = reader.readLine()) != null) {
            System.out.println(tempString);
		}

        BufferedReader reader1 = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath1), "UTF-8"));
        String tempString1;
        while ((tempString1 = reader1.readLine()) != null) {
            System.out.println(tempString1);
        }

        BufferedReader reader2 = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath2), "UTF-8"));
        String tempString2;
        while ((tempString2 = reader2.readLine()) != null) {
            System.out.println(tempString2);
        }

		String encoding_1 = detectEncoding1(filePath);
		String encoding_2 = detectEncoding1(filePath1);
		String encoding_3 = detectEncoding1(filePath2);
		System.out.println("File encoding: " + encoding_1);
		System.out.println("File encoding: " + encoding_2);
		System.out.println("File encoding: " + encoding_3);

	}



}
