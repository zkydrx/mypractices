package com.hundsun.practices.lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

/**
 * 文件描述
 **/
@Slf4j
public class LambdaTest {
	@Test
	public void test() {
		Map<CommonKey, BusihubIvsmAcc> all = new ConcurrentHashMap<>();
		all.put(CommonKey.builder().investmentAccountCode("A").build(),
				BusihubIvsmAcc.builder().dpInvestAccountLayer("01").assetCode("X0").build());
		all.put(CommonKey.builder().investmentAccountCode("B").build(),
				BusihubIvsmAcc.builder().dpInvestAccountLayer("02").build());
		all.put(CommonKey.builder().investmentAccountCode("C").build(),
				BusihubIvsmAcc.builder().dpInvestAccountLayer("03").build());
		all.put(CommonKey.builder().investmentAccountCode("D").build(),
				BusihubIvsmAcc.builder().dpInvestAccountLayer("04").build());
		all.put(CommonKey.builder().investmentAccountCode("E").build(),
				BusihubIvsmAcc.builder().dpInvestAccountLayer("05").build());
		all.put(CommonKey.builder().investmentAccountCode("F").build(),
				BusihubIvsmAcc.builder().dpInvestAccountLayer("06").build());
		all.put(CommonKey.builder().investmentAccountCode("A").build(),
				BusihubIvsmAcc.builder().dpInvestAccountLayer("01").assetCode("X4").build());
		all.put(CommonKey.builder().investmentAccountCode("G").build(),
				BusihubIvsmAcc.builder().dpInvestAccountLayer("01").assetCode("X1").build());
		all.put(CommonKey.builder().investmentAccountCode("H").build(),
				BusihubIvsmAcc.builder().dpInvestAccountLayer("01").assetCode("X2").build());
		all.put(CommonKey.builder().investmentAccountCode("I").build(),
				BusihubIvsmAcc.builder().dpInvestAccountLayer("01").assetCode("X3").build());

		Map<CommonKey, BusihubIvsmAcc> filterFundAccMap = all.entrySet().stream().filter(entry -> {
			BusihubIvsmAcc acc = entry.getValue();
			String accountLayer = acc.getDpInvestAccountLayer();
			return "01".equals(accountLayer) || "02".equals(accountLayer);
		}).collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> x));
		filterFundAccMap.forEach((key, value) -> {
			System.out.print(key.getInvestmentAccountCode());
			System.out.print("<==>");
			System.out.print(value.getDpInvestAccountLayer());
			System.out.print("<==>");
			System.out.print(value.getAssetCode());
			System.out.println();
		});
	}

	@Test
	public void test1() {
		Map<CommonKey, BusihubIvsmAcc> all = new ConcurrentHashMap<>();
		all.put(CommonKey.builder().investmentAccountCode("A").build(),
				BusihubIvsmAcc.builder().investmentAccountCode("D1").fundCode("z1").dpInvestAccountLayer("01").build());
		all.put(CommonKey.builder().investmentAccountCode("B").build(),
				BusihubIvsmAcc.builder().investmentAccountCode("D2").fundCode("z2").dpInvestAccountLayer("02").build());
		all.put(CommonKey.builder().investmentAccountCode("C").build(),
				BusihubIvsmAcc.builder().investmentAccountCode("D3").fundCode("z3").dpInvestAccountLayer("03").build());
		all.put(CommonKey.builder().investmentAccountCode("D").build(),
				BusihubIvsmAcc.builder().investmentAccountCode("D4").fundCode("z4").dpInvestAccountLayer("04").build());
		all.put(CommonKey.builder().investmentAccountCode("E").build(),
				BusihubIvsmAcc.builder().investmentAccountCode("D5").fundCode("z5").dpInvestAccountLayer("05").build());

		List<BusihubIvsmAcc> collect = all.values().stream().collect(Collectors.toList());

		List<BusihubIvsmAcc> collect2 = collect.stream().filter(e -> {
			return "z1".equals(e.getFundCode()) && "01".equals(e.getDpInvestAccountLayer());
		}).collect(Collectors.toList());
		log.info("collect2:{}", collect2);
		Stream<BusihubIvsmAcc> busihubIvsmAccStream = collect.stream().filter(e -> {
			return "z1".equals(e.getFundCode()) && "01".equals(e.getDpInvestAccountLayer());
		});
		ConcurrentMap<String, String> collect1 = busihubIvsmAccStream.collect(
				Collectors.toConcurrentMap(k -> k.getFundCode(), v -> v.getInvestmentAccountCode(), (m1, m2) -> m1));

		log.info("resultMap:{}", collect1);

	}

	@Test
	public void test3() {
		List<Book> books = new ArrayList<>();
		// books.add(new Book(10,"开元"));
		books.add(new Book(10, null));
		books.add(new Book(12, "大明"));
		// books.add(new Book(12,"元"));
		books.add(new Book(14, "孙中山"));

		Map<Integer, Book> collect = books.stream().collect(
				Collectors.toMap(Book::getReleaseYear, Function.identity(), (existing, replacement) -> existing));
		log.info("collect:{}", collect);
		Map<Integer, String> collect1 = books.stream().collect(Collectors.toMap(Book::getReleaseYear,
				book -> StringUtils.isEmpty(book.getName()) ? "0" : book.getName()));
		log.info("collect1:{}", collect1);

	}

	@Test
	public void test4() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		List<String> list1 = list.subList(0, 3);
		log.info("list1：{}", list1);

	}

	public static <T, R> Map<R, Collection<T>> collectionMap(Collection<T> collections, Function<T, R> function) {

		Optional<Map<R, Collection<T>>> reduce = collections.stream().map(book -> {
			Map<R, Collection<T>> map = Maps.newConcurrentMap();
			Collection<T> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
			copyOnWriteArrayList.add(book);
			map.put(function.apply(book), copyOnWriteArrayList);
			return map;
		}).reduce((itemOne, itemTwo) -> {
			R itemTwoKey = itemTwo.keySet().iterator().next();
			if (itemOne.containsKey(itemTwoKey)) {
				itemOne.get(itemTwoKey).addAll(itemTwo.get(itemTwoKey));
			} else {
				itemOne.putAll(itemTwo);
			}
			return itemOne;
		});

		return reduce.orElse(Maps.newConcurrentMap());
	}

	@Test
	public  void testStreamMap(){
		List<Map<String, Object>> maps = new ArrayList<>();
		Map<String,Object> map1 = new HashMap<>();
		map1.put("abc","1");
		map1.put("def","a2");
		Map<String,Object> map2 = new HashMap<>();
		map2.put("abc","1");
		map2.put("def","b2");
		Map<String,Object> map3 = new HashMap<>();
		map3.put("abc3","3");
		map3.put("def3","c3");
		Map<String,Object> map4 = new HashMap<>();
		map4.put("abc","4");
		map4.put("def","d4");
		Map<String,Object> map5 = new HashMap<>();
		map5.put("abc","5");
		map5.put("def","e5");
		Map<String,Object> map6 = new HashMap<>();
		map6.put("abc","6");
		map6.put("def","b2");
		maps.add(map1);
		maps.add(map2);
		maps.add(map3);
		maps.add(map4);
		maps.add(map5);
		maps.add(map6);
		Map<String, Object> collect = maps.stream().filter(e -> null != e.get("abc")).collect(
				Collectors.toMap(e -> e.get("def").toString(), e -> e.get("abc"), (o1, o2) -> o1));
		Map<String, Object> collect1 = maps.stream().filter(e -> null != e.get("abc")).collect(
				Collectors.toMap(e -> e.get("def").toString(), Map::entrySet, (o1, o2) -> o1));
		Map<String, Object> collect2 = maps.stream().filter(e -> null != e.get("abc")).collect(
				Collectors.toMap(e -> e.get("def").toString(), Map::entrySet, (o1, o2) -> o1));
		int abc = maps.stream().filter(e->e.get("abc")!=null).flatMapToInt(e -> IntStream.of(Integer.parseInt(e.get("abc").toString()))).reduce(Integer::max).getAsInt();
		System.out.println(collect);
		System.out.println(collect1);
		System.out.println(collect2);
		System.out.println(abc);
	}

}
