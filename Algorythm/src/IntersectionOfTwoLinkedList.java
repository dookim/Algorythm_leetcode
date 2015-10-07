public class IntersectionOfTwoLinkedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	int headALen = 0;
    	int headBLen = 0;
    	
    	ListNode p1 = headA;
    	ListNode p2 = headB;
    	
    	while(p1 != null) {
    		headALen++;
    		p1 = p1.next;
    	}
    	
    	while(p2 != null) {
    		headBLen++;
    		p2 = p2.next;
    	}
    	
    	if(headALen > headBLen) {
    		int forward = headALen - headBLen;
    		p1 = headA;
    		while((forward--) > 0) {
    			p1 = p1.next;
    		}
    		p2 = headB;
    	} else if(headALen < headBLen) {
    		int forward = headBLen - headALen;
    		p2 = headB;
    		while((forward--) > 0) {
    			p2 = p2.next;
    		}
    		p1 = headA;
    	} else {
    		p1= headA;
    		p2 = headB;
    	}
    	
    	while(p1 != null) {
    		if(p1 == p2) {
    			return p1;
    		}
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	return null;
    	
    }

	public static void main(String[] args) {
		
	}
}
