package com.zhihei.arithmetic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-14
 * Time: 12:27:44
 * Description:
 * 找出一个数组中重复次数最多的数字
 */
public class CountTheMaxRepeatNumInArray
{
    public static void main(String[] args)
    {
        List<Integer> integers = Arrays.asList(1, 2, 3, 3, 4, 4);
        /**
         * 方法一，二，三均基于jdk8特性实现
         * 找出数组中重复次数最大的数方法一
         * 缺点：如果重复次数最大的元素大于等于两个则无法全部找出
         */
        Integer key1 = integers.stream()
                               .collect(Collectors.groupingBy(k -> k, Collectors.counting()))
                               .entrySet()
                               .stream()
                               .max((e1, e2) -> (int) (e1.getValue() - e2.getValue()))
                               .get()
                               .getKey();

        System.out.println("方法一数组中出现次数最大的数是: " + key1);

        /**
         * 找出数组中重复次数最大的数方法二
         * 缺点：如果重复次数最大的元素大于等于两个则无法全部找出
         */
        integers.stream()
                .collect(Collectors.groupingBy(k -> k, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> (int) (e2.getValue() - e1.getValue()))
                .limit(1)
                .forEach(e -> System.out.println("方法二数组中出现次数最大的数是: " + e.getKey()));

        /**
         * 找出数组中重复次数最大的数方法三
         * 解决重复次数最多的元素大于一个的情况
         * example:{1,2,3,2,3,4} ==> {2,3}
         *
         * 1. 首先拿到最大的重复次数n
         */
        Long value = integers.stream()
                             .collect(Collectors.groupingBy(k -> k, Collectors.counting()))
                             .entrySet()
                             .stream()
                             .max((e1, e2) -> (int) (e1.getValue() - e2.getValue()))
                             .get()
                             .getValue();

        /**
         * 2. 过滤出符合次数n的元素得到一个列表
         */
        integers.stream()
                .collect(Collectors.groupingBy(k -> k, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == value)
                .collect(Collectors.toList())
                .forEach(e -> System.out.println("方法三重复次数最大的元素是: " + e.getKey() + " 重复的次数是: " + e.getValue()));

        /**
         * 方法四基于jdk7实现
         * 注：与方法三一样可以找到所有的重复次数最大的元素
         */
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer integer : integers)
        {
            if (hashMap.containsKey(integer))
            {
                hashMap.put(integer, hashMap.get(integer) + 1);
            }
            else
            {
                hashMap.put(integer, 1);
            }
        }
        Collection<Integer> values = hashMap.values();

        Integer max = Collections.max(values);

        for (Map.Entry<Integer, Integer> integerIntegerEntry : hashMap.entrySet())
        {
            if (integerIntegerEntry.getValue() == max)
            {
                System.out.println("方法四重复次数最大的元素是: " + integerIntegerEntry.getKey() + " 重复的次数是: " + integerIntegerEntry.getValue());
            }
            else
            {
                continue;
            }
        }
        /**
         * 打印出每个数字重复出现的次数
         */
        integers.stream()
                .collect(Collectors.groupingBy(k -> k, Collectors.counting()))
                .entrySet()
                .forEach(item -> System.out.println("元素: " + item.getKey() + " ==>出现的次数是：" + item.getValue()));

        /**
         * 列表中找到各个元素重复的次数。
         */
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        Integer key = list.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting())).entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();

        System.out.println(key);
    }
}
