import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLinkNodeProblem {

	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		if(root == null) return; 
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.add(root);
		List<TreeLinkNode> list = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			while(!queue.isEmpty()) {
				TreeLinkNode cur = queue.poll();
				if(cur.left != null) list.add(cur.left);
				if(cur.right != null) list.add(cur.right);
			}
			for(int i = 0; i < list.size() - 1; ++i) {
				list.get(i).next = list.get(i);
			}
			queue.addAll(list);
			list.clear();
		}

	}
	
	public static void main(String[] args) {
		TreeLinkNodeProblem problem = new TreeLinkNodeProblem();
		TreeLinkNode node = new TreeLinkNode(1);
		node.left = new TreeLinkNode(2);
		node.right = new TreeLinkNode(3);
		node.left.left = new TreeLinkNode(4);
		node.left.right = new TreeLinkNode(5);
		node.right.left = new TreeLinkNode(6);
		node.right.right = new TreeLinkNode(7);
		problem.connect(node);
		
	}

}
