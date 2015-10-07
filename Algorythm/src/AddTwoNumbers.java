import java.util.concurrent.Executors;


public class AddTwoNumbers {
	
	  public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int sum = 0;
    	int extra = 0;
    	ListNode ret = null;
    	ListNode p = null;
    	
    	while(l1 != null || l2 != null) {
    		sum = 0;
    		if(l1 != null) {
    			sum += l1.val;
    			l1 = l1.next;
    		}
    		if(l2 != null) {
    			sum += l2.val;
    			l2 = l2.next;
    		}
    		sum += extra; 
    		
    		if(p == null) {
    			p = new ListNode(sum%10);
    			ret = p;
    		} else {
    			p.next = new ListNode(sum%10);
    			p = p.next;
    		}
    		extra = sum/10;
    	}
    	
    	if(extra > 0) {
    		p.next = new ListNode(extra);
    	}
    	return ret;
    }
    
    public static void main(String[] args) {
		AddTwoNumbers atn=new AddTwoNumbers();
		ListNode nod = new ListNode(5);
		ListNode node1 = new ListNode(5);
		ListNode res = atn.addTwoNumbers(nod, node1);
		
		Executors
	}
}
