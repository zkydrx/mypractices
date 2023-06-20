package lambda.stream;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-09-03 Time: 02:46
 * Description:
 */
public class Domain {

	/**
	 * 构造流的几种常见方法
	 */
	@Test
	public void test1() {
		// 1. Individual values
		Stream stream = Stream.of("a", "b", "c");
		// 2. Arrays
		String[] strArray = new String[]{"a", "b", "c"};
		stream = Stream.of(strArray);
		stream = Arrays.stream(strArray);
		// 3. Collections
		List<String> list = Arrays.asList(strArray);
		stream = list.stream();
	}

	/**
	 * 数值流的构造
	 */
	@Test
	public void test2() {
		IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
		IntStream.range(1, 8).forEach(n -> System.out.print(n + " "));
		System.out.println();
		IntStream.rangeClosed(1, 10).forEach(n -> System.out.print(n + "\t"));
	}

	/**
	 * 流转换为其他的数据结构
	 */
	@Test
	public void test3() {
		Stream stream = Stream.of("a", "b", "c");

		// 1. Array
		String[] strArray1 = (String[]) stream.toArray(String[]::new);
		System.out.println(strArray1[0] + strArray1[1] + strArray1[2]);
		// 2. Collection
		List<String> list1 = (List<String>) stream.collect(Collectors.toList());
		List<String> list2 = (List<String>) stream.collect(Collectors.toCollection(ArrayList::new));
		List<String> collect = (List<String>) stream.collect(Collectors.toSet());
		List<String> collect1 = (List<String>) stream.collect(Collectors.toCollection(Stack::new));
		// 3.String
		String str = stream.collect(Collectors.joining()).toString();
	}

	/**
	 * 转换大写
	 */
	@Test
	public void test4() {
		List<String> wordList = Arrays.asList("i", "love", "program", "java", "is", "a", "very", "good", "programing",
				"language");
		List<String> collect = wordList.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(collect);
	}

