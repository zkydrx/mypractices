package HuiWenChuan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZKY on 2017-06-14 11:18.
 * 给出一个包含大小写字母的字符串。求出由这些字母构成的最长的回文串的长度是多少。
 * <p>
 * 数据是大小写敏感的，也就是说，"Aa" 并不会被认为是一个回文串。
 * <p>
 * 注意事项
 * <p>
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 样例
 * 给出 s = "abccccdd" 返回 7
 * <p>
 * 一种可以构建出来的最长回文串方案是 "dccaccd"。
 */
public class MaxHuiWenChuan
{
    public int longestPalindrome(String s)
    {
        // Write |your code here
        List<Integer> list = getList(s);
        int i = getMaxHuiWenShu(list);
        System.out.println(i);
        return i;

    }

    /**
     * 解析字符串，获得每个字符的个数，并返回个数list。
     */
    public List<Integer> getList(String s)
    {
        List<Character> list = new ArrayList<>();
        for (char ll = 'a'; ll <= 'z'; ll++)
        {
            list.add(ll);
        }

        for (char ll = 'A'; ll <= 'Z'; ll++)
        {
            list.add(ll);
        }
        List<Integer> list1 = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++)
        {
            int k = 0;
            for (int j = 0; j < s.length(); j++)
            {

                if (list.get(i).equals(s.charAt(j)))
                {
                    k++;
                }

            }
            if (k != 0)
            {
                list1.add(k);
            }
        }
        return list1;
    }


    /**
     * 对list集合进行分析。并确定最长的回文数。
     */
    public int getMaxHuiWenShu(List<Integer> list)
    {
        int count = 0;

        if (list.size() == 1)
        {
            count = list.get(0);
            return count;
        }


        boolean hasJiShu = false;
        for (int i = 0; i < list.size(); i++)
        {
            count += (list.get(i) / 2) * 2;
            if (list.get(i) % 2 == 1)
            {
                hasJiShu = true;
            }
        }
        if (hasJiShu)
        {
            count++;
        }
        return count;
    }


    public static void main(String[] args)
    {
        MaxHuiWenChuan m = new MaxHuiWenChuan();
        m.longestPalindrome("abccccdd");
        m.longestPalindrome("aaa");
        m.longestPalindrome("aaabbccc");
        m.longestPalindrome("aaabb");
    }
}
