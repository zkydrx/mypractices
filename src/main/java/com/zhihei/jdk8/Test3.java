package com.zhihei.jdk8;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author ZKY
 * @createTime 2019/7/4 0:08
 * @description
 */

public class Test3
{
    public static void main(String[] args)
    {

        //根据TheInterface 上下文来断定
        TheInterface i1 = () -> {
        };
        System.out.println("i1接口：" + i1.getClass().getInterfaces()[0]);

        TheInterface2 i2 = () -> {
        };
        System.out.println("i1接口：" + i2.getClass().getInterfaces()[0]);

        //启动线程
        //        new Thread(() -> {
        //            System.out.println("hello world");
        //        }).start();


        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        //需求 转换为大写输出
        //        list.forEach(s -> {
        //            //System.out.println(s == null ? "" : s.toUpperCase());
        //            List<String> list2=new ArrayList<>();//jdk8省略 diamond 菱形语法
        //            list2.add(s == null ? "" : s.toUpperCase());
        //            list2.forEach(s2 -> {System.out.println("list2:"+s2);});
        //        });

        //采用流的方式stream()单线程 paralleStream并行流 多线程  映射
        //       list.stream().map(item ->item.toUpperCase()).forEach(item -> System.out.println(item));

        //方法引用方式
        //list.stream().map(String::toUpperCase).forEach(item -> System.out.println(item));

        Function<String, String> function = String::toUpperCase;

        System.out.println(function.getClass().getInterfaces()[0]);

    }
}

/**
 * 函数式接口
 */
@FunctionalInterface
interface TheInterface
{
    void myMrthod();
}

@FunctionalInterface
interface TheInterface2
{
    void myMrthod2();
}
