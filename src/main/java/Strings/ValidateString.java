package Strings;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by ZKY on 2017-06-05 14:51. 有效的括号序列 给定一个字符串所表示的括号序列，包含以下字符： '(', ')',
 * '{', '}', '[' and ']'， 判定是否是有效的括号序列。 样例 括号必须依照 "()" 顺序表示， "()[]{}" 是有效的括号，但
 * "([)]"则是无效的括号。
 */
public class ValidateString {
	public static void main(String[] args) {
		ValidateString test = new ValidateString();
		boolean validParentheses = test.isValidParentheses("()[]{}");
		System.out.println(validParentheses);
		System.out.println(test.isValidParentheses("["));
		System.out.println(test.isValidParentheses("[]}"));
		System.out.println(test.isValidParentheses("[{()}]"));

		System.out.println(test.isValidParentheses("[({(())}[()])]"));
	}

	/**
	 * @param s
	 *            A string
	 * @return whether the string is a valid parentheses
	 */
	public boolean isValidParentheses(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);

			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		return stack.empty();
	}
}
