package knowledgeable.review202101.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2021-01-31 Time: 00:06:07
 * Description:
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	private int capacity;

	public LRUCache(int capacity) {
		super(capacity, 0.75F, true);
		this.capacity = capacity;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return super.size() > capacity;
	}

	public static void main(String[] args) {
		LRUCache<Integer, Integer> lruCache = new LRUCache<>(3);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.put(3, 3);
		System.out.println(lruCache.keySet());
		lruCache.get(2);
		System.out.println(lruCache.keySet());
		lruCache.put(4, 4);
		System.out.println(lruCache.keySet());
		lruCache.put(4, 4);
		System.out.println(lruCache.keySet());
		lruCache.put(4, 4);
		System.out.println(lruCache.keySet());
		lruCache.put(5, 5);
		System.out.println(lruCache.keySet());
	}
}
