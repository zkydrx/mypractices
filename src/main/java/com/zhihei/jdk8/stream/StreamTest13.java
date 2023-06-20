package com.zhihei.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ZKY
 * @createTime 2019/7/11 20:04
 * @description stream分组
 */

public class StreamTest13 {
	public static void main(String[] args) {
		Student student1 = new Student("zhangsan", 112, 20);
		Student student2 = new Student("lisi", 93, 20);
		Student student3 = new Student("wangwu", 97, 30);
		Student student4 = new Student("zhangsan", 51, 40);
		Student student5 = new Student("zhangsan", 57, 40);

		List<Student> list = Arrays.asList(student1, student2, student3, student4, student5);

		// 2个zhangsan 分组 select * from student group by name;

		// 传统流程
		// 1.循环列表 2.取出学生名字 3 检查map中是否存在该名字，
		// 不存在则添加学生到该map中 存在则list中add 新的学生对象
		// 4.返回map对象

		Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getName));
		System.out.println(map);

		System.out.println("-----");

		Map<Integer, List<Student>> map1 = list.stream().collect(Collectors.groupingBy(Student::getAge));
		System.out.println(map1);

		System.out.println("-----");

		// 需求 select name count(*) from student group by name;

		Map<String, Long> map2 = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));

		System.out.println(map2);

		// 需求 select name avg(score) from student;
		// 返回的是Double类型
		Map<String, Double> map3 = list.stream()
				.collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));

		System.out.println(map3);

		// partition by 只有true和false 分区

		Map<Boolean, List<Student>> map4 = list.stream()
				.collect(Collectors.partitioningBy(student -> student.getScore() >= 90));

		System.out.println(map4);

		System.out.println("-----");
	}
}
