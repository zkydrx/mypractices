import java.util.ArrayList;

/**
 * Created by ZKY on 2017-06-04 00:19. 给定 n 对括号， 请写一个函数以将其生成新的括号组合，并返回所有组合结果。 样例
 * 给定 n = 3, 可生成的组合如下:
 * <p>
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class QutorCharacters {

	/**
	 * @param n
	 *            n pairs
	 * @return All combinations of well-formed parentheses
	 */
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> ss = new ArrayList<String>();
		ss = print(n, n, ss, 0);
		return ss;
	}

	ArrayList<String> print(int i, int j, ArrayList<String> ss, int p) {
		if (ss.size() == 0) {
			String s = "(";
			ss.add(s);
			i--;
		} else {
			ArrayList<String> list = new ArrayList();
			if (p == 0) {
				for (String s : ss) {
					String s1 = s + "(";
					list.add(s1);
				}
				i--;
			} else {
				for (String s : ss) {
					String s1 = s + ")";
					list.add(s1);
				}
				j--;
			}
			ss = list;
		}

		ArrayList<String> list = new ArrayList();
		if (i > 0) {
			list.addAll(print(i, j, ss, 0));
		}
		if (i < j && j > 0) {
			list.addAll(print(i, j, ss, 1));
		}
		if (list.size() == 0) {
			return ss;
		}
		return list;
	}

	public static void main(String[] args) {
		QutorCharacters a = new QutorCharacters();
		ArrayList<String> strings = a.generateParenthesis(3);
		for (String s : strings) {
			System.out.println(s);
		}
	}

}
