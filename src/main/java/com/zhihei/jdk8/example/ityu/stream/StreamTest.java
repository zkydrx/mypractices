package com.zhihei.jdk8.example.ityu.stream;

import com.zhihei.jdk8.example.ityu.methodReference.moudle.Person1;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-16 Time: 14:53:45
 * Description: 流是数据渠道，用于操作数据源（集合、数组等）生成的元素序列。 Stream（流）是一个来自数据源的元素队列
 * 1.元素是特定类型的对象，形成一个队列。 2.数据源流的来源。可以是集合，数组等。 3.Stream自己不会存储元素，而是按需计算。
 * 4.Stream不会改变源对象，并且能返回一个持有结果的新流 5.Stream操作是延迟操作，意味着他们会等到需要结果的时候才执行
 * 和以前的Collection操作不同， Stream操作还有两个基础的特征： a.Pipelining:
 * 中间操作都会返回流对象本身。这样多个操作可以串联成一个管道， 如同流式风格（fluentstyle）。这样做可以对操作进行优化，
 * 比如延迟执行(laziness)和短路( short-circuiting)。 b.内部迭代：以前对集合遍历都是通过Iterator或者增强for的方式,
 * 显式的在集合外部进行迭代， 这叫做外部迭代。Stream提供了内部迭代的方式， 流可以直接调用遍历方法。
 * <p>
 * Stream操作的三个步骤： 创建Stream：一个数据源（如集合、数组），获取一个流 中间操作：一个操作链，对数据源的数据进行处理
 * 终止操作：一个终止操作，执行中间操作链并产生结果
 * <p>
 * 注意：“Stream流”其实是一个集合元素的函数模型，它并不是集合，也不是数据结构， 其本身并不存储任何元素（或其地址值）。
 */
public class StreamTest {
	@Test
	public void testList() {
		List<String> list = new ArrayList<>();
		list.add("陈伟霆");
		list.add("陈磊");
		list.add("陈三炮");
		list.add("陈四");
		list.add("陈五");
		list.add("Linux");
		list.add("Apple");
		/**
		 * 筛选陈开头，名字是三个字的
		 */
		List<String> chenList = new ArrayList<>();
		for (String s : list) {
			if (s.startsWith("陈") && s.length() == 3) {
				chenList.add(s);
			}
		}

		/**
		 * 遍历输出符合条件的
		 */
		for (String s : chenList) {
			System.out.println(s);
		}
		System.out.println("==================");
		/**
		 * 使用stream流操作
		 */
		System.out.println("使用stream操作:");
		list.stream().filter(e -> e.startsWith("陈")).filter(e -> e.length() == 3).forEach(System.out::println);

	}

	/**
	 * 4.1 获取流 java.util.stream.Stream<T>是Java8新加入的常用的流接口。（不是函数式接口） 获取一个流有以下几种常用的方式：
	 * ①根据Collection获取流 java.util.Collection接口中加入了default方法 stream
	 * 用来获取流，所以其所有实现类均可获取流。
	 * <p>
	 * stream()：获取串行流
	 * <p>
	 * parallelStream()：获取并行流
	 */
	@Test
	public void testGetStream() {
		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream();
		Set<Integer> set = new HashSet<>();
		Stream<Integer> stream1 = set.stream();
		Vector<Double> vector = new Vector<>();
		Stream<Double> stream2 = vector.stream();

		/**
		 * ②根据Map获取流 java.util.Map 接口不是Collection的子接口，且其K-V数据结构不符合流元素的单一特征，
		 * 所以获取对应的流需要分key、value或entry等情况：
		 */
		Map<String, String> map = new HashMap<>();
		Stream<Map.Entry<String, String>> stream3 = map.entrySet().stream();
		Stream<String> stream4 = map.keySet().stream();
		Stream<String> stream5 = map.values().stream();

		/**
		 * ③根据数组获取流 如果使用的不是集合或映射而是数组，由于数组对象不可能添加默认方法， 所以 Stream 接口中提供了静态方法of ：
		 */
		String[] array = {"A", "B", "C", "D"};
		Stream<String> array1 = Stream.of(array);

		/**
		 * ④获取无限流
		 */

		Stream<Integer> iterate = Stream.iterate(0, e -> e + 2);
		Stream<Double> generate = Stream.generate(Math::random);

		/**
		 * 注意：of 方法的参数是一个可变参数，所以支持数组。
		 *
		 * 总结：
		 *
		 * 所有的 Collection 集合都可以通过stream默认方法获取流；
		 *
		 * Stream 接口的静态方法of可以获取数组对应的流
		 */

	}

