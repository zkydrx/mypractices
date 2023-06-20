package CoreJava;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-10-18 Time: 01:48
 * Description: 迭代不按元素排序，删除按优先级来删除，首先删除优先级最小的那个元素。 Iterating over elements...
 * 1815-12-10 1906-12-09 1903-12-03 1910-06-22 Removing elements 1815-12-10
 * 1903-12-03 1906-12-09 1910-06-22
 */
public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<LocalDate> pq = new PriorityQueue<>();
		pq.add(LocalDate.of(1906, 12, 9));
		pq.add(LocalDate.of(1815, 12, 10));
		pq.add(LocalDate.of(1903, 12, 3));
		pq.add(LocalDate.of(1910, 6, 22));
		System.out.println("Iterating over elements...");
		for (LocalDate localDate : pq) {
			System.out.println(localDate);
		}
		System.out.println("Removing elements");
		while (!pq.isEmpty()) {
			System.out.println(pq.remove());
		}
	}
}
