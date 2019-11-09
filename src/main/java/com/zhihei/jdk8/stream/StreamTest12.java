package com.zhihei.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ZKY
 * @createTime 2019/7/11 19:40
 * @description
 */

public class StreamTest12
{

    public static void main(String[] args)
    {
        List<String> list1 = Arrays.asList("hi", "hello", "你好");
        List<String> list2 = Arrays.asList("张三", "李四", "wangwu", "zhaoliu");

        //要求输出 flatmap返回的是Stream<Stream<String>>
        list1.stream().flatMap(item -> list2.stream().map(item2 -> item + ":" + item2)).forEach(System.out::println);
    }
}
