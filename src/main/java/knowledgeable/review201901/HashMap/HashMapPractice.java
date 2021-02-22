package knowledgeable.review201901.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-19
 * Time: 13:56:41
 * Description:
 * 给定任意一个字符串“To be or not to be that is a question”，
 * 长度为任意，要求找出其出现次数最多的字符及计算次数
 */
public class HashMapPractice
{

    public static void main(String[] args)
    {
        countTheChar();
//        testHashMap();
    }

    public static void countTheChar()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        System.out.println("请输入一行字符串：");
        try
        {
            str = reader.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        /**
         * create a new HashMap
         */
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++)
        {
            Character ch = new Character(str.charAt(i));
            Integer val = new Integer(1);
            /**
             * put()方法返回与key关联的旧值;如果key没有任何的映射关系，
             * 则返回null（返回null还可能表示该映射之前将null与key关联）
             */
            Integer oldVal = map.put(ch, val);
            if (oldVal != null)
            {
                map.put(ch, oldVal + 1);
            }
        }

        System.out.println("hashMap: " + map);

        int max = 0;
        Character ch1 = null;
        Set<Character> set ;
        set = map.keySet();
        System.out.println("set: "+set);
        Iterator<Character> iterator = set.iterator();

        while (iterator.hasNext())
        {
            Character character = iterator.next();
            Integer pos = map.get(character).intValue();
            if (pos > max)
            {
                max = pos;
                ch1 = character;
            }
        }
        System.out.println("字符串：" + str + " 中出现最多的字符是：" + ch1 + "\n" + "出现次数为：" + max);
    }


    public static void testHashMap()
    {
        HashMap<String,String> map = new HashMap<>();

        String a = map.put("a", "1");
        String b = map.put("b", "2");

        String a2 = map.get("a");
        String b2 = map.get("b");
        System.out.println("string: a "+a);
        System.out.println("string: b "+b);
        System.out.println("此时getKey('a')"+a2);
        System.out.println("此时getKey('b')"+b2);
        System.out.println("此时的map: "+map);
        String a1 = map.put("a", "3");
        String b1 = map.put("b", "4");

        String c = map.put("c", "5");

        String a3 = map.get("a");
        String b3 = map.get("b");

        System.out.println("String a1 "+a1);
        System.out.println("String b1 "+b1);
        System.out.println("此时getKey('a')"+a3);
        System.out.println("此时getKey('b')"+b3);
        System.out.println("String c "+c);
        System.out.println("此时的map:"+map);

    }

}
