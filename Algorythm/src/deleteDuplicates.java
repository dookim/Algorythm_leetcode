public class deleteDuplicates {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) {
			return head;
		}
		
		ListNode before = null;
		ListNode p = head;
		ListNode ret = head;
		
		while(p.next != null) {
			if(p.val == p.next.val) {
				ListNode deleted = p;
				p = p.next;
				if(before == null) {
					ret = p;
				} else {
					before.next = p;
				}
				deleted.next = null;
			} else {
				before = p;
				p = p.next;
			}
		}
		
		return ret;
	}

}
