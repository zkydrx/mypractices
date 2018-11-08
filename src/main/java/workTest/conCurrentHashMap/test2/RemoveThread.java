package workTest.conCurrentHashMap.test2;

import java.util.Map;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-11-09
 * Time: 00:19:39
 * Description:
 */
public class RemoveThread implements Runnable
{
    Map<Integer, Integer> hashMap;

    public RemoveThread(Map<Integer, Integer> hashMap)
    {
        this.hashMap = hashMap;
    }

    @Override
    public void run()
    {
        int random = new Random().nextInt(1000);
        while (true)
        {
            hashMap.remove(random);
        }
    }
}
