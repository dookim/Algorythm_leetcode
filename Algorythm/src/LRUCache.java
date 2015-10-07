import java.util.LinkedHashMap;
import java.util.Set;


public class LRUCache {
	LRUCacheKDH<Integer, Integer> cache;
    public LRUCache(int capacity) {
		// TODO Auto-generated constructor stub
    	cache = new LRUCacheKDH<>(capacity);
    	
	}
    
    public int get(int key) {
    	if(!cache.containsKey(key)) {
    		return -1;
    	}
    	return cache.get(key);
    }
    
    public void set(int key, int value) {
    	cache.put(key, value);
    }
    
    
    class LRUCacheKDH<K,V> extends LinkedHashMap<K, V> {
    	private int capacity;
    	public LRUCacheKDH(int capacity) {
			// TODO Auto-generated constructor stub
            super(capacity + 1, 1.1f, true);
            this.capacity = capacity;
		}
    	
    	@Override
    	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
    		// TODO Auto-generated method stub
    		return size() > capacity;
    	}
    }
}
