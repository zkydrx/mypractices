package JavaBianCheng.MergeElements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: Abbot Date: 2017-08-30 Time: 00:53
 * Description: 编写一个交错合并列表元素的函数。例如：给定的两个列表为[a，B，C]和[1，2，3]，函数返回[a，1，B，2，C，3]。
 */
public class Domain {
	/**
	 * 合并两个元素个数相等的列表。
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public List mergeTwoList(List a, List b) {
		List resultList = new ArrayList();
		for (int i = 0; i < a.size(); i++) {
			resultList.add(a.get(i));
			resultList.add(b.get(i));
		}

		return resultList;
	}

}
