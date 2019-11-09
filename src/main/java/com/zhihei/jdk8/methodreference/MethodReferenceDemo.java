package com.zhihei.jdk8.methodreference;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZKY
 * @createTime 2019/7/6 12:30
 * @description
 */

public class MethodReferenceDemo
{
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("hello", "world", "hello world");

        //lambda表达式
        //list.forEach(item -> System.out.println(item));

        //方法引用
        list.forEach(System.out::println);
    }
}
