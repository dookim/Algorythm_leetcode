public class RemoveNthFromEnd {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// 1 -> 2 [1]
	// 1 [1]

	// 0->1 -> 2 [2]

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode fast = head;
		ListNode deleted = head;

		while (n-- > 1) {
			fast = fast.next;
		}

		ListNode before = null;
		
		while (fast.next != null) {
			fast = fast.next;
			before = deleted;
			deleted = deleted.next;
		}
		if (before == null) {
			head = deleted.next;
		} else {
			before.next = deleted.next;
		}
		
		deleted.next = null;
		deleted = null;

		return head;

	}

}
