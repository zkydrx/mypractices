package fromeFaceBook.JavaProgramming.ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-11-17 Time: 23:46
 * Description:
 */
public class ArrayListDomain {
	List<String> list = new ArrayList<>();
	List<String> list1 = new ArrayList<>();

	public List<String> method(List<String> list) {
		list.add("a");
		list.add("b");
		return list;
	}

	/**
	 * all the Arraylist be same with each other.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayListDomain ml1 = new ArrayListDomain();
		ml1.list1 = ml1.method(ml1.list);
		ml1.list.add("c");
		ml1.list.add("d");
		System.out.println(ml1.list1);
	}

}
