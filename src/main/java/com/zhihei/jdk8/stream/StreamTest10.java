package com.zhihei.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZKY
 * @createTime 2019/7/8 23:05
 * @description
 */

public class StreamTest10
{
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        //打印第一个长度为5的字符串
        //映射为长度
        //        list.stream().mapToInt(item -> item.length()).filter(length -> length == 5)
        //                .findFirst().ifPresent(System.out::println);

        list.stream().mapToInt(item -> {
            int length = item.length();
            System.out.println(item); //返回hello
            return length;
        }).filter(length -> length == 1).findFirst().ifPresent(System.out::println);//5

        // length == 1 hello world hello world
        //l ength == 5 hello   5
    }
}
