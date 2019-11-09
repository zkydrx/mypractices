package com.zhihei.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZKY
 * @createTime 2019/7/8 23:20
 * @description
 */

public class SteamTest11
{

    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world hello", "hello welcome");

        //所有单词去重
        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
        //重点flatMap(Arrays::stream)打平
    }
}
