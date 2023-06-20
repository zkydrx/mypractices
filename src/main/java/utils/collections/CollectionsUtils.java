package utils.collections;

import utils.collections.Entity.User;

import java.util.*;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2018-08-30 Time: 09:14:00
 * Description: Collections.sort method practices
 */
public class CollectionsUtils {
	public static void main(String[] args) {
		User user = new User(1L, "tom", 2, "Italy");
		User user1 = new User(2L, "amy", 88, "France");
		User user2 = new User(3L, "tony", 22, "Australian");
		User user3 = new User(4L, "john", 55, "English");
		User user4 = new User(5L, "alis", 90, "American");

		List<User> list = new ArrayList<>();
		list.add(user);
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);

		/**
		 * One method
		 */
		Collections.sort(list);

		System.out.println(Arrays.toString(list.toArray()));
		/**
		 * Two method
		 */
		Collections.sort(list, (o1, o2) -> o2.getAge().compareTo(o1.getAge()));
		System.out.println(Arrays.toString(list.toArray()));
	}
}
