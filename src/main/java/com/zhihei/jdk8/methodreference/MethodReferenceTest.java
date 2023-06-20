package com.zhihei.jdk8.methodreference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author ZKY
 * @createTime 2019/7/6 12:47
 * @description
 */

public class MethodReferenceTest {

	public String getString(Supplier<String> supplier) {
		return supplier.get() + "test";
	}

	public String getString2(String str, Function<String, String> function) {
		return function.apply(str);
	}

	public static void main(String[] args) {
		Student student1 = new Student("zhangsan", 10);
		Student student2 = new Student("lisi", 90);
		Student student3 = new Student("wangwu", 50);
		Student student4 = new Student("zhaoliu", 40);

		List<Student> list = Arrays.asList(student1, student2, student3, student4);

		// 1.类型::静态方法名
		// lambda 排序
		list.sort((s1, s2) -> Student.compareStudentByScore(s1, s2));
		list.forEach(s -> System.out.println(s.getScore()));

		System.out.println("1-----------");
		// 方法引用
		list.sort(Student::compareStudentByScore);// 这里没带参数，编译器自动推断出
		// list.forEach(System.out::println);//这里为什么只打印student对象的引用 怎么打印里面的属性
		list.forEach(s -> System.out.println(s.getScore()));

		System.out.println("2-----------");

		// 方法引用
		list.sort(Student::compareStudentByName);
		list.forEach(s -> System.out.println(s.getName()));
		System.out.println("3-----------");

		// 2引用名（对象名）::实例方法名

		StudentComparator studentComparator = new StudentComparator();

		list.sort(studentComparator::comparatorStudentByScore);
		list.forEach(s -> System.out.println(s.getScore()));

		System.out.println("4-----------");

		list.sort(studentComparator::comparatorStudentByName);
		list.forEach(s -> System.out.println(s.getName()));

		System.out.println("5-----------");

		list.sort(Student::compareByScore);
		list.forEach(s -> System.out.println(s.getScore()));

		List<String> cities = Arrays.asList("qingdao", "chongqing", "tianjing", "bejjing");
		// 需求 正序输出

		// Collections.sort(cities,(city1,city2)->city1.compareToIgnoreCase(city2));
		Collections.sort(cities, String::compareToIgnoreCase);
		cities.forEach(System.out::println);// 2.引用名（对象名）::实例方法名

		MethodReferenceTest methodReferenceTest = new MethodReferenceTest();
		System.out.println(methodReferenceTest.getString(String::new));

		System.out.println(methodReferenceTest.getString2("hello", String::new));

	}
}
