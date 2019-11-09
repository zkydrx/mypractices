package com.zhihei.jdk8.stream2;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;//静态导入方式

/**
 * @author ZKY
 * @createTime 2019/7/11 22:19
 * @description
 */

public class StreamTest1
{

    public static void main(String[] args)
    {
        Student student1 = new Student("zhangsan", 83);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("zwangwu", 100);
        Student student4 = new Student("zhaoliu", 90);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        List<Student> students1 = students.stream().collect(toList());

        students1.forEach(System.out::println);

        System.out.println("-----------------");

        //流的方式获取数量collect
        System.out.println("count:" + students.stream().collect(counting()));

        //流的方式获取数量stream
        System.out.println("count:" + students.stream().count());
    }
}
