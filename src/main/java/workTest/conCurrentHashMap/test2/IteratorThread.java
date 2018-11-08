package workTest.conCurrentHashMap.test2;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-11-09
 * Time: 00:20:15
 * Description:
 */
public class IteratorThread implements Runnable
{
    Map<Integer, Integer> hashMap;

    public IteratorThread(Map<Integer, Integer> hashMap)
    {
        this.hashMap = hashMap;
    }

    @Override
    public void run()
    {
        System.out.println("------------------ " + hashMap.size());
        for (Integer value : hashMap.values())
        {
            System.out.println("value " + value);
        }
        System.out.println("+++++++++++++++++++ " + hashMap.size());
    }
}
