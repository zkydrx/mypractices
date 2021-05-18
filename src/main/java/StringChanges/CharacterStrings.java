package StringChanges;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ZKY on 2017-06-04 01:13.
 * 给定两个字符串，请设计一个方法来判定其中一个字符串是否为另一个字符串的置换。
 * <p>
 * 置换的意思是，通过改变顺序可以使得两个字符串相等。
 * 样例
 * "abc" 为 "cba" 的置换。
 * <p>
 * "aabc" 不是 "abcc" 的置换。
 */
public class CharacterStrings
{
    /**
     * @param A a string
     * @param B a string
     * @return a boolean
     */
    public boolean stringPermutation(String A, String B)
    {
        // Write your code here
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        char[] a = new char[A.length()];
        char[] b = new char[B.length()];
        if (A.length() != B.length())
        {
            return false;
        }
        else
        {
            for (int i = 0; i < A.length(); i++)
            {
                a[i] = A.charAt(i);
            }
            for (int i = 0; i < B.length(); i++)
            {
                b[i] = B.charAt(i);
            }
            Arrays.sort(a);
            Arrays.sort(b);
            for (int i = 0; i < a.length; i++)
            {
                for (int j = 0; j < b.length; j++)
                {
                    if (a[i] != b[i])
                    {
                        return false;
                    }
                }
            }

            return true;

        }
    }

    @Test
    public void testStringPermutation()
    {
        boolean b = stringPermutation("abc", "cba");
        System.out.println(b);
        boolean b1 = stringPermutation("abcc", "abbc");
        System.out.println(b1);
        boolean b2 = stringPermutation("abccd", "abbcddddd");
        System.out.println(b2);
    }
}
