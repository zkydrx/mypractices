package com.tuku.spider.test.bing;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2020-06-01
 * Time: 16:20:44
 * Description:
 */
@Slf4j
public class BingImages
{

    public static void main(String[] args) throws IOException
    {
        String url = "https://bing.ioliu.cn/";
        List<String> urlList = getStrings(url);
        log.info("拼装所有的链接完成:");
        List<String> imageUrl = new ArrayList<>();
        BufferedOutputStream bufferedOutputStream = null;
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        for (String s : urlList)
        {
            getImageUrls(url, imageUrl, s);
        }
        File file = new File("E:\\documents\\images\\bing");
        if (!file.isDirectory() && !file.exists())
        {
            file.mkdirs();
        }
        /**
         * 生成一个唯一的标记来当作图片名称
         */
        String uuid = null;
        URL url1 = null;
        for (String s : imageUrl)
        {
            try
            {
                uuid = UUID.randomUUID().toString().replaceAll("-", "");
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file + "\\" + uuid + ".jpg"));
                url1 = new URL(s);
                urlConnection = (HttpURLConnection) url1.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.addRequestProperty("User-Agent", "Mozilla/4.76");
                urlConnection.connect();
                inputStream = urlConnection.getInputStream();
                byte[] bytes = new byte[1024];
                int hasRead = 0;
                while ((hasRead = inputStream.read(bytes)) > 0)
                {
                    bufferedOutputStream.write(bytes, 0, hasRead);
                    Thread.sleep(3000);
                }
                bufferedOutputStream.flush();
                log.info("图片：【" + s + "】下载完成");
                inputStream.close();
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        bufferedOutputStream.close();

    }

    private static void getImageUrls(String url, List<String> imageUrl, String s)
    {
        Document doc = null;
        try
        {
            doc = Jsoup.connect(s)
                       .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36")
                       .timeout(6000000)
                       .get();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Element container = doc.getElementsByClass("container").get(1);
        Elements elements = container.getElementsByClass("item");
        for (Element element : elements)
        {
            String text = url + element.getElementsByTag("a").get(0).attr("href");
            imageUrl.add(text);
        }
    }

    private static List<String> getStrings(String url)
    {
        String params = "ranking?p=";
        Integer totalPage = 2;
        List<String> urlList = new ArrayList<>();
        /**
         * 获取所有请求链接
         */
        for (int i = 1; i < totalPage; i++)
        {
            urlList.add(url + params + i);
        }
        return urlList;
    }
}
