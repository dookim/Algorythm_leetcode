import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TraverseUsingStack {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private void visit(Stack<TreeNode> stack, Set<TreeNode> visited, List<Integer> list, TreeNode cur) {
		visited.add(cur);
		list.add(cur.val);
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		TreeNode p = null;

		stack.push(root);
		visit(stack, visited, list, root);

		while (!stack.isEmpty()) {
			p = stack.peek();
			if (p.left != null && !visited.contains(p.left)) {
				stack.push(p.left);
				visit(stack, visited, list, p.left);
				continue;
			}
			if (p.right != null && !visited.contains(p.right)) {
				stack.push(p.left);
				visit(stack, visited, list, p.right);
				continue;
			}
			stack.pop();
		}
		return list;
	}

	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> list = new ArrayList<Integer>();
		if (root == null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Set<TreeNode> visited = new HashSet<TreeNode>();
		TreeNode p = null;
		stack.push(root);

		while (!stack.isEmpty()) {
			p = stack.peek();

			if (p.left != null && !visited.contains(p.left)) {
				stack.push(p.left);
				continue;
			}
			
			// 중앙 노드를 방문한다.
			p = stack.pop();
			visit(stack, visited, list, p);

			// 오른쪽 노드는 같은 행동을 반복한다.
			if (p.right != null) {
				stack.push(p.right);
				continue;
			}
		}

		return list;
	}
	
    public List<Integer> postorderTraversal(TreeNode root) {
    	
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Set<TreeNode> visited = new HashSet<TreeNode>();
		TreeNode p = null;
		stack.push(root);
		
		while(!stack.isEmpty()) {
			p = stack.peek();
			if(p.left != null && !visited.contains(p.left)) {
				stack.push(p.left);
				continue;
			}
			if(p.right != null && !visited.contains(p.right)) {
				stack.push(p.right);
				continue;
			}
			p = stack.pop();
			visit(stack, visited, list, p);
		}
		
		return list;
    }

	public static void main(String[] args) {
		new TraverseUsingStack().preorderTraversal(new TreeNode(1));
	}
}
