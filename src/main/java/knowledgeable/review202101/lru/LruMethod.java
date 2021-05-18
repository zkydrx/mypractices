package knowledgeable.review202101.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2021-01-29
 * Time: 15:39:10
 * Description:
 */
public class LruMethod<K, V> extends LinkedHashMap<K, V>
{
    private int capacity;

    public LruMethod(int capacity)
    {
        super(capacity, 0.75F, false);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest)
    {
        return super.size() > capacity;
    }

    public static void main(String[] args)
    {
        LruMethod<Integer, Integer> lruMethod = new LruMethod<>(3);
        lruMethod.put(1, 1);
        lruMethod.put(2, 2);
        lruMethod.put(3, 3);
        System.out.println(lruMethod.keySet());
        lruMethod.put(5, 5);
        System.out.println(lruMethod.keySet());
        lruMethod.put(6, 6);
        lruMethod.put(3, 3);
        System.out.println(lruMethod.keySet());
        lruMethod.put(3, 3);
        System.out.println(lruMethod.keySet());
        lruMethod.put(3, 3);
        System.out.println(lruMethod.keySet());
        lruMethod.put(7, 7);
        System.out.println(lruMethod.keySet());


        /**
         * super(capacity, 0.75F, false);
         * [1, 2, 3]
         * [2, 3, 5]
         * [3, 5, 6]
         * [3, 5, 6]
         * [3, 5, 6]
         * [5, 6, 7]
         * super(capacity, 0.75F, true);
         * [1, 2, 3]
         * [2, 3, 5]
         * [5, 6, 3]
         * [5, 6, 3]
         * [5, 6, 3]
         * [6, 3, 7]
         */

    }
}