	/**
	 * 4. 2 流常用方法 方法可以被分成两种： 延迟方法：返回值类型仍然是 Stream 接口自身类型的方法，因此支持链式调用。
	 * （除了终结方法外，其余方法均为延迟方法。） 终结方法：返回值类型不再是 Stream接口自身类型的方法， 因此不再支持类似 StringBuilder
	 * 那样的链式调用。终结方法包括 count 和 forEach 方法。
	 */

	@Test
	public void testMethods() {
		/**
		 * ①逐一处理：forEach
		 *
		 * 1void forEach(Consumer<? super T> action);
		 * 该方法接收一个Consumer接口函数，会将每一个流元素交给该函数进行处理。 Consumer是一个消费型的函数式接口，可传递lambda表达式，消费数据
		 */
		System.out.println("1.测试forEach");
		Stream.of("A", "B", "C").forEach(e -> System.out.print(e + " "));

		/**
		 * ②过滤：filter 可以通过 filter 方法将一个流转换成另一个子集流。方法签名：
		 *
		 * 1Stream<T> filter(Predicate<? super T> predicate); 该接口接收一个Predicate
		 * 函数式接口参数（可以是一个Lambda或方法引用）作为筛选条件。
		 *
		 * java.util.stream.Predicate函数式接口唯一的抽象方法为: boolean test(T t);
		 * 该方法将会产生一个boolean值结果，代表指定的条件是否满足： 如果结果为true，那么Stream流的filter方法将会留用元素；
		 * 如果结果为false，那么filter 方法将会舍弃元素。
		 *
		 * 注意：Stream属于管道流，只能被消费一次 Stream流调用完毕方法，数据就回流到下一个Steam上，
		 * 而这时第一个Stream流已经使用完毕，就会关闭了， 所以第一个Stream流就不能再调用方法了。
		 */
		Stream<String> zky = Stream.of("zky", "zki", "zli");

		Stream<String> z = zky.filter(item -> item.startsWith("z"));
		System.out.println("\n2.测试filter");
		z.forEach(e -> System.out.print(e + " "));

		/**
		 * ③映射：map 接收lambda，将元素转换成其他形式或提取信息，接收一个函数作为参数，该函数会被应用到每个元素上，
		 * 并将其映射成一个新的元素。即将流中的元素映射到另一个流中。 方法签名：
		 *
		 * 1<R> Stream<R> map(Function<? super T, ? extends R> mapper); 该接口需要一个 Function
		 * 函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流。 java.util.stream.Function
		 * 函数式接口，其中唯一的抽象方法为：R apply(T t); 这可以将一种T类型转换成为R类型，而这种转换的动作，就称为“映射”。
		 */
		Stream<String> stringStream = Stream.of("1", "23", "34", "45");
		Stream<Integer> integerStream = stringStream.map(item -> Integer.parseInt(item));
		System.out.println("\n3.测试map映射");
		integerStream.forEach(e -> System.out.print(e + " "));

		Person1 person1 = new Person1("A", 29);
		Person1 person2 = new Person1("B", 20);
		Person1 person3 = new Person1("C", 21);

		List<Person1> list = new ArrayList<>();
		list.add(person1);
		list.add(person2);
		list.add(person3);
		list.stream().map(Person1::getName).forEach(item -> System.out.print(item + " "));

		/**
		 * ④flatMap 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
		 * 即对流扁平化处理,浅显一点解释就是把几个小的list转换到一个大的list 如：[['a','b'],['c','d']] - >
		 * ['a','b','c','d'] 如果我们使用常用的map()方法获取的lowercaseWords数据结构为：
		 * [['a','b','c'],['m','d','w'],['k','e','t']]。
		 * 如果我们要得到如：['a','b','c','m','d','w','k','e','t']这样数据结构的数据， 就需要使用flatMap()方法。
		 */
		System.out.println("\n4测试flatMap");
		List<String> list1 = Arrays.asList("A", "B", "c", "E", "f");
		Stream<Stream<Character>> streamStream = list1.stream().map(StreamTest::filterCharacter);
		streamStream.forEach((s) -> s.forEach(item -> System.out.print(item + " ")));
		/**
		 * 使用flatMap
		 */
		Stream<Character> characterStream = list1.stream().flatMap(StreamTest::filterCharacter);

		characterStream.forEach(item -> System.out.print(item + " "));

		/**
		 * ⑤规约reduce 将流中元素反复结合起来，得到一个值
		 */
		System.out.println("\n5.测试reduce");
		sum(1, 2, 3, 4, 5);
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		Integer reduce = integers.stream().reduce(0, (e1, e2) -> e1 + e2);
		System.out.println("和是: " + reduce);

		/**
		 * ⑥统计个数：count 终结方法 流提供 count方法来数一数其中的元素个数 该方法返回一个long值代表元素个数：
		 */
		System.out.println("6.测试Count统计个数");
		List<String> list2 = Arrays.asList("1,", "2", "3", "4");

		Stream<String> stream = list2.stream();

		long count = stream.count();
		System.out.println("数组中元素的个数是:" + count);

		/**
		 * ⑦取用前几个：limit limit 方法可以对流进行截取，只取用前n个。方法签名：
		 *
		 * 1Stream<T> limit(long maxSize); 参数是一个 long型，如果集合当前长度大于参数则进行截取；否则不进行操作
		 * 延迟方法，只是对流中的元素进行截取，返回的是一个新的流，还可以继续调用Stream中的其他方法
		 */
		String[] str = {"1", "2", "4", "6", "3"};
		Stream<String> str1 = Stream.of(str);
		Stream<String> limit = str1.limit(3);
		System.out.println("\n7.测试limt");
		limit.forEach(e -> System.out.print(e + " "));

		/**
		 * ⑧跳过前几个：skip 如果希望跳过前几个元素，可以使用skip方法获取一个截取之后的新流：
		 *
		 * 1Stream<T> skip(long n); 如果流的当前长度大于n，则跳过前n个；否则将会得到一个长度为0的空流
		 */
		System.out.println("\n8.测试skip");
		String[] strings = {"1", "2", "3", "4", "5"};
		Stream<String> strings1 = Stream.of(strings);
		Stream<String> skip = strings1.skip(3);
		skip.forEach(e -> System.out.print(e + " "));

		/**
		 * ⑨组合：concat 如果有两个流，希望合并成为一个流，那么可以使用 Stream 接口的静态方法 concat
		 *
		 * 1static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b) 2
		 * 注意：这是一个静态方法，与 java.lang.String 当中的 concat 方法不同
		 */
		Stream<String> a = Stream.of("A", "B", "C");

		String[] strings2 = {"1", "2", "3"};
		Stream<String> strings21 = Stream.of(strings2);
		System.out.println("\n9.测试concat");
		Stream<String> concat = Stream.concat(a, strings21);
		concat.forEach(item -> System.out.print(item + " "));

		/**
		 * ⑩排序：sorted sorted() 自然排序 sorted(Comparator com) 定制排序 allMatch 检查是否匹配所有元素
		 * anyMatch 检查是否至少匹配一个元素 noneMatch 检查是否没有匹配所有元素 findFirst 返回第一个元素 findAny
		 * 返回当前流中的任意元素 count 返回流中元素的总个数 max 返回流中最大值 min 返回流中最小值
		 */
		List<String> list3 = Arrays.asList("n", "a", "e", "f", "d");

		Stream<String> sorted = list3.stream().sorted();

		System.out.println("\n10.测试sorted");
		System.out.println("正序排列");
		sorted.forEach(item -> System.out.print(item + " "));
		System.out.println("\n逆序排列");
		Stream<String> sorted1 = list3.stream().sorted((e1, e2) -> e2.compareToIgnoreCase(e1));

		sorted1.forEach(item -> System.out.print(item + " "));

		/**
		 * ⑪Collect 将流转换为其他形式。接收一个Collector的实现，用于给stream中元素做汇总的方法
		 */
		System.out.println("\n11.测试Collect");
		Stream<Integer> integerStream1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);

