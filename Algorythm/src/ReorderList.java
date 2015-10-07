

public class ReorderList {

	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
    public void reorderList(ListNode head) {
    	if(head == null || head.next == null || head.next == null) {
    		return;
    	}
    	int size = 0;
    	ListNode p = head;
    	
    	while(p != null) {
    		size++;
    		p = p.next;
    	}
    	
    	int forward = size%2 == 0 ? (size/2) - 1 : size/2;
    	p = head;
    	
    	while(forward --> 0) {
    		p = p.next;
    	}
    	
    	ListNode reverse = p.next;
    	p.next = null;
    	reverse = reverse(reverse, size/2);
    	
    	p = head.next;
    	ListNode before = head;
    	
    	while(reverse != null) {
    		ListNode next = reverse.next;
    		before.next = reverse;
    		reverse.next = p;
    		
    		reverse = next;
    		before = p;
    		p = p.next;
    	}
    }
    
    private ListNode reverse(ListNode first, int size) {
    	if(size == 1) {
    		first.next = null;
    		return first;
    	}
    	if(size%2 == 0) {
    		int half = size/2;
    		ListNode second = first;
    		while(half --> 0) {
    			second = second.next;
    		}
    		ListNode reverse1 = reverse(first, size/2);
    		ListNode reverse2 = reverse(second, size/2);
    		second.next = reverse1;
    		return reverse2;
    	} else {
    		int half = size/2;
    		ListNode mid = first;
    		while(half --> 0) {
    			mid = mid.next;
    		}
    		ListNode second = mid.next;
    		ListNode reverse1 = reverse(first, size/2);
    		ListNode reverse2 = reverse(second, size/2);
    		second.next = mid;
    		mid.next = reverse1;
    		return reverse2;
    	}
    }
    
    /*
    public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		reorderList(node);
	}
	*/

}
