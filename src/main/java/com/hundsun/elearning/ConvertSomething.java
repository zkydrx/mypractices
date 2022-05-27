package com.hundsun.elearning;

/**
 * @ProjectName: mypractices
 * @Package: com.hundsun.elearning
 * @ClassName: ConvertSomething
 * @Author: hspcadmin
 * @Description: 转换字母
 * 用C或者JAVA写一个算法,将一个包含数字和大写字母的字符串转换成只包含大写字母的字符串,
 * 需要保证转换后的字符串能够还原为原字符串(不需要写还原算法)。要求先写出算法描述和转换例子，
 * 然后写出对应的代码。提示：转换后的字符串长度可以增加。
 * 例如：“123ABC”
 * @Date: 2022-05-25 20:42
 * @Version: 1.0
 */
public class ConvertSomething
{
    public static String convertNumtoLetter(String str)
    {
        String temp = "12311ABC";


        char tem = 'A';
        char tem1 = 'B';

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < temp.length(); i++)
        {
            if (Character.isDigit(temp.charAt(i)))
            {
                stringBuilder.append('A');
            }
            else
            {
                stringBuilder.append(temp.charAt(i));
            }
        }
        System.out.println(stringBuilder.toString());

        String substring = temp.substring(0, 1);


        return null;
    }

    public static void main(String[] args)
    {
        convertNumtoLetter("");
        String str1 = encode("ZZ123XYZZ");
        String str2 = convert("ZZ123XYZZ");
        System.out.println(str1);
        System.out.println(str2);
    }


    public static String encode(String source)
    {
        String dest = "";
        for (int i = 0; i < source.length(); i++)
        {
            char c = source.charAt(i);
            if (c == 'Z')
            {
                dest += "Z";
                dest += c;
            }
            else if (c >= '0' && c <= '9')
            {
                dest += "Z";
                char dc = (char) (c + ((int) 'A' - (int) '0'));
                dest += dc;
            }
            else
            {
                dest += c;
            }
        }
        return dest;
    }



    public static String convert(String source)
    {
        char temp;
        String result = "";
        for (int i = 0; i < source.length(); i++)
        {
            if(source.charAt(i)=='X')
            {
                result +='X';
                result +=source.charAt(i);
            }
            else if (source.charAt(i)>='0'&&source.charAt(i)<='9')
            {
                result +='X';
                result += (char)('A'+(source.charAt(i)-'0'));
            }
            else
            {
                result +=source.charAt(i);
            }
        }
        return result;
    }

}
