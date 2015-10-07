public class InsertionSortList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// 처음 포인터
		ListNode f = head;
		ListNode e = head;
		ListNode inserted = f.next;
		e.next = null;
		
		while(inserted != null) {
			ListNode before = null;
			ListNode next = inserted.next;
			ListNode p = f;
			while(p != null) {
				if(p.val < inserted.val) {
					before = p;
					p = p.next;
				} else {
					if(before == null) {
						inserted.next = p;
						f = inserted;
					} else {
						before.next = p;
						inserted.next = p;
					}
					break;
				}
			}
			if(p == null) {
				e.next = inserted;
				e = inserted;
				e.next = null;
			}
			inserted = next;
		}
		return f;
	}

}
