import java.util.HashSet;
import java.util.Stack;


public class LowestCommonAncestor {
	
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	
	public void setPath(TreeNode finded, TreeNode cur, Stack<TreeNode> stack) {
		if(cur == null) return;
		stack.push(cur);
		if(stack.peek() == finded) {
			return;
		}
		setPath(finded, cur.left, stack);
		if(stack.peek() == finded) {
			return;
		}
		setPath(finded, cur.right, stack);
		if(stack.peek() == finded) {
			return;
		}
		stack.pop();
		
	}
	

	
	public Stack<TreeNode> getPath(TreeNode finded, TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		TreeNode p = root;
		while(true) {
			if(!visited.contains(p)) {
				stack.push(p);
				visited.add(p);
			}
			if(stack.peek() == finded) {
				break;
			}
			if(p.left != null && !visited.contains(p.left)) {
				p = p.left;
				continue;
			}
			if(p.right != null && !visited.contains(p.right)) {
				p = p.right;
				continue;
			}
			stack.pop();
			p=stack.peek();
		}
		return stack;
	}
	
	/*
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root == null) return null;
    	
    	Stack<TreeNode> stack1 = getPath(p, root);
    	Stack<TreeNode> stack2 = getPath(q, root);
    	
    	int minLen = stack1.size() > stack2.size() ? stack2.size() : stack1.size();
    	for(int i = 0; i < minLen; ++i) {
    		if(stack1.get(i) != stack2.get(i)) return stack1.get(i-1);
    	}
    	return minLen == stack1.size() ? stack1.peek() : stack2.peek();
    }
    */
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root == null) return null;
    	if(root.val == p.val || root.val == q.val) {
    		return root;
    	}
    	if(root.val > p.val && root.val < q.val) {
    		return root;
    	}
    	if(root.val < p.val && root.val > q.val) {
    		return root;
    	}
    	if(root.val < p.val && root.val < q.val) {
    		return lowestCommonAncestor(root.right, p, q);
    	}
    	return lowestCommonAncestor(root.left, p, q);
    }
    
    public static void main(String[] args) {
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);
//		root.right = new TreeNode(3);
//		root.right.left = new TreeNode(6);
//		root.right.right = new TreeNode(7);
//		
//		root.right.right.left = new TreeNode(10);
//		root.right.right.right = new TreeNode(11);
//		
//		TreeNode finded = root.right.right.left;
//		Stack<TreeNode> s = new Stack<LowestCommonAncestor.TreeNode>();
//		LowestCommonAncestor lca = new LowestCommonAncestor();
//		lca.setPath(finded, root, s);
//		for(int i = 0; i < s.size(); ++i) {
//			System.out.println(s.get(i).val);
//		}
    	Stack<TreeNode> s = new Stack<LowestCommonAncestor.TreeNode>();
    	for(int i = 0; i < 10000; ++i) {
    		s.push(new TreeNode(10));
    	}
	}
}
