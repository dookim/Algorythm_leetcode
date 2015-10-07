import java.util.ArrayList;
import java.util.List;

import deleteDuplicates.ListNode;

public class isSymmetric {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val;
	 * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left == null && right == null) {
			return true;
		}
		if((left == null && right != null) && (right != null && left == null)) {
			return false;
		}
		if(left.val != right.val) {
			return false;
		}
		return isSymmetric(left.right, right.left) && isSymmetric(left.right, right.left);
		
	}

	public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}

}
