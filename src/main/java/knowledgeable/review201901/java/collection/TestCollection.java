package knowledgeable.review201901.java.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-15
 * Time: 20:52:19
 * Description:
 * 集合去重以及按字段排序问题
 */
public class TestCollection
{
    @Test
    public void testRemoveElement()
    {
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("初始化后的list元数据："+list);

        for (int i = 0; i < list.size(); i++)
        {
            if(list.get(i).equalsIgnoreCase("a"))
            {
                list.remove(i);
            }
        }
        System.out.println("普通for循环删除重复的元素后的list（这种情况下可能会出现下标位移导致删除失败）："+list);


        list1.add("a");
        list1.add("a");
        list1.add("b");
        list1.add("c");
        Iterator<String> iterator = list1.iterator();
        while (iterator.hasNext())
        {
            if(iterator.next().equalsIgnoreCase("a"))
            {
                iterator.remove();
            }
        }
        System.out.println("使用迭代器进行判断删除后的结果（这种结果是正确的）："+list1);
    }

    @Test
    public void testGetSomeCollections()
    {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list2.add("b");
        list2.add("c");

        /**
         * 并集
         */
        list1.addAll(list2);
        System.out.println("并集："+list1);


        List<String> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        list3.add("a");
        list3.add("b");
        list3.add("c");
        list4.add("b");
        list4.add("c");

        /**
         * 无重复并集
         */
        list4.removeAll(list3);
        list3.addAll(list4);
        System.out.println("无重复并集："+list3);



        List<String> list5 = new ArrayList<>();
        List<String> list6 = new ArrayList<>();
        list5.add("a");
        list5.add("b");
        list5.add("c");
        list6.add("b");
        list6.add("c");

        /**
         * 交集
         */
        list5.retainAll(list6);
        System.out.println("交集："+list5);

        List<String> list7 = new ArrayList<>();
        List<String> list8 = Arrays.asList(new String[]{"b","c"});
        list7.add("a");
        list7.add("b");
        list7.add("c");
        list8.add("b");
        list8.add("c");

        /**
         * 差集
         */
        list7.removeAll(list8);
        System.out.println("差集："+list7);
    }



    @Test
    public void testIphone()
    {
        Iphone iphone1 = new Iphone(1,3,"iphone7");
        Iphone iphone2 = new Iphone(78,2,"iphone8");
        Iphone iphone3 = new Iphone(32,8,"iphonex");
        Iphone iphone4 = new Iphone(4,4,"iphone11");
        Iphone iphone5 = new Iphone(3,1,"iphone12");
        Iphone iphone6 = new Iphone(343,1,"iphone13");
        Iphone iphone7 = new Iphone(1,4,"iphone14");

        List<Iphone> list = new ArrayList<>();
        list.add(iphone1);
        list.add(iphone2);
        list.add(iphone3);
        list.add(iphone4);
        list.add(iphone5);
        list.add(iphone6);
        list.add(iphone7);
        Collections.sort(list);
        System.out.println(list);
    }

}