	/**
	 * 平方数
	 */
	@Test
	public void test5() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> collect = list.stream().map(n -> n * n).collect(Collectors.toList());
		System.out.println(collect);
	}

	/**
	 * 一对多
	 */
	@Test
	public void test6() {
		Stream<List<Integer>> inputStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
		Stream<Integer> outStream = inputStream.flatMap((childList) -> childList.stream());
		List<Integer> collect = outStream.collect(Collectors.toList());
		System.out.println(collect);
	}

	/**
	 * filter 留下偶数
	 */
	@Test
	public void test7() {
		Integer[] sixNums = {1, 2, 3, 4, 5, 6};
		Integer[] integers = Stream.of(sixNums).filter(n -> n % 2 == 0).toArray(Integer[]::new);
		System.out.println(Arrays.asList(integers));
	}

	/**
	 * filter 把单词挑出来
	 */
	@Test
	public void test8() throws FileNotFoundException {
		String str = "a b c d e f";
		BufferedReader reader = new BufferedReader(new FileReader(new File("src/lambda/stream/stream.md")));
		List<String> output = reader.lines().flatMap(line -> Stream.of(line.split(" ")))
				.filter(word -> word.length() > 0).collect(Collectors.toList());
		System.out.println(output);
	}

	/**
	 * forEach 打印姓名（forEach和pre-java8的对比)
	 */
	@Test
	public void test9() {

		List<Student> list = new ArrayList<>();
		list.add(new Student(1, 10, "蟠桃盛会", "hangzhou"));
		list.add(new Student(2, 10, "binjiang", "hangzhou"));
		list.stream().filter(p -> p.getAge() > 2).forEach(s -> System.out.println(s.getName()));
	}

	/**
	 * peek对每个元素执行操作并返回一个新的stream。
	 */
	@Test
	public void test10() {
		List<String> collect = Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
				.peek(e -> System.out.println("Filtered value:" + e)).map(String::toUpperCase)
				.peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());
		System.out.println(collect);
	}

	/**
	 * findFirst optional 的两个用例
	 */
	@Test
	public void test11() {
		String strA = " abcd ";
		String StrB = null;
		// System.out.print(strA);
		// System.out.print("");
		// System.out.print(StrB);
		// Array.getLength(strA);
		// Array.getLength("");
		// Array.getLength(StrB);
		print(strA);
		print("");
		print(StrB);
		getLength(strA);
		getLength("");
		getLength(StrB);

	}

	public static void print(String text) {
		// Java8
		Optional.ofNullable(text).ifPresent(System.out::println);

		// Pre - Java 8
		if (text != null) {
			System.out.println(text);
		}
	}

	public static int getLength(String text) {
		// Java 8
		return Optional.ofNullable(text).map(String::length).orElse(-1);

		// Pre-Java 8
		// return text != null? text.length():-1;
	}

	/**
	 * reduce 的用例
	 */
	@Test
	public void test12() {
		// 字符串连接，concat = "ABCD"
		String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
		System.out.println("concat: " + concat);
		// 求最小值，minValue = -3.0,注意数值格式一定正确。
		double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
		System.out.println("minValue: " + minValue);
		// 求和，sumValue=10,有起始值
		int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
		System.out.println("有起始值sumValue: " + sumValue);
		// 求和，sumValue = 10,无起始值
		sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
		System.out.println("无起始值sumValue：" + sumValue);
		// 过滤，字符串连接，concat = "ace"
		concat = Stream.of("a", "B", "c", "D", "e", "F").filter(x -> x.compareTo("Z") > 0).reduce("", String::concat);
		System.out.println("concat: " + concat);
	}

	/**
	 * limit/skip limit 和skip对运行次数的影响
	 */
	@Test
	public void test13() {
		List<Student> students = new ArrayList<>();
		for (int i = 1; i < 10000; i++) {
			Student student = new Student(1, 27, "zky", "hangzhou");
			students.add(student);
		}

		List<String> collect = students.stream().map(Student::getName).limit(10).skip(3).collect(Collectors.toList());
		System.out.println(collect);
	}

	/**
	 * limit和skip对sorted后的运行次数无影响。
	 */
	@Test
	public void test14() {
		List<Student> students = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			Student student = new Student(1, i, "name" + i, "hangzhou");
			students.add(student);
		}
		List<Student> studentList = students.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).limit(2)
				.collect(Collectors.toList());
		System.out.println(studentList);
	}

	/**
	 * 排序前进行limit和skip
	 */
	@Test
	public void test15() {
		List<Student> students = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			Student student = new Student(i, i, "name" + i, "hangzhou");
			students.add(student);
		}
		List<Student> collect = students.stream().limit(2).sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
				.collect(Collectors.toList());
		System.out.println(collect);
	}

	/**
	 * min/max/distinct 找出最长一行的长度
	 */
	@Test
	public void test16() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("README.md")));
		int asInt = bufferedReader.lines().mapToInt(String::length).max().getAsInt();
		bufferedReader.close();
		System.out.println(asInt);
	}

	/**
	 * 找出全文中的单词，转小写，并排序
	 */
	@Test
	public void test17() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("D:\\project\\java\\idea\\github"
				+ "\\myPractices\\mypractices\\src\\lambda\\stream\\stream" + ".md")));
		List<String> collect = bufferedReader.lines().flatMap(line -> Stream.of(line.split(" ")))
				.filter((word -> word.length() > 0)).map(String::toLowerCase).distinct().sorted()
				.collect(Collectors.toList());
		bufferedReader.close();
		System.out.println(collect);
	}

	/**
	 * 使用Match
	 */
	@Test
	public void test18() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, 1, "name" + 1, "q"));
		students.add(new Student(2, 4, "name" + 2, "b"));
		students.add(new Student(3, 9, "name" + 3, "c"));
		students.add(new Student(4, 16, "name" + 4, "d"));
		students.add(new Student(5, 25, "name" + 5, "e"));
		boolean b = students.stream().allMatch(p -> p.getAge() > 18);
		System.out.println("All are adult? " + b);
		boolean b1 = students.stream().anyMatch(p -> p.getAge() < 12);
		System.out.println("Any child? " + b1);
	}

	/**
	 * 进阶：生成流 Stream.generate 生成10个随机数
	 */
	@Test
	public void test19() {
		Random seed = new Random();
		Supplier<Integer> random = seed::nextInt;
		Stream.generate(random).limit(10).forEach(System.out::println);

		// Another way
		IntStream.generate(() -> (int) (System.nanoTime() % 100)).limit(10).forEach(System.out::println);
	}

	/**
	 * 自实现Supplier
	 */
	@Test
	public void test20() {
		Stream.generate(new StudentSupplier()).limit(10)
				.forEach(p -> System.out.println(p.getName() + "," + p.getAge()));
	}

	private class StudentSupplier implements Supplier<Student> {

		private int index = 10;
		private Random random = new Random();

		@Override
		public Student get() {
			return new Student(index++, random.nextInt(100), "StormTestUser" + index, "hz");
		}
	}

	/**
	 * 生成一个等差数列
	 */
	@Test
	public void test21() {
		Stream.iterate(0, n -> n + 12).limit(100).forEach(x -> System.out.print(x + "\t"));
	}

	/**
	 * 按照年龄归组
	 */
	@Test
	public void test22() {
		Map<Integer, List<Student>> studentGroup = Stream.generate(new StudentSupplier()).limit(100)
				.collect(Collectors.groupingBy(Student::getAge));
		Iterator iterator = studentGroup.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, List<Student>> students = (Map.Entry) iterator.next();
			System.out.println("Age " + students.getKey() + " = " + students.getValue().size());
		}
	}

	/**
	 * 按照 未成年人和成年人归组
	 */
	@Test
	public void test23() {
		Map<Boolean, List<Student>> child = Stream.generate(new StudentSupplier()).limit(100)
				.collect(Collectors.groupingBy(p -> p.getAge() < 18));

		System.out.println("Children number: " + child.get(true).size());
		System.out.println("Adult number:" + child.get(false).size());
	}
}
