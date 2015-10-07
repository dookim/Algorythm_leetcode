
public class isPalinedrome {
	
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	
	private void reverse(ListNode head, int size) {
		if(size == 1) {
			head.next = null;
			return;
		}
		int forward = size/2 - 1;
		if(size%2 == 0) {
			ListNode h1 = head;
			ListNode t1 = h1;
			for(int i = 0; i < forward; ++i) {
				t1 = t1.next;
			}
			ListNode h2 = t1.next;
			ListNode t2 = h2;
			for(int i = 0; i < forward; ++i) {
				t2 = t2.next;
			}
			reverse(h1, size/2);
			reverse(h2, size/2);
			
			h2.next = t1;
			
		} else {
			ListNode h1 = head;
			ListNode t1 = h1;
			for(int i = 0; i < forward; ++i) {
				t1 = t1.next;
			}
			ListNode mid = t1.next;
			ListNode h2 = mid.next;
			ListNode t2 = h2;
			for(int i = 0; i < forward; ++i) {
				t2 = t2.next;
			}
			reverse(h1, size/2);
			reverse(h2, size/2);
			
			mid.next = t1;
			h2.next = mid;		
		}
	}
    public boolean isPalindrome(ListNode head) {
    	if(head == null || head.next == null) {
    		return true;
    	}
    	
    	int size = 1;
    	ListNode tail = head;
    	while(tail.next != null) {
    		size++;
    		tail = tail.next;
    	}
    	ListNode mid = head;
    	int midSize = size/2;
    	
    	for(int i = 0; i < midSize; ++i) {
    		mid = mid.next;
    	}
    	
    	if(size%2 == 0) {
    		reverse(mid, midSize);
    	} else {
    		reverse(mid.next, midSize);
    	}
    	
    	for(int i = 0; i < midSize; ++i) {
    		if(head.val != tail.val) {
    			return false;
    		}
    		head = head.next;
    		tail = tail.next;
    	}
    	return true;	
    }
    
	public static void main(String[] args) {
//		ListNode h1 = new ListNode(1);
//		h1.next = new ListNode(2);
//		h1.next.next = new ListNode(3);
//		h1.next.next.next = new ListNode(4);
//		
//		ListNode tail = h1.next.next.next;
//		
//		reverse(h1, 4);
//		
//		while(tail != null) {
//			System.out.println(tail.val);
//			tail=tail.next;
//		}
		
	}
}
