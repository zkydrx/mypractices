package com.zhihei.jdk8.example.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-10 Time: 15:27:17
 * Description: reduce是很重要的一种变成思想。这里重点介绍一下。reduce的作用是把stream中的元素给组合起来。至于怎么组合起来：
 * <p>
 * 它需要我们首先提供一个起始种子，然后依照某种运算规则使其与stream的第一个元素发生关系产生一个新的种子，
 * 这个新的种子再紧接着与stream的第二个元素发生关系产生又一个新的种子，就这样依次递归执行，
 * 最后产生的结果就是reduce的最终产出，这就是reduce的算法最通俗的描述；
 * 所以运用reduce我们可以做sum,min,max,average,所以这些我们称之为针对具体应用场景的reduce，
 * 这些常用的reduce，stream api已经为我们封装了对应的方法。 注 : map 和 reduce 的连接通常称为 map-reduce 模式，因
 * Google 用它来进行网络搜索而出名
 * <p>
 * <p>
 * <p>
 * <p>
 * 重点说说三个参数的Reduce 三个参数时是最难以理解的。 分析下它的三个参数： identity:
 * 一个初始化的值；这个初始化的值其类型是泛型U，与Reduce方法返回的类型一致；注意此时Stream中元素的类型是T，
 * 与U可以不一样也可以一样，这样的话操作空间就大了；不管Stream中存储的元素是什么类型，U都可以是任何类型，
 * 如U可以是一些基本数据类型的包装类型Integer、Long等；或者是String，又或者是一些集合类型ArrayList等；后面会说到这些用法。
 * accumulator: 其类型是BiFunction，输入是U与T两个类型的数据，而返回的是U类型；
 * 也就是说返回的类型与输入的第一个参数类型是一样的，而输入的第二个参数类型与Stream中元素类型是一样的 combiner:
 * 其类型是BinaryOperator，支持的是对U类型的对象进行操作
 * 第三个参数combiner主要是使用在并行计算的场景下；如果Stream是非并行时，第三个参数实际上是不生效的。
 * 因此针对这个方法的分析需要分并行与非并行两个场景。
 */
public class ReduceExample {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		/**
		 * 没有起始值时返回为Optional类型
		 */
		Optional<Integer> reduce = list.stream().reduce(Integer::sum);

		System.out.println("集合求和计算-reduce:" + reduce.get());
		/**
		 * 可以给一个起始种子值
		 */
		Integer reduce1 = list.stream().reduce(0, Integer::sum);

		System.out.println("起始种子值求和-reduce:" + reduce1);

		/**
		 * 直接用sum方法
		 */
		int sum = list.stream().mapToInt(e -> e).sum();

		System.out.println("直接使用sum方法求和:" + sum);
	}
}
