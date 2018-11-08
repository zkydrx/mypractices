package workTest.conCurrentHashMap.test2;

import java.util.Map;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-11-09
 * Time: 00:19:06
 * Description:
 */
public class AddThread implements Runnable
{
    Map<Integer, Integer> hashMap;

    public AddThread(Map<Integer, Integer> hashMap)
    {
        this.hashMap = hashMap;
    }

    @Override
    public void run()
    {
        while (true)
        {
            int random = new Random().nextInt();
            hashMap.put(random, random);
        }
    }
}
