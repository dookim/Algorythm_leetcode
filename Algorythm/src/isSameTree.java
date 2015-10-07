public class isSameTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) {
			return true;
		}
		if((p != null && q == null) || (p == null && q != null)) {
			return false;
		}
		if((p != null && q != null) && (p.val != q.val)) {
			return false;
		}
		if(!isSameTree(p.left, q.left)) return false;
		if(!isSameTree(p.right, q.right)) return false;
		return true;
	}

}
