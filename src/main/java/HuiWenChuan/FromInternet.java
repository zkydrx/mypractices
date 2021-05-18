package HuiWenChuan;

/**
 * Created by ZKY on 2017-06-15 08:28.
 */
public class FromInternet
{

    /**
     * @param s a string which consists of lowercase or uppercase letters
     * @return the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s)
    {
        // Write your code here
        if (s == null || s.length() == 0)
        {
            return 0;
        }
        boolean hasOod = false;
        int[] record = new int[52];
        for (int i = 0; i < record.length; i++)
        {
            record[i] = 0;
        }
        for (int i = 0; i < s.length(); i++)
        {
            char temp = s.charAt(i);
            if (Character.isUpperCase(temp))
            {
                record[temp - 'A' + 0]++;
            }
            else
            {
                record[temp - 'a' + 26]++;
            }
        }
        int result = 0;
        for (int i = 0; i < record.length; i++)
        {
            result += (record[i] / 2) * 2;
            if (record[i] % 2 == 1)
            {
                hasOod = true;
            }
        }
        if (hasOod)
            result++;
        System.out.println(result);
        return result;
    }

    public static void main(String[] args)
    {
        FromInternet f = new FromInternet();
        f.longestPalindrome("abccccdd");
        //        f.longestPalindrome("aaa");
        //        f.longestPalindrome("aaabbccc");
        //        f.longestPalindrome("aaabb");
    }
}
