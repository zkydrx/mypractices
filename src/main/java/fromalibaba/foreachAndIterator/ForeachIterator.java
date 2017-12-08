package fromalibaba.foreachAndIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-11-29
 * Time: 12:07
 * Description:
 */
public class ForeachIterator
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
        List<String> list1 = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list1.add("1");
        list1.add("2");

        for (String s : list)
        {
            if("1".equals(s))
            {
                list.remove(s);
            }
        }
        System.out.println(list);

//        for (String s : list1)
//        {
//            if("2".equals(s))
//            {
//                list1.remove(s);
//            }
//        }

    }
}