		List<Integer> collect = integerStream1.collect(Collectors.toList());

		LinkedList<Integer> collect1 = Stream.of(1, 2, 3, 4, 5, 6).collect(LinkedList::new, List::add, List::addAll);
		collect.forEach(item -> System.out.print(item + " "));
		System.out.println();
		collect1.forEach(item -> System.out.print(item + " "));

		Person1 person11 = new Person1("z", 11);
		Person1 person12 = new Person1("k", 12);
		Person1 person13 = new Person1("y", 13);
		List<Person1> list4 = Arrays.asList(person11, person12, person13);
		System.out.println();
		List<String> collect2 = list4.stream().map(Person1::getName).collect(Collectors.toList());

		collect2.forEach(item -> System.out.print(item + " "));

	}

	/**
	 * 是从Java 5开始，Java语言对方法参数支持一种新写法，叫可变长度参数列表，
	 * 其语法就是类型后跟...，表示此处接受的参数为0到多个Object类型的对象， 或者是一个Object[]。
	 * 例如我们有一个方法叫做test(String...strings)， 那么你还可以写方法test()，但你不能写test(String[]
	 * strings)，这样会出编译错误，系统提示出现重复的方法。
	 *
	 * @param nums
	 */
	public static void sum(Integer... nums) {
		Stream.of(nums).reduce(Integer::sum).ifPresent(System.out::println);
	}

	public static Stream<Character> filterCharacter(String str) {
		List<Character> list = new ArrayList<>();
		for (char c : str.toCharArray()) {
			list.add(c);
		}
		return list.stream();
	}

	@Test
	public void testSum() {
		sum(1, 2, 3, 4, 5);
	}

}
