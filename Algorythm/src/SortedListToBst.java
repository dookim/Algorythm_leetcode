
public class SortedListToBst {
	
	 // Definition for singly-linked list.
	  static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	
	  //Definition for a binary tree node.
	  static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 

	
	  static TreeNode makeTree(ListNode from, ListNode to, int size) {
		if(from == to) return new TreeNode(from.val);
		ListNode beforeMiddle = null;
		ListNode middle = from;
		for(int i = 0; i < size/2; ++i) {
			beforeMiddle = middle;
			middle=middle.next;
		}
		ListNode nextMiddle = middle.next;
		TreeNode root = new TreeNode(middle.val);
		
		root.left = makeTree(from, beforeMiddle, size/2);
		if(middle == to) {
			root.right = null;
		}
		else {
			int rightSize = size%2 == 0? size/2 -1 : size/2;
			root.right = makeTree(nextMiddle, to, rightSize);
		}
		
		return root;
	}
    public static TreeNode sortedListToBST(ListNode head) {
    	if(head == null) return null;
        int size = 1;
        ListNode p = head;
        while(p.next != null) {
        	size++;
        	p = p.next;
        }
        return makeTree(head, p, size);
    }
    
    public static void main(String[] args) {
		
		ListNode head1=new ListNode(1);
		head1.next = new ListNode(3);
		sortedListToBST(head1);
		
		
		
 	}
	
	
}
