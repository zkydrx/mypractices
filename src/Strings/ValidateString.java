package Strings;

/**
 * Created by ZKY on 2017-06-05 14:51.
 * 有效的括号序列
 * 给定一个字符串所表示的括号序列，包含以下字符： '(', ')', '{', '}', '[' and ']'，
 * 判定是否是有效的括号序列。
 * 样例
 * 括号必须依照 "()" 顺序表示， "()[]{}" 是有效的括号，但 "([)]"则是无效的括号。
 */
public class ValidateString
{
    public static void main(String[] args)
    {
        ValidateString test = new ValidateString();
        boolean validParentheses = test.isValidParentheses("()[]{}");
        System.out.println(validParentheses);
        System.out.println(test.isValidParentheses("["));
        System.out.println(test.isValidParentheses("[]}"));
        System.out.println(test.isValidParentheses("[{()}]"));

        System.out.println(test.isValidParentheses("[({(())}[()])]"));
    }

    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s)
    {
        // Write your code here
        int j = 0;
        if (s.contains("("))
        {
            int i = s.indexOf("(");
            if (i < s.length() - 1)
            {

                if (s.contains(")"))
                {
                    for (int m = 0; m < s.length(); m++)
                    {
                        if ((s.charAt(m) + "").equals(")"))
                        {
                            int k = s.indexOf(")");
                            if (k > i + 1 && (k - i - 1) % 2 == 0 || k == i + 1)
                            {
                                j++;
                            }
                            else
                            {
                                return false;
                            }
                        }
                    }
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        if (s.contains(")") && !s.contains("("))
        {
            return false;
        }

        if (s.contains("{"))
        {
            int i = s.indexOf("{");
            if (i < s.length() - 1)
            {
                if (s.contains("}"))
                {
                    for (int m = 0; m < s.length(); m++)
                    {
                        if ((s.charAt(m) + "").equals("}"))
                        {
                            int k = s.indexOf("}");
                            if (k > i + 1 && (k - i - 1) % 2 == 0 || k == i + 1)
                            {
                                j++;
                            }
                            else
                            {
                                return false;
                            }
                        }
                    }

                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }

        }

        if (s.contains("}") && !s.contains("{"))
        {
            return false;
        }

        if (s.contains("["))
        {
            int i = s.indexOf("[");
            if (i < s.length() - 1)
            {
                if (s.contains("]"))
                {
                    for (int m = 0; m < s.length(); m++)
                    {
                        if ((s.charAt(m) + "").equals("]"))
                        {
                            int k = s.indexOf("]");
                            if (k > i + 1 && (k - i - 1) % 2 == 0 || k == i + 1)
                            {
                                j++;
                            }
                            else
                            {
                                return false;
                            }
                        }
                    }

                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }

        }
        if (j == 3 || j == 1 || j == 2)
        {
            return true;
        }

        if (s.contains("]") && !s.contains("["))
        {
            return false;
        }
        return false;
    }
}
