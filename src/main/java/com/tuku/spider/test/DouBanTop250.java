package com.tuku.spider.test;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2020-06-01
 * Time: 00:58:53
 * Description:
 */
@Slf4j
public class DouBanTop250
{
    public static void main(String[] args) throws IOException
    {
        String s1 = "https://movie.douban.com/top250?start=";
        String s2 = "&filter=";
        String link;   // 电影的链接
        // 电影名称
        String title;
        // 电影评分
        String score;
        // 获取评价人数
        String num;
        String quoteStr = "";
        // 存储待爬取的网址url链接
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <= 225; i += 25)
        {
            list.add(s1 + i + s2);
        }
        // 遍历url集合 爬取网页数据
        for (String string : list)
        {
            Document doc = Jsoup.connect(string).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:60.0) Gecko/20100101 Firefox/60.0").timeout(6000).get();
            Element content = doc.getElementById("content");
            Elements infos = content.getElementsByClass("info");
            for (Element element : infos)
            {
                Element links = element.getElementsByTag("a").get(0);
                Element star = element.getElementsByClass("star").get(0);
                Elements quotes = element.getElementsByClass("quote");
                if (quotes.size() > 0)
                {
                    // 获取短评内容
                    quoteStr = quotes.get(0).child(0).html();

                }
                else
                {
                    quoteStr = "";
                }
                // 获取电影的链接
                link = links.attr("href");
                /* 获取电影名称 */
                title = links.child(0).html();
                // 获取电影评分
                score = star.child(1).html();
                num = star.child(3).html();
                System.out.println(link + "\t" + title + "\t评分" + score + "\t" + num + "\t" + quoteStr);
            }
        }
    }
}


