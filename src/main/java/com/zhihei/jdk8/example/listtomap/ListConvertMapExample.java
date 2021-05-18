package com.zhihei.jdk8.example.listtomap;

import com.zhihei.jdk8.example.moudle.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-11-10
 * Time: 10:42:04
 * Description:
 */
public class ListConvertMapExample
{
    private static List<Person> list = new ArrayList<>();

    static
    {
        list.add(Person.builder().id("1").name("Apple").address("HangZhou").build());
        list.add(Person.builder().id("2").name("Microsoft").address("ShuZhou").build());
        list.add(Person.builder().id("3").name("Amazon").address("ShangHai").build());
        list.add(Person.builder().id("4").name("Google").address("ShenZhen").build());
        list.add(Person.builder().id("5").name("Facebook").address("WuZhen").build());
    }

    public static void main(String[] args)
    {
        System.out.println("打印一下集合:");
        list.stream().forEach(System.out::println);
        System.out.println("Java8 List转Map:");
        Map<String, Person> collect = list.stream().collect(Collectors.toMap((key -> key.getId()), (value -> value)));
        collect.forEach((k, v) -> System.out.println(k + "::" + v));

        System.out.println("Java8 List转Map 之方法二:");
        Map<String, Person> collect1 = list.stream().collect(Collectors.toMap(Person::getId, Person::getData));
        collect1.forEach((k, v) -> System.out.println(k + "::" + v));

    }
}
