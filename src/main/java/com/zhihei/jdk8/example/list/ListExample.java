package com.zhihei.jdk8.example.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-10
 * Time: 09:38:30
 * Description:
 */
public class ListExample
{
    private static ArrayList<String> list = new ArrayList<>();

    static
    {
        list.add("A");
        list.add("BC");
        list.add("D");
        list.add("BD");
        list.add("E");
    }

    public static void main(String[] args)
    {
        /**
         * java8以前的遍历集合
         */
        System.out.println("-----------------------java7的遍历集合-----------------------");
        for (String s : list)
        {
            System.out.print(s + " ");
        }
        System.out.println("\n-----------------------java8的遍历集合-----------------------");
        list.forEach(a -> System.out.print(a + " "));
        System.out.println("\n筛选出非字母C的元素，打印");
        list.forEach(item -> {
            if (!"C".equals(item))
            {
                System.out.print(item + " ");
            }
        });

        System.out.println("\n筛选出非字母C的元素，打印之方法二");
        list.stream().filter(a -> !a.equals("C")).collect(Collectors.toList()).forEach(item -> System.out.print(item + " "));

        System.out.println("\n找出包含B的字符串");
        list.stream().filter(item -> item.contains("B")).forEach(item -> {
            System.out.print(item + " ");
        });
        System.out.println("\n找出以D结束的字符串，并打印");
        list.stream().filter(item -> item.endsWith("D")).forEach(item -> System.out.print(item + " "));

        System.out.println("\n对所有的元素升序排序");
        list.stream().sorted().forEach(item -> System.out.print(item + " "));

        System.out.println("\n对所有的元素逆序排序方法一:");
        list.stream().sorted((e1, e2) -> e2.compareToIgnoreCase(e1)).forEach(item -> System.out.print(item + " "));
        System.out.println("\n对所有的元素逆序排序方法二:");
        list.sort((e1, e2) -> e2.compareToIgnoreCase(e1));
        list.forEach(item -> System.out.print(item + " "));
    }
}
