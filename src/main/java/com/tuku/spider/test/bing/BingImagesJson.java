package com.tuku.spider.test.bing;

import HttpUtil.HttpUtilsJson;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2020-06-02 Time: 00:31:38
 * Description: 获取bing最新壁纸，并保存到本地
 */
public class BingImagesJson {
	private static String jsonUrlApi = "http://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1";
	/**
	 * bing前缀链接，可与httpurl2互换。
	 */
	private static String httpurl1 = "https://www.bing.com/";
	/**
	 * bing前缀链接，可与httpurl1互换。
	 */
	private static String httpurl2 = "http://s.cn.bing.net";

	public static void main(String[] args) {
		String s = null;
		try {
			s = HttpUtilsJson.doGet(jsonUrlApi, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject jsonObject = JSON.parseObject(s);
		JSONArray jsonArray = jsonObject.getJSONArray("images");

		String imgUrl = jsonArray.getJSONObject(0).getString("url");
		String fullImageUrl = httpurl2 + imgUrl;

		File file = new File("E:\\documents\\images\\bing");
		if (!file.isDirectory() && !file.exists()) {
			file.mkdirs();
		}

		String uuid = UUID.randomUUID().toString().replaceAll("-", "");

		try {
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
					new FileOutputStream(file + "\\" + uuid + ".jpg"));
			URL url = new URL(fullImageUrl);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.connect();
			InputStream inputStream = urlConnection.getInputStream();

			byte[] bytes = new byte[1024];
			int hasRead = 0;
			while ((hasRead = inputStream.read(bytes)) > 0) {
				bufferedOutputStream.write(bytes, 0, hasRead);
			}
			bufferedOutputStream.close();
			inputStream.close();
		} catch (FileNotFoundException | MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
