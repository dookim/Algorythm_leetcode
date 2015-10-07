import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if(root == null) {
			return ret;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			List<TreeNode> next = new ArrayList<>();
			List<Integer> retTemp = new ArrayList<>();
			while(!queue.isEmpty()) {
				TreeNode cur = queue.poll();
				retTemp.add(cur.val);
				if(cur.left != null) {
					next.add(cur.left);
				}
				if(cur.right != null) {
					next.add(cur.right);
				}
			}
			ret.add(retTemp);
			queue.addAll(next);
		}
		//Collections.reverse(ret);
		return ret;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		List<List<Integer>> result = levelOrderBottom(root);
		System.out.println(result);
		
		
		 
	}
}
