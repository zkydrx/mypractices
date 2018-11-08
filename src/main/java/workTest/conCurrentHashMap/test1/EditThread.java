package workTest.conCurrentHashMap.test1;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-11-08
 * Time: 23:59:19
 * Description:
 */
public class EditThread implements Runnable
{

    Map<Integer, Integer> hashMap;

    public EditThread(Map<Integer, Integer> hashMap)
    {
        this.hashMap = hashMap;
    }

    @Override
    public void run()
    {
        hashMap.put(0, hashMap.get(0) + 1);
    }
}
