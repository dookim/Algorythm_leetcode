import java.util.HashMap;
import java.util.Map;


public class LRUCache2 {
	class ListNode {
		int val;
		int key;
		ListNode next;
		ListNode prev;
		
		public ListNode(int key,int val) {
			// TODO Auto-generated constructor stub
			this.val = val;
			this.key = key;
		}
	}
	
	int capacity;
	ListNode first;
	ListNode last;
	Map<Integer,ListNode> map;
	int size;
	
    public LRUCache2(int capacity) {
    	this.capacity = capacity;
    	this.first = null;
    	this.last = null;
    	this.map = new HashMap<>();
    	this.size = 0;
    }
    
    //맨앞으로 옮겨야 함.ㄴ 
    
    public int get(int key) {
    	if(!map.containsKey(key)) return -1;
    	//지우고 맨앞으로 옮길것.
    	ListNode ret =map.get(key);
    	moveFirst(ret);
    	return ret.val;
    }
    
    private void moveFirst(ListNode p) {
    	if(size > 1 && p != first) {
    		if(p == last) {
    			last = p.prev;
    			p.prev.next = null;
    		} else {
    			p.prev.next = p.next;
    			p.next.prev = p.prev;
    		}
    		
    		p.prev = null;
    		p.next = first;
    		first.prev = p;
    		first = p;
    	}
    }
    
    //kjh6053@naver.com
    
    public void set(int key, int value) {
        //기존의 key가 있다면 대체할것.
    	
    	if(map.containsKey(key)) {
    		map.get(key).val = value;
    		ListNode cur = map.get(key);
    		moveFirst(cur);
    	} else {
    		size++;
    		ListNode cur = new ListNode(key,value);
    		map.put(key, cur);
    		if(first == null && last == null) {
    			first = cur;
    			last = cur;
    		} else {
    			cur.next = first;
        		first.prev = cur;
        		first = cur;
        		if(size > capacity) {
        			ListNode tempLast = last.prev;
        			last.prev.next = null;
        			last.prev = null;
        			map.remove(last.key);
        			last = tempLast;
        			size--;
        		}
    		}
    	}
    }
}
